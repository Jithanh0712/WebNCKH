package Controllers;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/UploadFileServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
                 maxFileSize = 1024 * 1024 * 50,      // 50 MB
                 maxRequestSize = 1024 * 1024 * 100)   // 100 MB
public class UploadFileController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Path uploadDirectory = Paths.get(getServletContext().getRealPath("/").toString() + "/webapp/files");
        System.out.println(uploadDirectory.toString());
        if (!Files.exists(uploadDirectory)) {
            Files.createDirectories(uploadDirectory);
        }
        String fileName = null;
        for (Part part : request.getParts()) {
            fileName = getFileName(part);
            if (!fileName.isEmpty()) {
                Path uploadedFile = uploadDirectory.resolve(fileName);
                try (InputStream inputStream = part.getInputStream()) {
                    Files.copy(inputStream, uploadedFile, StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }
        HttpSession session = request.getSession();
        session.setAttribute("filename", uploadDirectory+"\\"+fileName);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/FromDL/nopbaocao");
		dispatcher.forward(request, response);
    }

    private String getFileName(Part part) {
        for (String contentDisposition : part.getHeader("content-disposition").split(";")) {
            if (contentDisposition.trim().startsWith("filename")) {
                return contentDisposition.substring(contentDisposition.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return "";
    }
}