<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xác nhận đăng ký</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/dropbox.css">
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
			<form action="updateDK" method="post" accept-charset="UTF-8">
				<div class="row">
					<div class="col-md-3">
						<label style="margin-top:30px; font-size:20px;"><b>Tiêu đề</b></label><br>
					</div>
					<div class="col-md-7">
						<textarea readonly
							style="margin-top: 30px; font-size: 20px; border: 2px solid; width: 300px"
							rows=1 id="tendedai">${detai.tieuDe}</textarea>
					</div>
				</div>
				<c:forEach var="listSV" items="${listSV}">
				<div class="row">
					<div class="col-md-3">
						<label style="margin-top:30px; font-size:20px;"><b>Giảng viên đảm nhận:</b></label><br>
						<label style="margin-top:30px; font-size:20px;"><b>Danh sách sinh viên:</b></label>
					</div>
					<div class="col-md-3">
						<textarea readonly
							style="margin-top: 30px; font-size: 20px; border: 2px solid; width: 250px"
							rows=1 id="GV">${giangvien.tenGV}</textarea>
						
						<textarea readonly
							style="margin-top: 10px; font-size: 20px; border: 2px solid; width: 250px"
							rows=1 id="SV1" placeholder="Tên sinh viên"> ${listSV.hoTen}</textarea>
					</div>
					<div class="col-md-3">
						<textarea readonly
							style="margin-left: 5px; margin-top: 30px; font-size: 20px; border: 2px solid; width: 100px"
							rows=1 id="MaGV">${giangvien.maGV}</textarea><br>
						
						<textarea readonly
							style="margin-left: 5px; margin-top: 10px; font-size: 20px; border: 2px solid; width: 100px"
							rows=1 id="MaSV1" placeholder="mssv"> ${listSV.mSSV}</textarea>
						<textarea readonly
							style="margin-left: 5px; margin-top: 10px; font-size: 20px; border: 2px solid; width: 110px"
							rows=1 id="NKSV1" placeholder="Niên khóa"> ${listSV.nienKhoa}</textarea><br>
					</div>
					<div class="col-md-3">
						<textarea readonly
							style="margin-top:87px; font-size: 20px; border: 2px solid; width: 200px; height:40px;"
							rows=1 id="KhoaSV1" > ${listSV.tenKhoa}</textarea>
						
					</div>
				
				</div>
				</c:forEach>
				<div class="row">
					<div class="col-md-3">
						<label style="margin-top:30px; font-size:20px;"><b>Kinh phí:</b></label><br>
						<label style="margin-top:30px; font-size:20px;"><b>Mô tả:</b></label>
					</div>
					<div class="col-md-7">
						<textarea readonly style="margin-top:25px; font-size:20px; border:2px solid; width:300px" rows=1> ${detai.kinhPhi}</textarea>
						<textarea readonly id="mota" name="mota"
							style="border:2px solid; margin-top: 20px; font-size: 20px; width: 500px; height: 250px;"> ${detai.moTa}</textarea>
					</div>
				</div>
				<div class="row">
					<div class="col-md-8"></div>
					<div class="col-md-2">
					<button style="font-size:20px; border:2px solid; border-radius:15% ; background-color:#ABC4FF" type="submit">Xác nhận</button>
					</div>
				</div>
			</form>
			</div>
		</div>
	</div>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>