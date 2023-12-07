<%@page contentType="text/html; charset=UTF-8"%>
<%@page language="java"%>

<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
	<link rel="stylesheet" href="css/thongbaogv.css">
</head>

<body>
	<!-- SLIDER -->
	<section class = "m-t-80">
		<div role="tabpanel">
		  <div class="d-flex">
		    <!-- List group -->
		    <div class="list-group flex-row" id="myList" role="tablist">
		      <a class="list-group-item list-group-item-action tab-1" data-bs-toggle="list" href="#home" role="tab">Trang chủ</a>
		      <a class="list-group-item list-group-item-action tab-1" data-bs-toggle="list" href="#dtNCKH" role="tab">Đề tài NCKH</a>
		      <a class="list-group-item list-group-item-action tab-1" data-bs-toggle="list" href="#cbkh" role="tab">Công bố khoa học</a>
		      <a class="list-group-item list-group-item-action tab-1" data-bs-toggle="list" href="#dxdt" role="tab">Đề xuất đề tài</a>
		      <a class="list-group-item list-group-item-action tab-1 active" data-bs-toggle="list" href="#tb" role="tab">Thông báo</a>
		    </div>
		  </div>
		  <!-- Tab panes -->
		  <div class="tab-content">
		    <div class="tab-pane fade" id="home" role="tabpanel">...</div>
		    <div class="tab-pane fade" id="dtNCKH" role="tabpanel">...</div>
		    <div class="tab-pane fade" id="cbkh" role="tabpanel">...</div>
		    <div class="tab-pane fade" id="dxdt" role="tabpanel">...</div>
		    <div class="tab-pane fade show active" id="tb" role="tabpanel">
		    	<section class = "mt-25">
					<div class = "container">
						<div class = "row">
						</div>
					</div>											
				</section>	
		    </div>
		  </div>
		</div>
	</section>
</body>