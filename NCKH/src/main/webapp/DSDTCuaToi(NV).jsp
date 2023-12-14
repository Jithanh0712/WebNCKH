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
				<form action="thoigian/update" method="post">
				  <button class="btn btn-primary" type="submit">Đặt thời gian báo cáo</button>
				</form>
								
			</div>
		</div>
	</div>
	
	<jsp:include page="./footer.jsp"></jsp:include>
</body>