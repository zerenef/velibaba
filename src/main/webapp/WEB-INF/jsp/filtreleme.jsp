<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="">
	<form:form modelAttribute="urunFiltre" method="post">
		<div class="t-products p-2">
			<h6 class="text-uppercase">Marka</h6>
			<div class="p-lists d-flex flex-column" style="height:13vh; overflow-y: scroll;">
				<c:forEach var="marka" items="${markalar}">
					<c:choose>  
					    <c:when test="${markaChec.contains(marka)}">  
					        <div>
					        	<form:checkbox class="form-check-input markaChec" id="${marka}" path="markalar" checked="checked" value="${marka}"/>
					        	<label class="form-check-label" for="${marka}">${marka}</label>
					        </div>
					    </c:when>  
					    <c:when test="${!markaChec.contains(marka)}">  
					    	<div>
						     	<form:checkbox class="form-check-input" id="${marka}" path="markalar" value="${marka}"/>
						        <label class="form-check-label" for="${marka}">${marka}</label>
					        </div>
					    </c:when>   
					</c:choose> 
				</c:forEach>
			</div>
		</div>
		<div class="p-2 pb-0">
			<div
				class="heading d-flex justify-content-between align-items-center">
				<h6 class="text-uppercase">Fiyat Aralığı</h6>
			</div>
			<div class="d-flex justify-content-between mt-2">
				<form:input class="form-control me-1" id="fiyatMin" oninput="validity.valid || (value='');" path="fiyatMin" value="${minValue}" type="number" min="0"
					placeholder="En Az" size="5" />
				<form:input class="form-control" id="fiyatMax" oninput="validity.valid || (value='');" path="fiyatMax" value="${maxValue}" type="number" min="0"
					placeholder="En Çok" size="5" />
			</div>
			<p style="color: red;">${fiyatError}</p>
		</div>
		<hr>
		<div class="p-1">
			<div class="form-check">
				<c:choose>  
				    <c:when test="${indirimChec == true}">  
				        <form:checkbox class="form-check-input" id="indirim" path="indirim" value="indirim" checked="checked"/>
						<label class="form-check-label" for="indirim"> İndirimli Ürünler </label>
				    </c:when>  
				    <c:when test="${indirimChec != true}">  
				     	<form:checkbox class="form-check-input" id="indirim" path="indirim" value="indirim"/>
						<label class="form-check-label" for="indirim"> İndirimli Ürünler </label>
				    </c:when>   
				</c:choose> 
			</div>
		</div>
		<hr>
		<div class="p-1 d-flex justify-content-between">
			<button class="btn btn-warning" id="resetBtn" type="${uygula}" name="reset" onclick="filtreTemizle()">Temizle</button>
			<form:button class="btn btn-primary" type="submit" name="uygula">Uygula</form:button>
		</div>
	</form:form>
</div>
<script>
	function filtreTemizle(){
		document.getElementById("indirim").removeAttribute("checked");
		document.getElementById("fiyatMin").removeAttribute("value");
		document.getElementById("fiyatMax").removeAttribute("value");
		var marka = document.getElementsByClassName("markaChec");
		for(var i = 0; i < marka.length; i++){
			marka[i].removeAttribute("checked");
		}
	}
	
	function fiyat(){
		
		var min = document.getElementById("fiyatMin").value;
		var max = document.getElementById("fiyatMax").value;
		if(min > max){
			
		}
		
	}
</script>