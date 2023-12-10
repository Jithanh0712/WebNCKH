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
<title>Thêm tài khoản</title>

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
	    <h1 style = "color: #26365A; text-align: center;">Thêm tài khoản</h1>
     	<form action="insert" method="post">
     		
			<div class="form-group">
	        	<label for="IDDangNhap" style = "color: black; font-size: 20px; margin-left:150px;">Tài khoản</label>
	           	<input type="text" class="form-control" id="IDDangNhap" name="IDDangNhap" 
	           	style = "margin-left:250px; width:500px; height: 50px;" placeholder="Nhập tài khoản">
	        </div>
	        <div class="form-group">
	           	<label for="MatKhau" style = "color: black; font-size: 20px; margin-left:150px;">Mật khẩu</label>
	           	<input type="password" class="form-control" id="MatKhau" name="MatKhau" 
	           	style = "margin-left:250px; width:500px; height: 50px;" placeholder="Nhập mật khẩu">
	        </div>
	        <div class="form-group">
	           	<label for="ROLE_User" style = "color: black; font-size: 20px; margin-left:150px;">ROLE_User</label>
	           	<select class="form-control" id="ROLE_User" name="ROLE_User"
	      			style = "margin-left:250px; width:500px; height: 50px;">
					  <option value="NV">Nhân viên</option>
					  <option value="GV">Giảng viên</option>
					</select>
	        </div>
	        <div class="form-group">
	           	<label for="MaKhoa" style = "color: black; font-size: 20px; margin-left:150px;">MaKhoa</label>
	           	<select class="form-control" id="MaKhoa" name="MaKhoa" style="display: none; margin-left:250px; width:500px; height: 50px;">
						<option value="MK001">Khoa CNTT</option>
						<option value="MK002">Khoa Kinh tế</option>
						<option value="MK003">Khoa Ngoại ngữ</option>
						<option value="MK004">Khoa Điện - điện tử</option>
						<option value="MK005">Khoa Cơ khí chế tạo máy</option>
						<option value="MK006">Khoa Cơ khí động lực</option>
						<option value="MK007">Khoa Xây dựng</option>
						<option value="MK008">Khoa Công nghệ hóa học và thực phẩm</option>
						<option value="MK009">Khoa Thời trang và du lịch</option>
						<option value="MK010">Khoa In và truyền thông</option>
						<option value="MK011">Khoa Khoa học và ứng dụng</option>
						<option value="MK012">Khoa Chính trị và luật</option>
					</select>
	        </div>
    	<button type="submit" class="btn btn-primary" style = "margin-top: 10px; margin-left:68%;">Save</button>
    </form>
   </div>
  </div>
 </div>
 <script>
 function checkROLE_User() {
		var ROLE_User = document.getElementById("ROLE_User").value;
		if (ROLE_User == "GV") {
			document.getElementById("MaKhoa").style.display = "block";
		} else {
			document.getElementById("MaKhoa").style.display = "none";
		}
	}

	document.getElementById("ROLE_User").addEventListener("change", checkROLE_User);
 </script>
 <jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>