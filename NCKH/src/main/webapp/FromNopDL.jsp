<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<meta charset="UTF-8">
	<title>Nộp Bài</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
	<style><%@include file="/css/dropbox.css"%></style>
</head>

<body>
	<jsp:include page="./header.jsp"></jsp:include>
	<jsp:include page="./tabGV.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<jsp:include page="./listlink.jsp"></jsp:include>
			</div>
			<div class="col-md-9">
				<div class="col-md-3">
					<form action="/nopbaocao" method="post">
						
					    <textarea name="my-text-area-${thongbao.maThongBao}" id="my-text-area-${thongbao.maThongBao}" cols="125"
					        rows="7.5" readonly>Tên thông báo: ${thongbao.tenThongBao}
Nội dung: ${thongbao.noiDung}
</textarea>
					
						<div class="form-group">
							<label for="NgayBatDau" style= "color:black;">Ngày bắt đầu:</label> 
							<input type="text" id="NgayBatDau" name="NgayBatDau" class="form-control" value="<c:out value='${thoigian.ngayBatDau.toLocalDate().toString()}'/>" readonly>
						</div>
		
						<div class="form-group">
							<label for="NgayKetThuc" style= "color:black;">Ngày kết thúc:</label>
							<input type="text" id="NgayKetThuc" name="NgayKetThuc" class="form-control" value="<c:out value='${thoigian.ngayKetThuc.toLocalDate().toString()}'/>" readonly>
						</div>
					</form>
					<div class="rectangle" style = "margin-top: 10px">
						<form method="post" action="UploadFileServlet"
							enctype="multipart/form-data"
							id="uploadform">
							Select file to upload: <input type="file" name="file">
						</form>
					</div>
					<input type="submit" value="Submit" 
					style="border: solid; font-size: 20; margin-top: 10px; margin-left: 300%;" id="fileupload">
				</div>
			</div>
		</div>
	</div>
	<script>
		document.getElementById('fileupload').addEventListener('click',function() 
				{
					document.getElementById('uploadform').submit();
				});
	</script>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>