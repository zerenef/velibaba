<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%><%@taglib prefix="form"
	uri="http://www.springframework.org/tags/form"%><%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %><c:import
	url="header.jsp" />
<div class="container my-5">
	<div class="row">
		<div class="col-4">
			<p> <span class="bi bi-person rounded-circle p-1" style="font-size: 1.3em; background-color: #B4ADAD;"></span> Kadir irpik</p>
			<div class="list-group">
			  <a href="/kullanici-bilgilerim" class="list-group-item list-group-item-action w-50">Kullanıcı Bilgilerim</a>
			  <a href="/siparislerim" class="list-group-item list-group-item-action w-50">Siparişlerim</a>
			</div>
		</div>
		<div class="col-8">
			<p class="fs-4"><b>Kullanıcı Bilgilerim</b></p>
			<div id="kullaniciBilgileri">
				<p><b>Profil Bilgileri</b></p>
				<div>
					<form action="">
						
						<div class="d-flex">
							<div class="me-3">
								<label>Ad</label>
								<input class="form-control" type="text">
							</div>
							<div>
								<label>Soyad</label>
								<input class="form-control" type="text">
							</div>
						</div>
						<div>
							<button class="btn btn-success" type="submit">Güncelle</button>
						</div>
						
					</form>
				</div>
			</div>
			<div id="siparislerim">
				
			</div>
		</div>
	</div>
</div>
<c:import  url="footer.jsp"/> 