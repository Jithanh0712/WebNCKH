<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--BIEU TUONG-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
<title>Trang chủ</title>
<link rel="stylesheet" href="css/trangchu.css">
</head>
<body>
	<jsp:include page="./header.jsp"></jsp:include>
	<jsp:include page="./tabGV.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div id="carouselExampleAutoplaying" class="carousel slide"
				data-bs-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="https://fas.hcmute.edu.vn/Resources/imagesPortlet/9fc677d3-e3c0-49fa-bfcb-0ff31543f0e9/IMG_4215.JPG" class="d-block w-100" alt="Luna">
					</div>
					<div class="carousel-item">
						<img src="https://fas.hcmute.edu.vn/Resources/imagesPortlet/9fc677d3-e3c0-49fa-bfcb-0ff31543f0e9/CUU_Dailoan.JPG" class="d-block w-100"
							alt="The Soulmaie">
					</div>
					<div class="carousel-item">
						<img src="https://fas.hcmute.edu.vn/Resources/imagesPortlet/9fc677d3-e3c0-49fa-bfcb-0ff31543f0e9/HH_UD.jpg" class="d-block w-100" alt="ZodiacB">
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<jsp:include page="./listlink.jsp"></jsp:include>
			</div>
			<div class="col-md-3">
				
				<div class="row">
					<div class="item">
						<img
							src="https://sta.huflit.edu.vn/assets/web/images/homepages/index/gioi-thieu-ban-2023.png"
							alt="Image 2">
						<p>Phòng Đào tạo Sau Đại học - Khoa học Công nghệ tham mưu,
							giúp Hiệu trưởng trong quản lý đào tạo sau đại học, hoạt động
							khoa học-công nghệ, và hợp tác trên các lĩnh vực liên quan đào
							tạo sau đại học, khoa học-công nghệ của Trường</p>
					</div>
					<div class="item">
						<img
							src="https://sta.huflit.edu.vn/assets/web/images/thongbao/detai/tb.png"
							alt="Image 3">
						<p>Phòng Đào tạo Sau Đại học - Khoa học Công nghệ tham mưu,
							giúp Hiệu trưởng trong quản lý đào tạo sau đại học, hoạt động
							khoa học-công nghệ, và hợp tác trên các lĩnh vực liên quan đào
							tạo sau đại học, khoa học-công nghệ của Trường</p>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="row">
					<div class="item">
						<img
							src="https://sta.huflit.edu.vn/assets/web/images/homepages/index/gioi-thieu-ban-2023.png"
							alt="Image 2">
						<p>Phòng Đào tạo Sau Đại học - Khoa học Công nghệ tham mưu,
							giúp Hiệu trưởng trong quản lý đào tạo sau đại học, hoạt động
							khoa học-công nghệ, và hợp tác trên các lĩnh vực liên quan đào
							tạo sau đại học, khoa học-công nghệ của Trường</p>
					</div>
					<div class="item">
						<img
							src="https://sta.huflit.edu.vn/assets/web/images/homepages/index/STA-cong%20thong%20tin.jpg"
							alt="Image 3">
						<p>Phòng Đào tạo Sau Đại học - Khoa học Công nghệ tham mưu,
							giúp Hiệu trưởng trong quản lý đào tạo sau đại học, hoạt động
							khoa học-công nghệ, và hợp tác trên các lĩnh vực liên quan đào
							tạo sau đại học, khoa học-công nghệ của Trường</p>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<a href="https://hcmute.edu.vn/" class="list-group-item px-3 rounded-0 list-group-item-info mb-0 pointer">Trang chủ nhà trường</a>
		<a href="https://thuvien.hcmute.edu.vn/" class="list-group-item px-3 rounded-0 list-group-item-info mb-0 pointer">Thư viện trường</a>
		<a href="https://fit.hcmute.edu.vn/" class="list-group-item px-3 rounded-0 list-group-item-info mb-0 pointer">Khoa công nghệ thông tin</a>
		<a href="https://feee.hcmute.edu.vn/" class="list-group-item px-3 rounded-0 list-group-item-info mb-0 pointer">Khoa điện - điện tử</a>
		<a href="https://fme.hcmute.edu.vn/" class="list-group-item px-3 rounded-0 list-group-item-info mb-0 pointer">Khoa cơ khí chế tạo máy</a>
		<a href="https://fe.hcmute.edu.vn/" class="list-group-item px-3 rounded-0 list-group-item-info mb-0 pointer">Khoa kinh tế</a>
		<a href="https://fae.hcmute.edu.vn/" class="list-group-item px-3 rounded-0 list-group-item-info mb-0 pointer">Khoa cơ khí động lực</a>
			</div>
		</div>
	</div>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>