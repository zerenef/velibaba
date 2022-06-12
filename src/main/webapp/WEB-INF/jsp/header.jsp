<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib prefix="form"
	uri="http://www.springframework.org/tags/form"%><%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><c:choose>
		<c:when test="${not empty title}">
			${title}
		</c:when>
		<c:when test="${empty title}">
			Anasayfa
		</c:when>
	</c:choose>
</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/css/style.css" rel="stylesheet">
<link href="/css/navbar.css" rel="stylesheet">
<link href="/css/footer.css" rel="stylesheet">
<link href="/css/item.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<link rel="icon" type="image/x-icon" href="/images/favicon.ico">
</head>
<body>
	<div class="container-fluid bg-dark">
		<div class="container">
			<div class="row pt-2 justify-content-around align-items-center px-2">
				<div class="col-lg-4 col-md-4 col-sm-12">
					<a href="/"><img class="img-fluid" src="/images/logo.png" style="width:45%"></a>
				</div>

				<div class="col-lg-4 col-md-4 col-sm-12 py-md-0 py-sm-2 py-xs">
					<form>
						<div class="input-group">
							<input type="text" class="form-control"
								placeholder="Ne aramıştınız?" aria-label="Recipient's username"
								aria-describedby="button-addon2">
							<button class="btn btn-outline-secondary" type="button"
								id="button-addon2">
								<i class="bi bi-search"></i>
							</button>
						</div>
					</form>
				</div>

				<div class="col-lg-4 col-md-4 col-sm-12 d-flex justify-content-end">
					<security:authorize access="!isAuthenticated()">
						<a class="btn btn-outline-success" href="login.html">Giriş</a>
						<a class="btn btn-outline-success mx-2" href="register.html">Kayıt Ol</a>
					</security:authorize>
					<security:authorize access="isAuthenticated()">
						<div>
							<div class="dropdown">
							  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">								  
							   	<i class="bi bi-person"></i>Hesabım						
							  </button>
							  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
							    <li><a class="dropdown-item" href="/kullanici-bilgilerim">Kullanıcı Bilgilerim</a></li>
							    <li><a class="dropdown-item" href="/siparislerim">Siparişlerim</a></li>
							    <li>
							    	<form action="logout" method="post">
										<input class="dropdown-item text-danger" type="submit" value="Logout"/>
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
									</form>
								</li>
							  </ul>
							</div>
						</div>
					</security:authorize>
					
					<a href="#" class="btn btn-outline-warning ms-2"><i
						class="bi bi-cart4"></i></a>
				</div>
			</div>
		</div>
		<div class="container mt-1">
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark px-2">
				<span class="navbar-brand d-lg-none text-warning">Kategoriler</span>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#main_nav">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="main_nav">
					<div class="container">
						<ul class="navbar-nav justify-content-evenly">
							<c:forEach var="ustItem" items="${ust}">
								<li class="nav-item dropdown has-megamenu"><a
									class="nav-link dropdown-toggle" href=""
									data-bs-toggle="dropdown"> ${ustItem.getUstKategoriAdi()} </a>
									<div class="dropdown-menu megamenu" role="menu">
										<div class="row g-3">
											<c:forEach var="ortaItem" items="${orta}">
												<c:if test="${ortaItem.getUstKategori() == ustItem}">
													<div class="col-lg-3 col-6">
														<div class="col-megamenu">
															<a href="${ortaItem.getUrl()}"
																style="text-decoration: none;"><h6 class="title">${ortaItem.getKategoriAdi()}</h6></a>
															<ul class="list-unstyled">
																<c:forEach var="altItem" items="${alt}">
																	<c:if test="${altItem.getKategori() == ortaItem}">									
																		<li><a
																			href="${altItem.getUrl()}">${altItem.getAltKategoriAdi()}</a></li>
																	</c:if>
																</c:forEach>
															</ul>
														</div>
													</div>
												</c:if>
											</c:forEach>
										</div>
									</div></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</div>