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
	<link rel="stylesheet" href="css/thongbaogv.css">
</head>

<body>
	<jsp:include page="./header.jsp"></jsp:include>
	<jsp:include page="./tab.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<jsp:include page="./listlink.jsp"></jsp:include>
			</div>
			<div class="col-md-9">
				<textarea name="my-text-area-1" id="my-text-area-1" cols="125"
					rows="7.5">Notify</textarea>
				<hr style="border: 1px solid #2c313c;">
				<textarea name="my-text-area-2" id="my-text-area-2" cols="125"
					rows="7.5">Notify</textarea>
				<hr style="border: 1px solid #2c313c;">
				<textarea name="my-text-area-3" id="my-text-area-3" cols="125"
					rows="7.5">Notify</textarea>
				<hr style="border: 1px solid #2c313c;">
				<textarea name="my-text-area-4" id="my-text-area-4" cols="125"
					rows="7.5">Notify</textarea>
			</div>
		</div>
	</div>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>