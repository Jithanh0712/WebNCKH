<%@page contentType="text/html; charset=UTF-8"%>
<%@page language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	<jsp:include page="./headerAdmin.jsp"></jsp:include>
	<jsp:include page="./tabAdmin.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<jsp:include page="./listlink.jsp"></jsp:include>
			</div>
			<div class="col-md-9">
				<div class="d-flex justify-content-between mb-3">
					<h3>Danh sách đề tài</h3>
				</div>
				<table class="table">
					<thead>
						<tr>
							<th>Mã đề tài</th>
							<th>Tên đề tài</th>
							<th>Trạng thái</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="detai" items="${listDT}">
							<tr>
								<td><c:out value="${detai.maDeTai}" /></td>
								<td><c:out value="${detai.tieuDe}" /></td>
								<td class="<c:if test="${detai.trangThai}">green-row</c:if> <c:if test="${!detai.trangThai}">yellow-row</c:if>">
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<div class="d-flex justify-content-end mb-3 col-md-9"
					style="margin-top: 10px">
				</div>

			</div>
		</div>
	</div>
		
	<jsp:include page="./footer.jsp"></jsp:include>
</body>