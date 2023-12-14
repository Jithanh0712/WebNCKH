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
<style><%@include file="/css/dropbox.css"%></style>
</head>
<body>
	<jsp:include page="./header.jsp"></jsp:include>
	<jsp:include page="./tabNV.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<jsp:include page="./listlink.jsp"></jsp:include>
			</div>
			<div class="col-md-9">
				<form method="post" action="XacNhanDeXuat">
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-2">
						<label for="tendetai"
							style="margin-top: 100px; font-size: 20px; color: black"><b>Tên đề tài</b></label>
					</div>
					<div class="col-md-8">
						<input disabled type="text" id="tendetai" name="tendetai" 
							style="border: solid; margin-top: 100px; font-size: 20px; width: 500px;" value="<c:out value='${dexuat.tieuDeDeTai}'/>">
					</div>
				</div>
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-2">
						<label for="mota"
							style="margin-top: 50px; font-size: 20px; color: black"><b>Mô tả</b></label>
					</div>
					<div class="col-md-8">
						<textarea disabled id="mota" name="mota"
							style="border: solid; margin-top: 50px; font-size: 20px; width: 500px; height: 250px;"><c:out value='${dexuat.moTaDeTai}'/></textarea>
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
					<div class="col-md-9"></div>
					<div class="col-md-3">
							<input type="submit" value="Submit" onclick="activate()"
								style="border: solid; margin-left:15px; margin-top:20px;">
							<script>
								function activate(){
									var tendetai = document.getElementById("tendetai");
									var mota = document.getElementById("mota");
									tendetai.disabled=false;
									mota.disabled=false;
								}
							</script>
					</div>
				</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>