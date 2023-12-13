<%@page contentType="text/html; charset=UTF-8"%>
<%@page language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import = "com.google.gson.Gson"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Đặt deadline</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">

</head>

<body>
	<jsp:include page="./headerNV.jsp"></jsp:include>
	<jsp:include page="./tabNV.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<jsp:include page="./listlink.jsp"></jsp:include>
			</div>
			<div class="col-md-9" style = "margin-top: 20px">
				<div class="form-group">
					<label for="magv" style= "color:black; font-size: 24px;">Thời gian: </label>
				</div>
				<div class="form-group">
					<input type="date" id="ngaybdmoi" name="ngaybdmoi" maxlength="30" class="form-control">
				</div>
				<div class="form-group">
					<input type="date" id="ngayktmoi" name="ngayktmoi" maxlength="30" class="form-control">
				</div>
				<div class="form-group">
					<label for="magv" style= "color:black; font-size: 24px;">Thông báo: </label>
				</div>
				<div class="form-group">
					<label for="TenThongBao" style = "color: black; font-size: 20px; margin-top: 15px;">Tên thông báo</label>
		           	<input type="text" class="form-control" id="TenThongBao" name="TenThongBao" 
		           	style = "width:500px; height: 50px; margin-top: 15px;" placeholder="Nhập tiêu đề thông báo">
				</div>
				<input type="text" id="NoiDung" name="NoiDung" class="my-class" style = "margin-top: 15px;" placeholder="Nội dung">
				<div class="form-group">
					<input type="button" style = "margin-top: 15px; background-color: #ABC4FF; margin-left: 65%;
  						border: 2px solid #ABC4FF; border-radius: 5px; font-size: 13pt; color: black;"value="Commit">
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>