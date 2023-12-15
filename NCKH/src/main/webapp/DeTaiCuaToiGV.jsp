<%@page contentType="text/html; charset=UTF-8"%>
<%@page language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	<jsp:include page="./header.jsp"></jsp:include>
	<jsp:include page="./tabGV.jsp"></jsp:include>

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
					      <th style = "color: black;">Loại</th>
					      <th style = "color: black;">Mã</th>
					      <th style = "color: black;">Trạng thái</th>
					      <th style = "color: black;">Nộp bài</th>
					      <th style = "color: black;">Xem chi tiết đề tài</th>
					     </tr>
					    </thead>
					    <tbody>
					     <c:forEach var="detaicanhan" items="${listDT}">
					     	<c:set var="details" value="${detaicanhan.split(', ')}" />
								<tr>
									<td><c:out value="${details[0]}" /></td> 
									<td><c:out value="${details[1]}" /></td>
									<c:set var="trangThai" value="${details[2]}" />
									<td <c:if test="${trangThai eq 'true'}">class="green-row"</c:if>
									    <c:if test="${trangThai eq 'false'}">class="yellow-row"</c:if>>
									</td>
									<c:set var="maDeTai" value="${details[1]}" />
										<td>
											<form action="FromDL/redirect" method="post">
											<button type="submit" class="btn_duyet" value="${maDeTai}"
												name="madetai" id="madetai"
												style="${fn:contains(maDeTai, 'DT') && trangThai eq 'true' ? 'display: inline-block;' : 'display: none;'}"
												${thoigian.ngayBatDau.time > System.currentTimeMillis() || System.currentTimeMillis() > thoigian.ngayKetThuc.time ? 'disabled' : ''}>Nộp
												báo cáo</button>
											</form>
										</td>
										<td>
										<form action = "MDTTranferXCTController" method = "post">
									    <button type="submit" class="btn_duyet" value="${maDeTai}" name="madetai" id="madetai" style="${fn:contains(maDeTai, 'DT') ? 'display: inline-block;' : 'display: none;'}">Xem chi tiết</button>
										</form>
										</td>
								</tr>
							</c:forEach>
					     <!-- } -->
					    </tbody>
					
					   </table> 
					</div>
			</div>
		</div>
	</div>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>