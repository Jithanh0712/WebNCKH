<%@page contentType="text/html; charset=UTF-8"%>
<%@page language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import = "Models.DETAI"%>
<%@ page import = "java.util.List"%>
<%@ page import = "java.util.ArrayList"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Danh sách đề tài</title>
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
					<h3>Danh sách đề tài</h3>
					<button class="btn btn-primary" onclick="window.location.href='<%=request.getContextPath()%>/detaicuatoiNV'">Đề tài của bạn</button>
				</div>
				<table class="table">
					<thead>
						<tr>
							<th>Mã đề tài</th>
							<th>Tên đề tài</th>
							<th>Trạng thái</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<% int i = 0; %>
						<c:forEach var="detai" items="${listDT}" varStatus="loop">
							<tr>
								<td><c:out value="${detai.maDeTai}" /></td>
								<td><c:out value="${detai.tieuDe}" /></td>
								<td
									class="${listTT[loop.index] == '0' ? 'yellow-row' : listTT[loop.index] == '1' ? 'green-row' : listTT[loop.index] == '2' ? 'red-row' : ''}">
								</td>
								<td>
									<button type = "submit" class = "btn_duyet" ${listTT[loop.index] == '0' ? '' : 'disabled'} value = "${detai.maDeTai}" name = "madetai" id = "madetai">Duyệt đề tài</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<div class="d-flex justify-content-end mb-3 col-md-9"
					style="margin-top: 10px">
					<div>
						<input type="button" value="Chỉnh sửa thời gian đăng ký"
							onclick="showForm()" class="my-class-2"> <input
							type="button" value="Đăng đề tài" class="my-class-1">
					</div>
				</div>


				<form id="edit-time-form" style="display: none;" action="updateTGDK" method = "post">
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
					<input type="submit" value="Xác nhận" class="my-class-1">
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