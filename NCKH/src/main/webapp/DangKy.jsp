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
<script>
	function activate() {
		var GV = document.getElementById("GV");
		for(var i = 1; i < 5; i++){
			var SV = document.getElementById("SV" + i.toString());
			SV.disabled=false;
		}
		var suabtn = document.getElementById("sua");
		var thembtn = document.getElementById("them");
		var luubtn = document.getElementById("luu");
		var xoabtn = document.getElementById("xoa");
		GV.disabled=false;
		thembtn.disabled=false;
		luubtn.disabled=false;
		xoabtn.disabled=false;
		suabtn.disabled=true;
	}
	function add(){
		for(var i = 2; i < 5; i++){
			var SV = document.getElementById("SV" + i.toString());
			if(SV.style.display === "none"){
				SV.style.display = "block";
				SV.value="";
				break;
			}
		}
	}
	function disable() {
		var GV = document.getElementById("GV");
		for(var i = 1; i < 5; i++){
			var SV = document.getElementById("SV" + i.toString());
			SV.disabled=true;
		}
		var suabtn = document.getElementById("sua");
		var thembtn = document.getElementById("them");
		var luubtn = document.getElementById("luu");
		var xoabtn = document.getElementById("xoa");
		GV.disabled=true;
		thembtn.disabled=true;
		luubtn.disabled=true;
		xoabtn.disabled=true;
		suabtn.disabled=false;
	}
	function deleteSV(){
		for(var i = 4; i > 1; i--){
			var SV = document.getElementById("SV" + i.toString());
			if(SV.style.display === "block"){
				SV.style.display = "none";
				SV.value="";
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
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-3">
						<label style="margin-top:80px; font-size:20px;"><b>Giảng viên đảm nhận:</b></label><br>
						<label style="margin-top:30px; font-size:20px;"><b>Danh sách sinh viên:</b></label>
					</div>
					<div class="col-md-4">
						<textarea disabled style="margin-top:80px; font-size:20px; border:2px solid; width:300px" rows=1 id="GV">ABC</textarea>
						<textarea disabled style="margin-top:10px; font-size:20px; border:2px solid; width:300px" rows=1 id="SV1">ABC</textarea>
						<textarea disabled style="margin-top:10px; font-size:20px; border:2px solid; width:300px; display:none;" rows=1 id="SV2">ABC</textarea>
						<textarea disabled style="margin-top:10px; font-size:20px; border:2px solid; width:300px; display:none;" rows=1 id="SV3">ABC</textarea>
						<textarea disabled style="margin-top:10px; font-size:20px; border:2px solid; width:300px; display:none;" rows=1 id="SV4">ABC</textarea>
					</div>
					<div class="col-md-1">
						<div class="row">
							<button type="button" onclick="activate()"
							style="margin-top:70px; border:1px solid; height:40px;" id="sua">Sửa</button>
						</div>
						<div class="row">
							<button disabled type="button" onclick="add()"
							style="margin-top:7px; border:1px solid; height:40px;" id="them">Thêm</button>
						</div>
						<div class="row">
							<button disabled type="button" onclick="disable()"
							style="margin-top:7px; border:1px solid; height:40px;" id="luu">Lưu</button>
						</div>
						<div class="row">
							<button disabled type="button" onclick="deleteSV()"
							style="margin-top:7px; border:1px solid; height:40px;" id="xoa">Xóa</button>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-4">
						<div style="margin-top: 40px; height: 100px" class="rectangle">
							<p style="font-size: 20px; white-space: pre;">Ấn để tải về tập tin </p>
							<a onmouseover="this.style.color='red'" onmouseout="this.style.color=''" 
							style="font-size: 20px; text-decoration: underline;" class="button" onclick="downloadFile()">tenthumuc.abc</a>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-10"></div>
					<div class="col-md-2">
					<button style="font-size:20px; border:2px solid; border-radius:15% ; background-color:#ABC4FF" type="button">Đăng ký</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>