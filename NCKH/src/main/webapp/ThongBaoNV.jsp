<%@page contentType="text/html; charset=UTF-8"%>
<%@page language="java"%>

<html>
<head>
	<meta charset="UTF-8">
	<title>Thông báo</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
	<link rel="stylesheet" href="css/thongbaonv.css">
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
				<textarea name="my-text-area-1" id="my-text-area-1" cols="125"
					rows="7.5" readonly>Notify</textarea>
				<hr style="border: 1px solid #2c313c;">
				<textarea name="my-text-area-2" id="my-text-area-2" cols="125"
					rows="7.5" readonly>Notify</textarea>
				<hr style="border: 1px solid #2c313c;">
				<input type="text" name="content" class="my-class" placeholder="Nội dung">
				<input type="button" value="Submit" class="my-class-1">
    			<input type="button" value="Người nhận" onclick="showModal()" class="my-class-2">
    			<div id="modal" class="modal">
			    <div class="modal-content">
			      <h2 style= "text-align: center;">Chọn người nhận</h2>
			      <div id="checkbox-list"></div>
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
	      { id: 1, name: 'Người dùng 1' },
	      { id: 2, name: 'Người dùng 2' },
	      //...
	  ];
	
	  // Tạo checkbox từ mảng dữ liệu trên
	  let checkboxList = document.getElementById('checkbox-list');
	
	  for (let user of users) {
	      let label = document.createElement('label');
	      let checkbox = document.createElement('input');
	      checkbox.type = 'checkbox';
	      checkbox.value = user.id;
	      checkbox.id = 'checkbox-' + user.id;
	
	      label.appendChild(checkbox);
	      label.appendChild(document.createTextNode(user.name));
	      checkboxList.appendChild(label);
	  }
  </script>
  <jsp:include page="./footer.jsp"></jsp:include>
</body>