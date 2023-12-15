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
<script>
	function downloadFile(url) {
		var a = document.createElement('a');
		var convertedURL = url.replace(/\\\\/g, '\\');
		a.href = convertedURL;
		var filename = convertedURL.substring(convertedURL.lastIndexOf('\') + 1);
		a.download = filename;
		document.body.appendChild(a);
		a.click();
		document.body.removeChild(a);
	}
</script>
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
					<h3>Danh sách file báo cáo</h3>
				</div>
				<form action="<%=request.getContextPath()%>/lichsunop" method="post">
				<table class="table">
					<thead>
						<tr>
							<th>Loại báo cáo</th>
							<th>Ngày nộp</th>
							<th>File</th>
							<th></th>
						</tr>
					</thead>
						<c:forEach var="filebaocao" items="${listBC}">
							<tr>
								<td><c:out value="${filebaocao.loaiBaoCao}" /></td>
								<td><c:out value="${filebaocao.ngayNop}" /></td>
								<td>
									<p>Ấn vào để tài về</p><a class="button" type="button" onclick="downloadFile('${filebaocao.fileURL}')"> tại đây</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>