<%@page contentType="text/html; charset=UTF-8"%>
<%@page language="java"%>

<html>
<head>
	<meta charset="UTF-8">
	<title>Danh sách đề tài</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
	<link rel="stylesheet" href="css/danhsachdetai.css">
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
				<div class="d-flex justify-content-between mb-3">
					<h3>Danh sách đề tài</h3>
					<button class="btn btn-primary">Đề tài của bạn</button>
				</div>
				<table class="table">
					<thead>
						<tr>
							<th>Tên đề tài</th>
							<th>Trạng thái</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr class="green-row">
							<td>Đề tài 1</td>
							<td></td>
							<td><input type="checkbox"></td>
						</tr>
						<tr class="yellow-row">
							<td>Đề tài 2</td>
							<td></td>
							<td><input type="checkbox"></td>
						</tr>
						<tr class="green-row">
							<td>Đề tài 3</td>
							<td></td>
							<td><input type="checkbox"></td>
						</tr>
						<tr class="yellow-row">
							<td>Đề tài 4</td>
							<td></td>
							<td><input type="checkbox"></td>
						</tr>
						<!-- Thêm các hàng khác -->
					</tbody>
				</table>
				<div class="d-flex justify-content-end mb-3">
					<button class="btn btn-primary">Đăng ký</button>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>