<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đề xuất đề tài</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
	<style><%@include file="/css/dropbox.css"%></style>
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
				<form action = "DangDeTai" method = "post">
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-2">
						<label for="tendetai"
							style="margin-top: 100px; font-size: 20px; color: black"><b>Tên đề tài</b></label>
					</div>
					<div class="col-md-8">
						<input type="text" id="tendetai" name="tendetai"
							style="border: solid; margin-top: 100px; font-size: 20px; width: 500px;">
					</div>
				</div>
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-2">
						<label for="mota"
							style="margin-top: 50px; font-size: 20px; color: black"><b>Mô tả</b></label>
					</div>
					<div class="col-md-8">
						<textarea id="mota" name="mota"
							style="border: solid; margin-top: 50px; font-size: 20px; width: 500px; height: 250px;"></textarea>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-2">
						<label for="kinhphi"
							style="margin-top: 50px; font-size: 20px; color: black"><b>Kinh phí</b></label>
					</div>
					<div class="col-md-8">
						<input type="text" id="kinhphi" name="kinhphi"
							style="border: solid; margin-top: 50px; font-size: 20px; width: 500px;">
					</div>
				</div>
				<div class="row">
					<div class="col-md-11"></div>
					<div class="col-md-1">
							<input type="submit" value="Submit"
								style="border: solid; font-size: 20;" id="fileupload">
					</div>
				</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>