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
	<jsp:include page="./header.jsp"></jsp:include>
	<jsp:include page="./tabNV.jsp"></jsp:include>

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
					<div>
						<input type="button" value="Chỉnh sửa thời gian đăng ký"
							onclick="showModal()" class="my-class-2"> 
						<input type="button" value="Đăng đề tài" class="my-class-1">
					</div>
				</div>

				<div id="modal" class="modal">
					<div class="modal-content">
						<input type="button" value="X" class = "change">
						<h2 style="text-align: center;">Chỉnh sửa thời gian đăng ký</h2>
						<div id="checkbox-list"></div>
						<div id="date-from-new"></div>
						<div id="date-to-new"></div>
						<input type="button" value="Xác nhận" onclick="confirm()"> 
					</div>
				</div>
			</div>
		</div>
	</div>
		<script>
    function showModal() {
      document.getElementById("modal").style.display = "block";
    }

    function confirm() {
      document.getElementById("modal").style.display = "none";
      document.forms[0].submit();
    }
  	</script>
	<script>
	//Mã nguồn này giả sử rằng bạn đã lấy được dữ liệu từ database
	  let users = [
		  { id: 1, ngayhientai: '01/01/2023', ngaythaydoi: '02/02/2023' },
	      //...
	  ];
	
	  // Tạo checkbox từ mảng dữ liệu trên
	  let checkboxList = document.getElementById('checkbox-list');
	
	  let dateNow = document.getElementById('date-from-new');
	  let dateNew = document.getElementById('date-to-new');
	  
	  for (let user of users) {
	      let label = document.createElement('label');
	      let checkbox = document.createElement('input');
	      checkbox.type = 'checkbox';
	      checkbox.value = user.id;
	      checkbox.id = 'checkbox-' + user.id;
		  
	      let label1 = document.createElement('label');
	      let date = document.createElement('input');
	      date.type = 'date';

	      let label2 = document.createElement('label');
	      let date1 = document.createElement('input');
	      date1.type = 'date';
	      
	      label.appendChild(document.createTextNode('Thời gian đăng ký từ: ' +user.ngayhientai + ' đến: ' +  user.ngaythaydoi));
	      checkboxList.appendChild(label);
	      

	      label1.appendChild(document.createTextNode('Thời gian mới từ: '));
	      label1.appendChild(date);
	      
	      label2.appendChild(document.createTextNode('Đến:             '));
	      label2.appendChild(date1);
	      
	      dateNow.appendChild(label1);
	      
	      dateNew.appendChild(label2);
	  }
  	</script>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>