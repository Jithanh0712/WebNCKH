<%@page contentType="text/html; charset=UTF-8"%>
<%@page language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import = "com.google.gson.Gson"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Danh sách đề tài của tôi</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
	<style><%@include file="/css/danhsachdetai.css"%></style>
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
				<div class="d-flex justify-content-between mb-3">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th style="color: black;">Mã đề tài</th>
								<th style="color: black;">Tiêu đề</th>
								<th style="color: black;">Trạng thái</th>
								<th style="color: black;">Xem chi tiết đề tài</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="listDTCN" items="${listDTCN}" varStatus = "loop">
								<tr>
									<td><c:out value="${listDTCN.maDeTai}" /></td>
									<td><c:out value="${listDTCN.tieuDe}" /></td>
									<td class="${listTT[loop.index] == '0' ? 'yellow-row' : (listTT[loop.index] == '1' ? 'green-row' : (listTT[loop.index] == '2' ? 'red-row' : ''))}">
									</td>
									<td &nbsp;&nbsp;&nbsp;&nbsp;><a href="XemChiTietNV.jsp?id=<c:out value='${detai.maDeTai}'/>">Xem chi tiết</a>
									</td>
								</tr>
							</c:forEach>
							<!-- } -->
						</tbody>
					</table>
				</div>
				<div class="d-flex justify-content-end mb-3">
					<button class="btn btn-primary" type="submit" onclick="showForm()">Đặt thời gian báo cáo</button>
				</div>
				
				<form id="edit-time-form" style="display: none;">
					<div class="row">
						<div class="col-md-2">
							<div class="form-group">
								<label for="magv">Chọn loại báo cáo: </label>
							</div>
						</div>
						<div class="col-md-5">
							<div class="form-group">
								<input type="radio" id="bcdk" name="bcdk" placeholder = "Báo cáo định kỳ"> Báo cáo định kỳ
							</div>
						</div>
						<div class="col-md-5">
							<div class="form-group">
								<input type="radio" id="bcnt" name="bcnt" placeholder = "Báo cáo định kỳ"> Báo cáo nghiệm thu
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-2">
							<div class="form-group">
								<label for="magv">Thời gian hiện tại: </label>
							</div>
						</div>
						<div class="col-md-5">
							<div class="form-group">
								<input type="text" id="ngaybd" name="ngaybd" maxlength="30" class="form-control" value="${thoigian.ngayBatDau.toLocalDate().toString()}" readonly>
							</div>
						</div>
						<div class="col-md-5">
							<div class="form-group">
								<input type="text" id="ngaykt" name="ngaykt" maxlength="30" class="form-control" value="${thoigian.ngayKetThuc.toLocalDate().toString()}" readonly>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-2">
							<div class="form-group">
								<label for="magv">Thời gian mới: </label>
							</div>
						</div>
						<div class="col-md-5">
							<div class="form-group">
								<input type="date" id="ngaybdmoi" name="ngaybdmoi" maxlength="30" class="form-control">
							</div>
						</div>
						<div class="col-md-5">
							<div class="form-group">
								<input type="date" id="ngayktmoi" name="ngayktmoi" maxlength="30" class="form-control">
							</div>
						</div>
					</div>
					<input type="submit" value="Xác nhận" class="my-class-1" style = "margin-left:90%;  margin-top:2%">
				</form>
			</div>
		</div>
	</div>
	
	<script>
		let form = document.getElementById('edit-time-form');
	  	let formVisible = false;
		function showForm() {
			formVisible = !formVisible; // Đảo ngược trạng thái hiển thị

			if (formVisible) {
				form.style.display = 'block';
			} else {
				form.style.display = 'none';
			}
		}
	</script>
	
	<jsp:include page="./footer.jsp"></jsp:include>
</body>