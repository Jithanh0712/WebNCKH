<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xem chi tiết</title>
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
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-3">
						<label style="margin-top:30px; font-size:20px;"><b>Tiêu đề</b></label><br>
						<label style="margin-top:30px; font-size:20px;"><b>Giảng viên đảm nhận:</b></label><br>
						<label style="margin-top:30px; font-size:20px;"><b>Danh sách sinh viên:</b></label>
					</div>
					<div class="col-md-7">
						<textarea readonly style="margin-top:30px; font-size:20px; border:2px solid; width:300px" rows=1>${detai.tieuDe}</textarea>
						
						<textarea readonly style="margin-top:10px; font-size:20px; border:2px solid; width:300px" rows=1>${giangvien.tenGV}</textarea>
						<c:forEach var="listSV" items="${listSV}">
						<c:set var="listSV" value="${listSV.split(', ')}" />
						<textarea readonly style="margin-top:10px; font-size:20px; border:2px solid; width:300px" rows=1>${listSV[0]}</textarea>
						</c:forEach>
						
					</div>
				</div>
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-3">
						<label style="margin-top:30px; font-size:20px;"><b>Kinh phí:</b></label><br>
						<label style="margin-top:30px; font-size:20px;"><b>Ngày Đăng ký đê tài:</b></label>
						<label style="margin-top:30px; font-size:20px;"><b>Mô tả:</b></label>
					</div>
					<div class="col-md-7">
						<textarea readonly style="margin-top:25px; font-size:20px; border:2px solid; width:300px" rows=1>${detai.kinhPhi}</textarea>
						<textarea readonly style="margin-top:10px; font-size:20px; border:2px solid; width:300px" rows=1>${detai.ngayDKTC}</textarea>
						<textarea readonly id="mota" name="mota"
							style="border:2px solid; margin-top: 20px; font-size: 20px; width: 500px; height: 250px;">${detai.moTa}</textarea>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>