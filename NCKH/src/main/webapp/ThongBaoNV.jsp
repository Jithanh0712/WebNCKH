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
				<textarea name="my-text-area-1" id="my-text-area-1" cols="125"
					rows="7.5" readonly>Notify</textarea>
				<hr style="border: 1px solid #2c313c;">
				<textarea name="my-text-area-2" id="my-text-area-2" cols="125"
					rows="7.5" readonly>Notify</textarea>
				<hr style="border: 1px solid #2c313c;">
				<input type="text" name="content" class="my-class" placeholder="Nội dung">
				<input type="button" value="Submit" class="my-class-1">
				
    			<input type="button" value="Người nhận" onclick = "showModal()" class="my-class-2">
    			<div id="modal" class="modal">
			    <div class="modal-content">
			      <h2 style= "text-align: center;">Chọn người nhận</h2>
			      <div id="checkbox-list"></div>
			      <input type="button" value="Xác nhận" onclick="confirm()">
			    </div>
			  </div>
			  </form>
			</div>
		</div>
	</div>
		<script>
    	function showModal() {
	    	document.getElementById("modal").style.display = "block";
	
	    	  // Xóa các checkbox cũ
	    	  let checkboxList = document.getElementById('checkbox-list');
	    	  for (let i = checkboxList.children.length - 1; i >= 0; i--) {
	    	    checkboxList.removeChild(checkboxList.children[i]);
	    	  }
	
	    	  // Gửi request AJAX để lấy danh sách người dùng
	    	  $.ajax({
	    		  url: "/ThongBaoNVController/listgv",
	    		  method: "post",
	    		  success: function(data) {
	    		   	var html = "";
	    		     for (let giangvien of data) {
	    		      html += `<label><input type="checkbox" id="checkbox-${giangvien.maGV}" name="recipients" value="${giangvien.maGV}"> ${giangvien.tenGV}</label>`;
	    		     }
	    		     $("#checkbox-list").html(html);
	    		  }
	    		 });
    	}

	    function confirm() {
	      document.getElementById("modal").style.display = "none";
	      document.forms[0].submit();
	    }
	    
	    
  		</script>
  <jsp:include page="./footer.jsp"></jsp:include>
</body>