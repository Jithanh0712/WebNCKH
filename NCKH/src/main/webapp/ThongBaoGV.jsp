<%@page contentType="text/html; charset=UTF-8"%>
<%@ page language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="Models.THONGBAO"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Thông báo</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
	<style><%@include file="/css/thongbaogv.css"%></style>
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
			<form action="ThongBaoGVController" method="post">
				<c:forEach var="thongbao" items="${listTB}">
				    <textarea name="my-text-area-${thongbao.maThongBao}" id="my-text-area-${thongbao.maThongBao}" cols="125"
				        rows="7.5" readonly>Tên thông báo: ${thongbao.tenThongBao}
Ngày gửi: ${thongbao.ngayGui}
Nội dung: ${thongbao.noiDung}
</textarea>
				    <hr style="border: 1px solid #2c313c;">
				</c:forEach>
			</form>
			</div>
		</div>
	</div>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>