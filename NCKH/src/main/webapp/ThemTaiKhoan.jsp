<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--BIEU TUONG-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
<title>Danh sách tài khoản</title>

<style><%@include file="/css/trangchu.css"%></style>
<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
</head>
<body>
	<jsp:include page="./headerAdmin.jsp"></jsp:include>
	<jsp:include page="./tabGV.jsp"></jsp:include>
	
	<div class="container">
	  <div class="row">
	    <div class="col-md-3">
	      <jsp:include page="./listlink.jsp"></jsp:include>
	    </div>
	    <div class="col-md-9">
	        
	          <h1>Danh sách tài khoản</h1>
	          
		      <table class="table table-bordered">
		        <thead>
		          <tr>
		            <th>IDDangNhap</th>
		            <th>MatKhau</th>
		            <th>ROLE_User</th>
		          </tr>
		        </thead>
		        <tbody>
		          <c:forEach var="taikhoan" items="${listTK}">
		            <tr>
		              <td><c:out value="${taikhoan.iDDangNhap}" /></td>
		              <td><c:out value="${taikhoan.matKhau}" /></td>
		              <td><c:out value="${taikhoan.rOLE_User}" /></td>
		            </tr>
		          </c:forEach>
		        </tbody>
		      </table>
		      <button type="submit" class="btn btn-primary" style ="margin-top:10px; margin-left: 90%;"
		      onclick="window.location.href='<%=request.getContextPath()%>/TaiKhoan/new'">Thêm</button>
	      </div>
	    </div>
	  </div>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>