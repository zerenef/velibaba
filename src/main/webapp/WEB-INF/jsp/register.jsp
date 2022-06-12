<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib prefix="form"
	uri="http://www.springframework.org/tags/form"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Kayıt Ol</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<style>
	.gradient-custom-3 {
        /* fallback for old browsers */
        background: #84fab0;

        /* Chrome 10-25, Safari 5.1-6 */
        background: -webkit-linear-gradient(to right, rgba(132, 250, 176, 0.5), rgba(143, 211, 244, 0.5));

        /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
        background: linear-gradient(to right, rgba(132, 250, 176, 0.5), rgba(143, 211, 244, 0.5))
        }
        .gradient-custom-4 {
        /* fallback for old browsers */
        background: #84fab0;

        /* Chrome 10-25, Safari 5.1-6 */
        background: -webkit-linear-gradient(to right, rgba(132, 250, 176, 1), rgba(143, 211, 244, 1));

        /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
        background: linear-gradient(to right, rgba(132, 250, 176, 1), rgba(143, 211, 244, 1))	
</style>
</head>
<body>
	  
	  <section class="vh-100 bg-image" style="background-image: url(/images/kayit_ol.webp);">
        <div class="mask d-flex align-items-center h-100 gradient-custom-3">
          <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
              <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                <div class="text-center mb-2"><a href="/"><img class="img-fluid" src="/images/logo.png" style="width:45%"></a></div>
                <div class="card" style="border-radius: 15px;">
                  <div class="card-body p-5">
                    <h2 class="text-uppercase text-center mb-3">Kayıt Ol</h2>
      
                    <form:form method="post" modelAttribute="user">
                      <div class="form-outline mb-2">
                        <form:input type="text" path="ad" class="form-control form-control-lg" placeholder="Adınız"/>
                        <form:errors path="ad"/>
                      </div>
                      <div class="form-outline mb-2">
                        <form:input type="text" path="soyad" class="form-control form-control-lg" placeholder="Soyadınız"/>
                        <form:errors path="soyad"/>
                      </div>
                      <div class="form-outline mb-2">
                        <form:input type="email" path="username" class="form-control form-control-lg" placeholder="E-mail Adresi"/>
                        <form:errors path="username"/>
                      </div>
                      <div class="form-outline mb-2">
                        <form:input type="password" path="password" class="form-control form-control-lg" placeholder="Parola"/>
                        <form:errors path="password"/>
                        
                      </div>
      
                      <div class="d-flex justify-content-center">
                        <form:button name="submit" class="btn btn-success btn-block btn-lg gradient-custom-4 text-body w-50">Kayıt Ol</form:button>
                      </div>
      
                      <p class="text-center text-muted mt-5 mb-0">Zaten bir hesabınız var mı? <a href="login.html" class="fw-bold text-body"><u>Giriş Yap</u></a></p>
      
                    </form:form>
      				<c:if test="${not empty message}">
						<div style="color: red">${message}</div>
					</c:if>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      
      
     <%--  <form:form modelAttribute="user" method="post">
		First Name:<form:input path="username"/> 
		<form:errors path="username"/> <!-- boş veri girilirse hata mesajı alanı -->
		<br>
		Last Name:<form:input path="ad"/>
		<form:errors path="ad"/> 
		<br>
		<form:button name="submit">Create</form:button>
	</form:form> --%>
	  
	  
	<script type="text/javascript" src="webjars/popper.js/2.9.3/umd/popper.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>