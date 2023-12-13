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
<link rel="stylesheet" href="css/dropbox.css">
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
					<div class="col-md-3">
						<label style="margin-top:30px; font-size:20px;"><b>Tiêu đề</b></label><br>
						<label style="margin-top:30px; font-size:20px;"><b>Giảng viên đảm nhận:</b></label><br>
						<label style="margin-top:30px; font-size:20px;"><b>Danh sách sinh viên:</b></label>
					</div>
					<div class="col-md-7">
						<textarea disabled style="margin-top:30px; font-size:20px; border:2px solid; width:300px" rows=1>ABC</textarea>
						<textarea disabled style="margin-top:10px; font-size:20px; border:2px solid; width:300px" rows=1>ABC</textarea>
						<textarea disabled style="margin-top:10px; font-size:20px; border:2px solid; width:300px" rows=1>ABC</textarea>
						<textarea disabled style="margin-top:10px; font-size:20px; border:2px solid; width:300px" rows=1>ABC</textarea>
						<textarea disabled style="margin-top:10px; font-size:20px; border:2px solid; width:300px" rows=1>ABC</textarea>
						<textarea disabled style="margin-top:10px; font-size:20px; border:2px solid; width:300px" rows=1>ABC</textarea>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-3">
						<label style="margin-top:30px; font-size:20px;"><b>Kinh phí:</b></label><br>
						<label style="margin-top:30px; font-size:20px;"><b>Mô tả:</b></label>
					</div>
					<div class="col-md-7">
						<textarea disabled style="margin-top:25px; font-size:20px; border:2px solid; width:300px" rows=1>ABC</textarea>
						<textarea disabled id="mota" name="mota"
							style="border:2px solid; margin-top: 20px; font-size: 20px; width: 500px; height: 250px;">ABC</textarea>
					</div>
				</div>
				<div class="row">
					<div class="col-md-10"></div>
					<div class="col-md-1">
					<button style="font-size:20px; border:2px solid; border-radius:15% ; background-color:#ABC4FF" type="button">Admit</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>