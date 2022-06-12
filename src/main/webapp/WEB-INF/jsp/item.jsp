<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
		<div class="container-fluid bg-trasparent my-4 p-3"
			style="position: relative">
			<div
				class="row row-cols-1 row-cols-xs-2 row-cols-sm-2 row-cols-lg-4 g-3">
				<c:forEach var="item" items="${list}">
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
							
							<c:if test="${item.getIndirim()>0}">								
								<span><del><small class="ps-2">${item.getFiyat()}₺</small></del></span>
							</c:if>
							<c:if test="${item.getIndirim()<=0}">								
								<span style="visibility:hidden">${item.getFiyat()}₺</span>
							</c:if>

								<div class="clearfix mb-3">
									
									<span class="float-start badge rounded-pill bg-success">${item.getFiyat()-(item.getFiyat()*item.getIndirim()/100)}₺</span>
									<c:if test="${item.getIndirim()>0}">
										<span class="badge rounded-pill bg-danger ms-1">%${item.getIndirim()}</span>
									</c:if>
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

	<c:if test="${sayfaNoGizle != true}">
		<div class="container">
			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-center">
					<c:choose>
						<c:when test="${pageNo == 0}">
							<li class="page-item disabled"><a class="page-link">Önceki</a></li>
						</c:when>
						<c:when test="${pageNo != 0}">
								<li class="page-item"><a class="page-link" href="${linkStart}${pageNo-1}${linkEnd}">Önceki</a></li>
						</c:when>
					</c:choose>
					<c:forEach begin="${begin}" end="${end}" var="i">
						<c:choose>
							<c:when test="${pageNo - i == 0}">
								<li class="page-item active"><a class="page-link"
									href="${linkStart}${i}${linkEnd}">${i+1}</a></li>
							</c:when>
							<c:when test="${pageNo - i != 0}">
								<li class="page-item"><a class="page-link"
									href="${linkStart}${i}${linkEnd}">${i+1}</a></li>
							</c:when>
						</c:choose>
					</c:forEach>
					<c:choose>
						<c:when test="${pageNo == (sayfaSayisi - 1)}">
							<li class="page-item disabled"><a class="page-link">Sonraki</a></li>
						</c:when>
						<c:when test="${pageNo != (sayfaSayisi - 1)}">
							<li class="page-item"><a class="page-link" href="${linkStart}${pageNo+1}${linkEnd}">Sonraki</a></li>
						</c:when>
					</c:choose>
				</ul>
			</nav>
		</div>
	</c:if>
	
