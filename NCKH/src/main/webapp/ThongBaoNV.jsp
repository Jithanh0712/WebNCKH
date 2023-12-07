<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
	<link rel="stylesheet" href="css/thongbaogv.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Sofia">
</head>
<body>
	<jsp:include page="./header.jsp"></jsp:include>
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
							<!-- Góc link -->
							<div class ="col-md-3">
								<a href="https://hcmute.edu.vn/" class="list-group-item px-3 border-0 rounded-3 list-group-item-info mb-2 pointer">Trang chủ nhà trường</a>
								<a href="https://thuvien.hcmute.edu.vn/" class="list-group-item px-3 border-0 rounded-3 list-group-item-info mb-2 pointer">Thư viện trường</a>
								<a href="https://fit.hcmute.edu.vn/" class="list-group-item px-3 border-0 rounded-3 list-group-item-info mb-2 pointer">Khoa công nghệ thông tin</a>
								<a href="https://feee.hcmute.edu.vn/" class="list-group-item px-3 border-0 rounded-3 list-group-item-info mb-2 pointer">Khoa điện - điện tử</a>
								<a href="https://fme.hcmute.edu.vn/" class="list-group-item px-3 border-0 rounded-3 list-group-item-info mb-2 pointer">Khoa cơ khí chế tạo máy</a>
								<a href="https://fe.hcmute.edu.vn/" class="list-group-item px-3 border-0 rounded-3 list-group-item-info mb-2 pointer">Khoa kinh tế</a>
								<a href="https://fae.hcmute.edu.vn/" class="list-group-item px-3 border-0 rounded-3 list-group-item-info mb-2 pointer">Khoa cơ khí động lực</a>
								<a href="https://fce.hcmute.edu.vn/" class="list-group-item px-3 border-0 rounded-3 list-group-item-info mb-2 pointer">Khoa xây dựng</a>
								<a href="https://fcft.hcmute.edu.vn/" class="list-group-item px-3 border-0 rounded-3 list-group-item-info mb-2 pointer">Khoa công nghệ hóa học và thực phẩm</a>
								<a href="https://fgtfd.hcmute.edu.vn/" class="list-group-item px-3 border-0 rounded-3 list-group-item-info mb-2 pointer">Khoa thời trang và du lịch</a>
								<a href="https://fgam.hcmute.edu.vn/" class="list-group-item px-3 border-0 rounded-3 list-group-item-info mb-2 pointer">Khoa in và truyền thông</a>
								<a href="https://ffl.hcmute.edu.vn/" class="list-group-item px-3 border-0 rounded-3 list-group-item-info mb-2 pointer">Khoa ngoại ngữ</a>
								<a href="https://fas.hcmute.edu.vn/" class="list-group-item px-3 border-0 rounded-3 list-group-item-info mb-2 pointer">Khoa khoa học ứng dụng</a>
								<a href="https://fpi.hcmute.edu.vn/" class="list-group-item px-3 border-0 rounded-3 list-group-item-info mb-2 pointer">Khoa chính trị - luật</a>
							</div>
							<!-- Góc hiện thông báo -- Gửi thông báo -->
							<div class = "col-md-9">
								<div class="container">
									<div class="row">
										<div class="col-md-3">
											<textarea name="my-text-area-1" id="my-text-area-1" cols="125" rows="7.5">Notify</textarea>
										</div>
										<hr style="border: 1px solid #2c313c;">
										<div class="col-md-3">
											<textarea name="my-text-area-2" id="my-text-area-2" cols="125" rows="7.5">Notify</textarea>
										</div>
										<div class="hstack gap-3">
											<input class="form-control me-auto" type="text" placeholder="Add your item here..." aria-label="Add your item here...">
											<button type="button" class="btn btn-secondary">Submit</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>											
				</section>	
				<jsp:include page="./footer.jsp"></jsp:include>
		    </div>
		  </div>
		</div>
	</section>										
</body>
</html>
