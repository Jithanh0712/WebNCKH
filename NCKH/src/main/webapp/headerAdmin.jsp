<%@page contentType="text/html; charset=UTF-8"%>
<%@page language="java"%>

<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style><%@include file="/css/trangchu.css"%></style>
</head>

<!-- HEADER -->
<header>
	<section>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark px-0 py-3">
			<div class="container-xl">
				<div class="collapse navbar-collapse" id="navbarCollapse">
					<div class="navbar-nav ms-lg-0">
						<button class="btn btn-primary" type="button"
							style="margin-right: 5px; margin-left: 30px; white-space: nowrap;" onclick="window.location.href='<%=request.getContextPath()%>/TaiKhoan/list'">Danh sách tài khoản</button>
						<button class="btn btn-primary" type="button"
							style="white-space: nowrap;" onclick="window.location.href='<%=request.getContextPath()%>/logout'">Đăng xuất</button>
					</div>
				</div>
			</div>
		</nav>
	</section>
</header>
<!-- Header -->