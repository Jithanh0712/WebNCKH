<%@page contentType="text/html; charset=UTF-8"%>
<%@page language="java"%>
<%@ page import="Models.GIANGVIEN, DAO.GiangVienDAO" %>

<%
    String maGV = "GV001";
    GIANGVIEN gv = GiangVienDAO.layThongTinGV(maGV);
%>

<html>
<head>
	<meta charset="UTF-8">
	<title>Hồ sơ</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <style><%@include file="/css/hosogv.css"%></style>
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
				<h2 class="d-flex align-items-center justify-content-center">THÔNG TIN CÁ NHÂN</h2>
				<form class="personal-info-form" action="thongtingv" method="POST">
					<div class="row">
						<div class="col-md-3">
							<div class="row">
								<div class="item">
									<img
										src="https://i.pinimg.com/564x/49/2d/09/492d0995bd45a945b2b5e96833e7feec.jpg"
										alt="Image 2">
								</div>

							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label for="magv">Mã Giảng Viên:</label> 
							</div>

							<div class="form-group">
								<label for="tengv">Tên Giảng Viên:</label>
							</div>
							<div class="form-group">
								<label for="trinhdo">Trình độ:</label>
							</div>
							<div class="form-group">
								<label for="id">ID:</label>
							</div>
							<div class="form-group">
								<label for="makhoa">Mã khoa:</label>
							</div>
						</div>

						<div class="col-md-6">
							<div class="form-group"> 
								<input type="text" id="magv" name="magv" maxlength="10" class="form-control" value="<%= gv.getMaGV()%>">
								
							</div>
							<div class="form-group">
								<input type="text" id="tengv" name="tengv" maxlength="30" class="form-control" value="<%= gv.getTenGV()%>">
							</div>
							<div class="form-group">
								<input type="text" id="trinhdo" name="trinhdo" maxlength="15" class="form-control" value="<%= gv.getTrinhDo()%>">
							</div>
							<div class="form-group"> 
								<input type="text" id="id" name="id" maxlength="10" class="form-control" value="<%= gv.getiD()%>">
							</div>
							
							<div class="form-group"> 
								<input type="text" id="makhoa" name="makhoa" maxlength="10" class="form-control" value="<%= gv.getMaKhoa()%>">
							</div>
						</div>
					</div>
					<div class="d-flex justify-content-end mb-3 col-md-9"
					style="margin-top: 10px">
					<div>
						<input type="button" value="Chỉnh sửa" class = "setbtn"> 
						<input type="submit" value="Lưu" class = "setbtn" onclick="window.location.href='HoSoGV.jsp'">
					</div>
				</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>