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
	<section class = "m-t-80">
	  <div class="d-flex">
	    <!-- List group -->
	    <div class="list-group flex-row" id="myList">
			<a href="./TrangChu.jsp" class="list-group-item tab-1 px-3 border-0 rounded-0 list-group-item-info mb-2 pointer">Trang chủ</a>
			<a href="<%=request.getContextPath()%>/danhsachdetai/listDSDT_Ad" class="list-group-item tab-1 px-3 border-0 rounded-0 list-group-item-info mb-2 pointer" onclick="alert('Bạn không có quyền truy cập danh sách đề tài NCKH'); return false;">Đề tài NCKH</a>
			<a href="./CongBo.jsp" class="list-group-item tab-1 px-3 border-0 rounded-0 list-group-item-info mb-2 pointer">Công bố khoa học</a>
			<a href="" class="list-group-item tab-1 px-3 border-0 rounded-0 list-group-item-info mb-2 pointer" onclick="alert('Bạn không có quyền truy cập danh sách đề tài NCKH'); return false;">Đề xuất đề tài</a>
	    </div>
	  </div>	 
	</section>
</body>