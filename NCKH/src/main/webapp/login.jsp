<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
	<button type="submit" class="btnTC btn-primary">Trang chủ</button>
    <div class="container">
        <h1>Đăng nhập</h1>

        <form action="login.do" method="post">
            <div class="form-group">
                <label for="username">Tên đăng nhập</label>
                <input type="text" name="username" id="username" class="form-control">
            </div>
            <div class="form-group">
                <label for="password">Mật khẩu</label>
                <input type="password" name="password" id="password" class="form-control">
            </div>
            <button type="submit" class="btnDN btn-primary">Đăng nhập</button>
        </form>
    </div>

</body>
</html>
