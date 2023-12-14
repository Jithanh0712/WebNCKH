<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<style><%@include file="/css/dropbox.css"%></style>
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
				<div class="col-md-2"></div>
				<div class="col-md-10">
					<table class="table">
						<thead>
							<tr>
								<th>Tên đề tài</th>
								<th>Giảng viên</th>
								<th>Trạng thái</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="dexuatdetai" items="${listDX}" varStatus="loop">
								<tr>
									<td><c:out value="${dexuatdetai.tieuDeDeTai}" /></td>
									<td><c:out value="${dexuatdetai.maGV}" /></td>
									<td
										class="<c:if test="${dexuatdetai.trangThai}">green-row</c:if> <c:if test="${!dexuatdetai.trangThai}">yellow-row</c:if>">
									</td>
									<td>
										<form method="post" action="MaDeXuatTranfer" id="madexuatform${loop.index}">
										<input type="hidden" id="madexuat" name="madexuat" value="${dexuatdetai.maDeXuat}">
										</form>
										 <a class="button" onmouseover="this.style.color='red'"
												type="submit" onmouseout="this.style.color=''"
												onclick="submit(${loop.index})"
												style="text-decoration: underline;">Xem chi tiết</a>
										<script>
											function submit(index){
												var form = document.getElementById("madexuatform" + index);
											    form.submit();
											}
										</script>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>