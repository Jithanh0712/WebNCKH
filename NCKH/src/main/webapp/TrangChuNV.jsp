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
<style><%@include file="/css/trangchu.css"%></style>
</head>
<body>
	<jsp:include page="./headerNV.jsp"></jsp:include>
	<jsp:include page="./tabNV.jsp"></jsp:include>

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
						<p>Đây là website giới thiệu chức năng, nhiệm vụ và hoạt động Khoa
							học Công nghệ tại Trường Đại học Sư phạm Kỹ thuật Tp.HCM;</p>
					</div>
					<div class="item">
						<img
							src="https://sta.huflit.edu.vn/assets/web/images/thongbao/detai/tb.png"
							alt="Image 3">
						<p>Phòng Đào tạo Đại học - Khoa học Công nghệ tham mưu,
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
						<p>Đối tượng tham gia: Sinh viên chính quy đang theo học tại Khoa
							Hàn Quốc học Thể thức đăng ký: Đăng ký thực hiện đề tài theo cá
							nhân hoặc nhóm, tối đa 04 sinh viên/nhóm (xác định rõ chủ nhiệm
							đề tài, thành viên);</p>
					</div>
					<div class="item">
						<img
							src="https://sta.huflit.edu.vn/assets/web/images/homepages/index/STA-cong%20thong%20tin.jpg"
							alt="Image 3">
						<p>Nội dung đề tài: Tập trung vào những chủ đề có tính mới, khả
							năng ứng dụng cao, gần gũi với thực tiễn cuộc sống, tiếp cận
							hướng nghiên cứu Tránh những đề tài trái chuyên ngành đang học
							hoặc phạm vi nghiên cứu quá rộng vượt quá khả năng nghiên cứu của
							sinh viên</p>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<a href="https://hcmute.edu.vn/ArticleId/2e1cb47a-33bb-4a3e-9900-0b0cbdc9f39f/thong-diep-cua-hieu-truong" class="list-group-item px-3 rounded-0 list-group-item-info mb-0 pointer">Thông điệp của hiệu trưởng</a>
				<a href="https://hcmute.edu.vn/Default.aspx?ArticleId=e26de2ae-1386-4ba8-86b7-23867dca1649" class="list-group-item px-3 rounded-0 list-group-item-info mb-0 pointer">Thành tích của nhà trường</a>
				<a href="https://hcmute.edu.vn/Default.aspx?ArticleId=61a269ff-ce13-4821-98b9-ad86bee93151" class="list-group-item px-3 rounded-0 list-group-item-info mb-0 pointer">Giới thiệu về NCKH</a>
				<a href="https://hdgscs.hcmute.edu.vn/" class="list-group-item px-3 rounded-0 list-group-item-info mb-0 pointer">Hội đồng giáo sư cơ sở</a>
				<a href="https://hcmute.edu.vn/Default.aspx?ArticleId=e02b06c1-d9d9-4700-a921-7e1a405993f9" class="list-group-item px-3 rounded-0 list-group-item-info mb-0 pointer">Các ngành đào tạo đạt chuẩn AUN-QA</a>
				<a href="http://tuvansinhvien.hcmute.edu.vn/Home/DsTuVan?fbclid=IwAR2HYw2Xtc9-eUiq-3zeVwVFCxk1vUao-EQi3gWCcruDnEA2opnqUlmgY3g" class="list-group-item px-3 rounded-0 list-group-item-info mb-0 pointer">Tư vấn hỗ trợ sinh viên</a>
				<a href="https://aao.hcmute.edu.vn/" class="list-group-item px-3 rounded-0 list-group-item-info mb-0 pointer">Phòng Đào tạo</a>
			</div>
		</div>
	</div>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>