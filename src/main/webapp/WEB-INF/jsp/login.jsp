<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Giriş Yap</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<style>
body {
	background-image: url(/images/login.jpg);
	background-size: cover;
}

.girisYapStyle {
	background-color: rgb(29, 27, 27, 0.6);
	color: rgb(255, 255, 255);
	padding: 1rem;
}
</style>
</head>
<body>
	  <div class="container">
		<div class="row" style="height: 100vh;">
			<div
				class="col-sm-12 col-xs-12 col-lg-4 col-md-5  mx-auto align-self-center rounded shadow-lg girisYapStyle ">
				<div class="text-center mb-2"><a href="/"><img class="img-fluid" src="/images/logo.png" style="width:70%"></a></div>
				<p class="text-center">Giriş Yap</p>

				<c:if test="${not empty message}">
					<div style="color: red">${message}</div>
				</c:if>

				<form action="login" method="post">
					<div class="mb-3">
						<input type="text" name="username" class="form-control rounded-pill"
							placeholder="Email" aria-describedby="emailHelp">
					</div>
					<div class="mb-3">
						<input type="password" name="password"
							class="form-control rounded-pill" placeholder="Şifre">
					</div>
					<div class="mb-3 form-check">
						<input type="checkbox" name="remember-me" class="form-check-input"
							id="beniHatirla"> <label class="form-check-label"
							for="beniHatirla">Beni Hatırla</label>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<div class="text-center">
						<input type="submit" class="btn btn-primary w-50 rounded-pill"
							value="Giriş Yap">
					</div>
					<div class="text-center">
						<font color="red"> 
							<c:if test="${not empty param.loginFailed}">
								<c:out value="Hatalı email veya şifre"></c:out>
							</c:if>
						</font>
					</div>
				</form>
				<p class="text-center text-warning mt-5 mb-0">Hesabınız yok mu? <a href="register.html" class="fw-bold text-success"><u>Kayıt Ol</u></a></p>
			</div>
		</div>
	</div> 
	<script type="text/javascript" src="webjars/popper.js/2.9.3/umd/popper.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>