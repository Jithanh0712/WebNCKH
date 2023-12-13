<%@page contentType="text/html; charset=UTF-8"%>
<%@page language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Thông báo</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
	<style><%@include file="/css/thongbaonv.css"%></style>
</head>

<body>
	<jsp:include page="./header.jsp"></jsp:include>
	<jsp:include page="./tabNV.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<jsp:include page="./listlink.jsp"></jsp:include>
			</div>
			<div class="col-md-9">
			<form action="ThongBaoNVController" method="post">
				<c:forEach var="thongbao" items="${listTB}">
				    <textarea name="my-text-area-${thongbao.maThongBao}" id="my-text-area-${thongbao.maThongBao}" cols="125"
				        rows="7.5" readonly>Tên thông báo: ${thongbao.tenThongBao}
Người nhận: ${thongbao.nguoiNhan}
Ngày gửi: ${thongbao.ngayGui}
Nội dung: ${thongbao.noiDung}
</textarea>
				    <hr style="border: 1px solid #2c313c;">
				    
				</c:forEach>
				<ul id="checkbox-list" style="display: none;">
		            <c:forEach items="${listGV}" var="giangvien">
		                <li>
		                    <input type="checkbox" name="nguoiNhan" value="${giangvien.maGV}">
		                    ${giangvien.tenGV}
		                </li>
		            </c:forEach>
		        </ul>
		        <input type="hidden" name="selectedNguoiNhan" id="selectedNguoiNhan">
		        <div class="form-group">
	           		<label for="TenThongBao" style = "color: black; font-size: 20px;">Tiêu đề</label>
	           		<input type="text" class="form-control" id="TenThongBao" name="TenThongBao" 
	           		style = "width:500px; height: 50px;" placeholder="Nhập tiêu đề thông báo">
	        	</div>
				<input type="text" id="NoiDung" name="NoiDung" class="my-class" style = "margin-top: 10px;" placeholder="Nội dung">
				<button type="submit" class="btn btn-primary">Submit</button>
    			<input type="button" value="Người nhận" onclick = "showCheckbox()" class="my-class-2">
			</form>
			</div>
		</div>		  
	</div>
	<script>
	function showCheckbox() {
	    var checkboxList = document.getElementById("checkbox-list");
	    checkboxList.style.display = "block";
	}
	function getSelectedCheckBoxes() {
	    var checkboxes = document.getElementById("checkbox-list").getElementsByTagName("input");
	    var selectedValues = [];
	    for (var i = 0; i < checkboxes.length; i++) {
	        if (checkboxes[i].checked) {
	            selectedValues.push(checkboxes[i].value);
	        }
	    }
	    System.out.println(selectedValues);
	    return selectedValues;
	}
	document.getElementById("selectedNguoiNhan").value = getSelectedCheckBoxes();
	</script>
  <jsp:include page="./footer.jsp"></jsp:include>
</body>