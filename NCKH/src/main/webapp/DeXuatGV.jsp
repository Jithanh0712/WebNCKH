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
	<jsp:include page="./header.jsp"></jsp:include>
	<jsp:include page="./tabGV.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<jsp:include page="./listlink.jsp"></jsp:include>
			</div>
			<div class="col-md-9">
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
					<div class="col-md-10">
						<label style="margin-top: 50px; font-size: 20px; color: black"><b>Báo cáo chi tiết</b></label>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-10">
						<div class="rectangle">
							<form method="post" action="UploadFileServlet"
								enctype="multipart/form-data"
								id="uploadform">
								Select file to upload: <input type="file" name="file">
							</form>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-11"></div>
					<div class="col-md-1">
						<form method="post" action="DeXuatGVController">
							<input type="submit" value="Submit"
								style="border: solid; font-size: 20;" id="fileupload">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>