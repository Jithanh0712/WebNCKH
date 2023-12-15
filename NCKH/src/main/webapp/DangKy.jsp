<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<style><%@include file="../css/dropbox.css"%></style>
<script>
	function activate() {
		for(var i = 1; i < 5; i++){
			var SV = document.getElementById("SV" + i.toString());
			SV.disabled=false;
			var MSSV = document.getElementById("MaSV" + i.toString());
			MSSV.disabled=false;
			var NK = document.getElementById("NKSV" + i.toString());
			NK.disabled=false;
			var Khoa = document.getElementById("KhoaSV" + i.toString());
			Khoa.disabled=false;
		}
		var suabtn = document.getElementById("sua");
		var thembtn = document.getElementById("them");
		var luubtn = document.getElementById("luu");
		var xoabtn = document.getElementById("xoa");
		thembtn.disabled=false;
		luubtn.disabled=false;
		xoabtn.disabled=false;
		suabtn.disabled=true;
	}
	function add(){
		for(var i = 2; i < 5; i++){
			var SV = document.getElementById("SV" + i.toString());
			var MSSV = document.getElementById("MaSV" + i.toString());
			var NK = document.getElementById("NKSV" + i.toString());
			var Khoa = document.getElementById("KhoaSV" + i.toString());
			if(SV.style.display === "none"){
				SV.style.display = "initial";
				SV.value="";
				MSSV.style.display = "initial";
				MSSV.value="";
				NK.style.display = "initial";
				NK.value="";
				Khoa.style.display = "initial";
				Khoa.value="";
				break;
			}
		}
	}
	function disable() {
		for(var i = 1; i < 5; i++){
			var SV = document.getElementById("SV" + i.toString());
			SV.disabled=true;
			var MSSV = document.getElementById("MaSV" + i.toString());
			MSSV.disabled=true;
			var NK = document.getElementById("NKSV" + i.toString());
			NK.disabled=true;
			var Khoa = document.getElementById("KhoaSV" + i.toString());
			Khoa.disabled=true;
		}
		var suabtn = document.getElementById("sua");
		var thembtn = document.getElementById("them");
		var luubtn = document.getElementById("luu");
		var xoabtn = document.getElementById("xoa");
		thembtn.disabled=true;
		luubtn.disabled=true;
		xoabtn.disabled=true;
		suabtn.disabled=false;
	}
	function deleteSV(){
		for(var i = 4; i > 1; i--){
			var SV = document.getElementById("SV" + i.toString());
			var MSSV = document.getElementById("MaSV" + i.toString());
			var NK = document.getElementById("NKSV" + i.toString());
			var Khoa = document.getElementById("KhoaSV" + i.toString());
			if(SV.style.display === "initial"){
				SV.style.display = "none";
				SV.value="";
				MSSV.style.display = "none";
				MSSV.value="";
				NK.style.display = "none";
				NK.value="";
				Khoa.style.display = "none";
				Khoa.value="";
				break;
			}
		}
	}
	function downloadFile() {
		var a = document.createElement('a');
		a.href = 'XemChiTiet.jsp';
		a.download = 'test.jsp';
		document.body.appendChild(a);
		a.click();
		document.body.removeChild(a);
	}
</script>
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
				<form method="post" action="${pageContext.request.contextPath}/dangky">
				<div class="row">
					<div class="col-md-3">
						<label style="margin-top:30px; font-size:20px;"><b>Tiêu đề</b></label><br>
					</div>
					<div class="col-md-7">
						<textarea disabled disabled
							style="margin-top: 30px; font-size: 20px; border: 2px solid; width: 300px"
							rows=1 id="tendedai">${detai.tieuDe}</textarea>
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
							rows=1 id="GV">${giangvien.tenGV}</textarea>
						<textarea disabled
							style="margin-top: 10px; font-size: 20px; border: 2px solid; width: 250px"
							rows=1 id="SV1" name="SV1" placeholder="Tên sinh viên"></textarea>
						<textarea disabled
							style="margin-top: 10px; font-size: 20px; border: 2px solid; width: 250px; display: none;"
							rows=1 id="SV2" name="SV2" placeholder="Tên sinh viên"></textarea>
						<textarea disabled
							style="margin-top: 10px; font-size: 20px; border: 2px solid; width: 250px; display: none;"
							rows=1 id="SV3" name="SV3" placeholder="Tên sinh viên"></textarea>
						<textarea disabled
							style="margin-top: 10px; font-size: 20px; border: 2px solid; width: 250px; display: none;"
							rows=1 id="SV4" name="SV4" placeholder="Tên sinh viên"></textarea>
					</div>
					<div class="col-md-3">
						<textarea disabled
							style="margin-left: 5px; margin-top: 30px; font-size: 20px; border: 2px solid; width: 100px"
							rows=1 id="MaGV">${giangvien.maGV}</textarea><br>
						<textarea disabled
							style="margin-left: 5px; margin-top: 10px; font-size: 20px; border: 2px solid; width: 100px"
							rows=1 id="MaSV1" name="MaSV1" placeholder="mssv"></textarea>
						<textarea disabled
							style="margin-left: 5px; margin-top: 10px; font-size: 20px; border: 2px solid; width: 110px"
							rows=1 id="NKSV1" name="NKSV1" placeholder="Niên khóa"></textarea><br>
						<textarea disabled
							style="margin-left: 5px; margin-top: 10px; font-size: 20px; border: 2px solid; width: 100px; display: none;"
							rows=1 id="MaSV2" name="MaSV2" placeholder="mssv"></textarea>
						<textarea disabled
							style="margin-left: 5px; margin-top: 10px; font-size: 20px; border: 2px solid; width: 110px; display: none;"
							rows=1 id="NKSV2" name="NKSV2" placeholder="Niên khóa"></textarea><br>
						<textarea disabled
							style="margin-left: 5px; margin-top: 10px; font-size: 20px; border: 2px solid; width: 100px; display: none;"
							rows=1 id="MaSV3" name="MaSV3" placeholder="mssv"></textarea>
						<textarea disabled
							style="margin-left: 5px; margin-top: 10px; font-size: 20px; border: 2px solid; width: 110px; display: none;"
							rows=1 id="NKSV3" name="NKSV3" placeholder="Niên khóa"></textarea><br>
						<textarea disabled
							style="margin-left: 5px; margin-top: 10px; font-size: 20px; border: 2px solid; width: 100px; display: none;"
							rows=1 id="MaSV4" name="MaSV4" placeholder="mssv"></textarea>
						<textarea disabled
							style="margin-left: 5px; margin-top: 10px; font-size: 20px; border: 2px solid; width: 110px; display: none;"
							rows=1 id="NKSV4" name="NKSV4" placeholder="Niên khóa"></textarea>
					</div>
					<div class="col-md-3">
						<select disabled
							style="margin-top:87px; font-size: 20px; border: 2px solid; width: 200px; height:40px;"
							id="KhoaSV1" name="KhoaSV1">
							<option disabled selected value="">Khoa...</option>
							<c:forEach items="${khoas}" var="item">
								<option value="${item.maKhoa}">${item.tenKhoa}</option>
							</c:forEach>
						</select>
						<select disabled
							style="margin-top:17px; font-size: 20px; border: 2px solid; width: 200px; height:40px; display: none;"
							id="KhoaSV2" name="KhoaSV2">
							<option disabled selected value="">Khoa...</option>
							<c:forEach items="${khoas}" var="item">
								<option value="${item.maKhoa}">${item.tenKhoa}</option>
							</c:forEach>
							</select>
						<select disabled
							style="margin-top:17px; font-size: 20px; border: 2px solid; width: 200px; height:40px; display: none;"
							id="KhoaSV3" name="KhoaSV3">
							<option disabled selected value="">Khoa...</option>
							<c:forEach items="${khoas}" var="item">
								<option value="${item.maKhoa}">${item.tenKhoa}</option>
							</c:forEach>
							</select>
						<select disabled
							style="margin-top:17px; font-size: 20px; border: 2px solid; width: 200px; height:40px; display: none;"
							id="KhoaSV4" name="KhoaSV4">
							<option disabled selected value="">Khoa...</option> 
							<c:forEach items="${khoas}" var="item">
								<option value="${item.maKhoa}">${item.tenKhoa}</option>
							</c:forEach>
							</select>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-7">
							<button type="button" onclick="activate()"
							style="margin-top:10px; border:1px solid; height:40px; width:70px;" id="sua">Sửa</button>
							<button disabled type="button" onclick="add()"
							style="margin-top:10px; border:1px solid; height:40px; width:70px;" id="them">Thêm</button>
							<button disabled type="button" onclick="disable()"
							style="margin-top:10px; border:1px solid; height:40px; width:70px;" id="luu">Lưu</button>
							<button disabled type="button" onclick="deleteSV()"
							style="margin-top:10px; border:1px solid; height:40px; width:70px;" id="xoa">Xóa</button>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3">
						<label style="margin-top:30px; font-size:20px;"><b>Kinh phí:</b></label><br>
						<label style="margin-top:30px; font-size:20px;"><b>Mô tả:</b></label>
					</div>
					<div class="col-md-7">
						<textarea disabled style="margin-top:25px; font-size:20px; border:2px solid; width:300px" rows=1>${detai.kinhPhi}</textarea>
						<textarea disabled id="mota" name="mota"
							style="border:2px solid; margin-top: 20px; font-size: 20px; width: 500px; height: 250px;">${detai.moTa}</textarea>
					</div>
				</div>
				<div class="row">
					<div class="col-md-8"></div>
					<div class="col-md-2">
					<button style="font-size:20px; border:2px solid; border-radius:15% ; background-color:#ABC4FF" type="submit" onclick="activate()">Đăng ký</button>
					</div>
				</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>