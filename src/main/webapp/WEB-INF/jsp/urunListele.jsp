<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%><%@taglib prefix="form"
	uri="http://www.springframework.org/tags/form"%><c:import
	url="header.jsp" />
<div>

	<h1 class="text-primary text-center">${baslik}</h1>
	<div class="container">
		<div class="dropdown d-flex justify-content-end">
			<button class="btn btn-secondary dropdown-toggle" type="button"
				id="dropdownMenuButton1" data-bs-toggle="dropdown"
				aria-expanded="false">Sıralama</button>
			<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
				<li><a href="javascript:void(0)" class="dropdown-item" onclick="listeleArtan()">Fiyatı
						Artan</a></li>
				<li><a href="javascript:void(0)" class="dropdown-item" onclick="listeleAzalan()">Fiyatı
						Azalan</a></li>
				<li><a href="javascript:void(0)" class="dropdown-item" onclick="cokSatanlar()">Çok
						Satanlar</a></li>
			</ul>
		</div>
	</div>


	<div class="container">
	
		<div class="row">
			
			<div class="col-md-2 col-sm-12 col-lg-2">
				<c:import url="filtreleme.jsp" />
			</div>
			
			<div class="col-md-10 col-sm-12 col-lg-10">
				<div id="urunListele">
					<c:import url="item.jsp"/>
				</div>
			</div>
		</div>
	</div>
	<input type="hidden" id="urunLink" value="${ajaxLinkStart}">
	<script type="text/javascript">
		var urunLink = document.getElementById("urunLink").value;
	
		function listeleArtan() {
			$.ajax({
				url : urunLink+'artan',
				type : 'GET',
				success : function(result) {
					$('#urunListele').html(result);
				}
			});
		}

		function listeleAzalan() {
			$.ajax({
				url : urunLink+'azalan',
				type : 'GET',
				success : function(result) {
					$('#urunListele').html(result);
				}
			});
		}
		
		function cokSatanlar() {
			$.ajax({
				url : urunLink+'en-cok-satilan',
				type : 'GET',
				success : function(result) {
					$('#urunListele').html(result);
				}
			});
		}
	</script>

</div>
<c:import url="footer.jsp" />
