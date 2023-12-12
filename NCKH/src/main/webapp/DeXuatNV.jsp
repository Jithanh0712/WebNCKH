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
	<jsp:include page="./tabNV.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<jsp:include page="./listlink.jsp"></jsp:include>
			</div>
			<div class="col-md-9">
				<div class="col-md-2"></div>
				<div class="col-md-10">
					<table class="table">
						<thead>
							<tr>
								<th>Tên đề tài</th>
								<th>Giảng viên</th>
								<th>Ngày đề xuất</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class = "text">Đề tài 1</td>
								<td class = "text">GV1</td>
								<td class = "text">Date1</td>
								<td>
									<a class="button" onmouseover="this.style.color='red'" onmouseout="this.style.color=''"
									href="DeXuatGV.jsp" style="text-decoration: underline;">Xem chi tiết</a>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>