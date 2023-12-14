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
					<div class="col-md-3">
						<label style="margin-top:30px; font-size:20px;"><b>Tiêu đề</b></label><br>
					</div>
					<div class="col-md-7">
						<textarea disabled disabled
							style="margin-top: 30px; font-size: 20px; border: 2px solid; width: 300px"
							rows=1 id="tendedai"></textarea>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3">
						<label style="margin-top:30px; font-size:20px;"><b>Giảng viên đảm nhận:</b></label><br>
						<label style="margin-top:30px; font-size:20px;"><b>Danh sách sinh viên:</b></label>
					</div>
					<div class="col-md-3">
						<textarea disabled
							style="margin-top: 30px; font-size: 20px; border: 2px solid; width: 250px"
							rows=1 id="GV"></textarea>
						<textarea disabled
							style="margin-top: 10px; font-size: 20px; border: 2px solid; width: 250px"
							rows=1 id="SV1" placeholder="Tên sinh viên"></textarea>
						<textarea disabled
							style="margin-top: 10px; font-size: 20px; border: 2px solid; width: 250px; display: none;"
							rows=1 id="SV2" placeholder="Tên sinh viên"></textarea>
						<textarea disabled
							style="margin-top: 10px; font-size: 20px; border: 2px solid; width: 250px; display: none;"
							rows=1 id="SV3" placeholder="Tên sinh viên"></textarea>
						<textarea disabled
							style="margin-top: 10px; font-size: 20px; border: 2px solid; width: 250px; display: none;"
							rows=1 id="SV4" placeholder="Tên sinh viên"></textarea>
					</div>
					<div class="col-md-3">
						<textarea disabled
							style="margin-left: 5px; margin-top: 30px; font-size: 20px; border: 2px solid; width: 100px"
							rows=1 id="MaGV"></textarea><br>
						<textarea disabled
							style="margin-left: 5px; margin-top: 10px; font-size: 20px; border: 2px solid; width: 100px"
							rows=1 id="MaSV1" placeholder="mssv"></textarea>
						<textarea disabled
							style="margin-left: 5px; margin-top: 10px; font-size: 20px; border: 2px solid; width: 110px"
							rows=1 id="NKSV1" placeholder="Niên khóa"></textarea><br>
						<textarea disabled
							style="margin-left: 5px; margin-top: 10px; font-size: 20px; border: 2px solid; width: 100px; display: none;"
							rows=1 id="MaSV2" placeholder="mssv"></textarea>
						<textarea disabled
							style="margin-left: 5px; margin-top: 10px; font-size: 20px; border: 2px solid; width: 110px; display: none;"
							rows=1 id="NKSV2" placeholder="Niên khóa"></textarea><br>
						<textarea disabled
							style="margin-left: 5px; margin-top: 10px; font-size: 20px; border: 2px solid; width: 100px; display: none;"
							rows=1 id="MaSV3" placeholder="mssv"></textarea>
						<textarea disabled
							style="margin-left: 5px; margin-top: 10px; font-size: 20px; border: 2px solid; width: 110px; display: none;"
							rows=1 id="NKSV3" placeholder="Niên khóa"></textarea><br>
						<textarea disabled
							style="margin-left: 5px; margin-top: 10px; font-size: 20px; border: 2px solid; width: 100px; display: none;"
							rows=1 id="MaSV4" placeholder="mssv"></textarea>
						<textarea disabled
							style="margin-left: 5px; margin-top: 10px; font-size: 20px; border: 2px solid; width: 110px; display: none;"
							rows=1 id="NKSV4" placeholder="Niên khóa"></textarea>
					</div>
					<div class="col-md-3">
						<select disabled
							style="margin-top:87px; font-size: 20px; border: 2px solid; width: 200px; height:40px;"
							id="KhoaSV1">
							<option disabled selected value="">Khoa...</option>
							</select>
						<select disabled
							style="margin-top:17px; font-size: 20px; border: 2px solid; width: 200px; height:40px; display: none;"
							id="KhoaSV2">
							<option disabled selected value="">Khoa...</option>
							</select>
						<select disabled
							style="margin-top:17px; font-size: 20px; border: 2px solid; width: 200px; height:40px; display: none;"
							id="KhoaSV3">
							<option disabled selected value="">Khoa...</option>
							</select>
						<select disabled
							style="margin-top:17px; font-size: 20px; border: 2px solid; width: 200px; height:40px; display: none;"
							id="KhoaSV4">
							<option disabled selected value="">Khoa...</option> 
							</select>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3">
						<label style="margin-top:30px; font-size:20px;"><b>Kinh phí:</b></label><br>
						<label style="margin-top:30px; font-size:20px;"><b>Mô tả:</b></label>
					</div>
					<div class="col-md-7">
						<textarea disabled style="margin-top:25px; font-size:20px; border:2px solid; width:300px" rows=1></textarea>
						<textarea disabled id="mota" name="mota"
							style="border:2px solid; margin-top: 20px; font-size: 20px; width: 500px; height: 250px;"></textarea>
					</div>
				</div>
				<div class="row">
					<div class="col-md-8"></div>
					<div class="col-md-2">
					<button style="font-size:20px; border:2px solid; border-radius:15% ; background-color:#ABC4FF" type="submit">Xác nhận</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>