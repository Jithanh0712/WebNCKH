<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Models.TAIKHOAN"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <style><%@include file="/css/login.css"%></style>
</head>
<body>
	<button type="submit" class="btnTC btn-primary" onclick="window.location.href='TrangChu.jsp'">Trang chủ</button>
    <div class="container">
        <h1>Đăng nhập</h1>
		 <%
		  String errMsg = (String) request.getAttribute("errMsg");
		  TAIKHOAN tk = (TAIKHOAN) session.getAttribute("taikhoan");
		  %>
		  <!-- Check error Msg -->
		  <%
		  if (errMsg != null) {
		  %>
		  <p style="color: red; font-weight: bold"><%=errMsg%></p>
		  <%
		  }
		  %>
        <form action="<%=request.getContextPath()%>/login" method="post">
            <div class="form-group">
                <label for="username">Tên đăng nhập</label>
                <input type="text" name="IDDangNhap" id="IDDangNhap" class="form-control">
            </div>
            <div class="form-group">
                <label for="password">Mật khẩu</label>
                <input type="password" name="MatKhau" id="MatKhau" class="form-control">
            </div>
            <button type="submit" class="btnDN btn-primary">Đăng nhập</button>
        </form>
    </div>

</body>
</html>
