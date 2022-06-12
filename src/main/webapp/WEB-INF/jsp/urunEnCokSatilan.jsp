<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%><%@taglib prefix="form"
	uri="http://www.springframework.org/tags/form"%><c:import
	url="header.jsp" />
<div>

	<h1 class="text-primary text-center">${baslik}</h1>


<div class="container">
		<div class="container-fluid bg-trasparent my-4 p-3"
			style="position: relative">
			<div
				class="row row-cols-1 row-cols-xs-2 row-cols-sm-2 row-cols-lg-4 g-3">
				<c:forEach var="item" items="${enCokSatilan}">
					<div class="col hp">
						<div class="card h-auto shadow-sm">
							<a href="${item.getUrl()}">
								<img
								src="${item.getResimYolu()}"
								class="card-img-top" alt="product.title" />
							</a>
							<div class="label-top shadow-sm">
								<a class="text-white" href="${item.getUrl()}">${item.getMarka()}</a>
							</div>
							<div class="card-body">
								<div class="clearfix mb-3">
									<span class="float-start badge rounded-pill bg-success">${item.getFiyat()}₺</span>
									<span class="badge rounded-pill bg-danger ms-1">%${item.getIndirim()}</span>
									<span class="float-end"><i class="bi bi-heart"
										style="cursor: pointer"></i></span>
								</div>
								<h5 class="card-title">
									<a target="_blank" href="${item.getUrl()}">${item.getUrunAdi()}</a>
								</h5>

								<div class="d-grid gap-2 my-4">

									<a href="#" class="btn btn-item-warning bold-btn-item">sepete
										ekle</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>




	<h1 class="text-primary text-center">${firsatUrunleri}</h1>


<div class="container">
		<div class="container-fluid bg-trasparent my-4 p-3"
			style="position: relative">
			<div
				class="row row-cols-1 row-cols-xs-2 row-cols-sm-2 row-cols-lg-4 g-3">
				<c:forEach var="item" items="${getByIndirim}">
					<div class="col hp">
						<div class="card h-auto shadow-sm">
							<a href="${item.getUrl()}">
								<img
								src="${item.getResimYolu()}"
								class="card-img-top" alt="product.title" />
							</a>
							<div class="label-top shadow-sm">
								<a class="text-white" href="${item.getUrl()}">${item.getMarka()}</a>
							</div>
							<div class="card-body">
								<div class="clearfix mb-3">
									<span class="float-start badge rounded-pill bg-success">${item.getFiyat()}₺</span>
									<span class="badge rounded-pill bg-danger ms-1">%${item.getIndirim()}</span>
									<span class="float-end"><i class="bi bi-heart"
										style="cursor: pointer"></i></span>
								</div>
								<h5 class="card-title">
									<a target="_blank" href="${item.getUrl()}">${item.getUrunAdi()}</a>
								</h5>

								<div class="d-grid gap-2 my-4">

									<a href="#" class="btn btn-item-warning bold-btn-item">sepete
										ekle</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

	

</div>
<c:import url="footer.jsp" />
