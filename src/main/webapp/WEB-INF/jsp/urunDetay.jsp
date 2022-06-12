<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%><%@taglib prefix="form"
	uri="http://www.springframework.org/tags/form"%><c:import
	url="header.jsp" />
<div class="container my-4">

	<div class="row">
		<div class="col-lg-7 col-md-7 col-sm-12 col-xs-12">
			<!-- Container for the image gallery -->
			<div style="position: relative">
			
						<!-- <p>${urunBilgisi.getResimYolu()}</p> -->
			
				<!-- Full-width images with number text -->
				<div class="mySlides">
					<div class="numbertext">1 / 6</div>
					<img src="${urunBilgisi.getResimYolu()}"
						style="width: 100%">
				</div>

				<div class="mySlides">
					<div class="numbertext">2 / 6</div>
					<img src="/images/macbook-2.jfif"
						style="width: 100%">
				</div>

				<div class="mySlides">
					<div class="numbertext">3 / 6</div>
					<img src="/images/macbook-3.jfif"
						style="width: 100%">
				</div>

				<div class="mySlides">
					<div class="numbertext">4 / 6</div>
					<img src="/images/macbook-4.jfif"
						style="width: 100%">
				</div>

				<div class="mySlides">
					<div class="numbertext">5 / 6</div>
					<img src="/images/macbook-5.jfif"
						style="width: 100%">
				</div>

				<div class="mySlides">
					<div class="numbertext">6 / 6</div>
					<img src="/images/macbook-6.jfif"
						style="width: 100%">
				</div>

				<!-- Next and previous buttons -->
				<a class="prev" onclick="plusSlides(-1)">&#10094;</a> <a
					class="next" onclick="plusSlides(1)">&#10095;</a>


				<!-- Thumbnail images -->
				<div class="row mt-1 ">
					<div class="column">
						<img class="demo cursor"
							src="${urunBilgisi.getResimYolu()}"
							style="width: 100%" onclick="currentSlide(1)" alt="The Woods">
					</div>
					<div class="column">
						<img class="demo cursor"
							src="/images/macbook-2.jfif"
							style="width: 100%" onclick="currentSlide(2)" alt="Cinque Terre">
					</div>
					<div class="column">
						<img class="demo cursor"
							src="/images/macbook-3.jfif"
							style="width: 100%" onclick="currentSlide(3)"
							alt="Mountains and fjords">
					</div>
					<div class="column">
						<img class="demo cursor"
							src="/images/macbook-4.jfif"
							style="width: 100%" onclick="currentSlide(4)"
							alt="Northern Lights">
					</div>
					<div class="column">
						<img class="demo cursor"
							src="/images/macbook-5.jfif"
							style="width: 100%" onclick="currentSlide(5)"
							alt="Nature and sunrise">
					</div>
					<div class="column">
						<img class="demo cursor"
							src="/images/macbook-6.jfif"
							style="width: 100%" onclick="currentSlide(6)"
							alt="Snowy Mountains">
					</div>
				</div>
			</div>
		</div>


		<script>
	let slideIndex = 1;
	showSlides(slideIndex);

	// Next/previous controls
	function plusSlides(n) {
	  showSlides(slideIndex += n);
	}

	// Thumbnail image controls
	function currentSlide(n) {
	  showSlides(slideIndex = n);
	}

	function showSlides(n) {
	  let i;
	  let slides = document.getElementsByClassName("mySlides");
	  let dots = document.getElementsByClassName("demo");
	  if (n > slides.length) {slideIndex = 1}
	  if (n < 1) {slideIndex = slides.length}
	  for (i = 0; i < slides.length; i++) {
	    slides[i].style.display = "none";
	  }
	  for (i = 0; i < dots.length; i++) {
	    dots[i].className = dots[i].className.replace(" active", "");
	  }
	  slides[slideIndex-1].style.display = "block";
	  dots[slideIndex-1].className += " active";
	}
	</script>

		<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
			<p><span class="urunMarka">${urunBilgisi.getMarka()}</span></p>
			<p class="display-2">${urunBilgisi.getUrunAdi()}</p>
			<hr>
			
			<c:if test="${urunBilgisi.getIndirim() > 0}">
				<del><span class="h3">${urunBilgisi.getFiyat()}₺</span></del>
				<c:if test="${urunBilgisi.getIndirim() > 0}">
					<span class="badge rounded-pill bg-danger" style="font-size:1.5rem">%${urunBilgisi.getIndirim()} <i class="bi bi-caret-down"></i></span>
				</c:if>
			</c:if>
			
			<p class="badge rounded-pill bg-success" style="font-size:1.5rem">${urunBilgisi.getFiyat()-(urunBilgisi.getFiyat()*urunBilgisi.getIndirim()/100)}₺</p>

			<div class="container">
			<button type="button" style="border:none" onclick="urunMiktarDegistir('azalt')"><i class="bi bi-dash"></i></button>
			<input type="number" oninput="validity.valid || (value='');" value="1" min="1" style="width:3em" id="urunMiktar" >
			<button type="button" style="border:none" onclick="urunMiktarDegistir('artir')"><i class="bi bi-plus"></i></button>
			
			
			<script>
				function urunMiktarDegistir(gelen){
					var urunMiktar = document.getElementById("urunMiktar").value;
					if(gelen=='artir'){
						document.getElementById("urunMiktar").value = ++urunMiktar;
					} else if(gelen=='azalt'){
						if(urunMiktar > 1)
						document.getElementById("urunMiktar").value = urunMiktar - 1;
					} else {
						document.getElementById("urunMiktar").value = -1;
					}
					
				}
			</script>
			
			<button class="btn btn-primary my-2 mx-3" onclick="javascript:void(0)">Sepete Ekle</button>
			</div>
			<hr>
			<p class="display-5"><b>Ürün Açıklaması:</b> ${urunAciklama}</p>
			
			<div>
				<span class="fs-3"><i class="bi bi-heart"></i> Favorilere Ekle</span>
			</div>
			
		</div>
	</div>


	<h4 class="text-center text-primary mt-3">Özellikler</h4>
	<table class="table table-striped">
		<c:forEach var="entry" items="${ozellikler}">
			<tr>
				<th>${entry.key}</th>
				<td>${entry.value}</td>
			</tr>
		</c:forEach>
	</table>

</div>
<c:import  url="footer.jsp"/> 