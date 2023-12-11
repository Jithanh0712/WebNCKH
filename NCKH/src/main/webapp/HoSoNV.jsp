<%@page contentType="text/html; charset=UTF-8"%>
<%@page language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="Models.NVPQLKH" %>
<%@ page import="DAO.NVPQLKHDAO" %>

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
	<jsp:include page="./headerNV.jsp"></jsp:include>
	<jsp:include page="./tabNV.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<jsp:include page="./listlink.jsp"></jsp:include>
			</div>
			<div class="col-md-9">
				<h2 class="d-flex align-items-center justify-content-center">THÔNG TIN CÁ NHÂN</h2>
				<form class="personal-info-form" action="update" method="post">
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
								<label for="manv">Mã Nhân Viên:</label> 
							</div>

							<div class="form-group">
								<label for="tennv">Tên Nhân Viên:</label>
								
							</div>
							<div class="form-group">
								<label for="kinhnghiem">Kinh nghiệm:</label>
							</div>
							<div class="form-group">
								<label for="email">Email:</label>
							</div>
							
							<div class="form-group">
								<label for="id">ID:</label>
							</div>
						</div>

						<div class="col-md-6">
							<div class="form-group"> 
								<input type="text" id="manv" name="manv" maxlength="10" class="form-control" value="<c:out value='${nvpqlkh.maNV}'/>">
								
							</div>
							<div class="form-group">
								<input type="text" id="tennv" name="tennv" maxlength="30" class="form-control" value="<c:out value='${nvpqlkh.tenNV}'/>">
							</div>
							<div class="form-group">
								<input type="text" id="kinhnghiem" name="kinhnghiem" class="form-control" value="<c:out value='${Integer.parseInt(nvpqlkh.kinhNghiem)}'/>">
							</div>
							<div class="form-group">
								<input type="text" id="email" name="email" maxlength="50" class="form-control" value="<c:out value='${nvpqlkh.email}'/>">
							</div>
							<div class="form-group">
								<input type="text" id="id" name="id" maxlength="8" class="form-control" value="<c:out value='${nvpqlkh.iD}'/>">
							</div>
						</div>
					</div>
					<div class="d-flex justify-content-end mb-3 col-md-9"
					style="margin-top: 10px">
					<div>
						<button type = "submit" class = "btn btn-primary">Save</button>
					</div>
				</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>