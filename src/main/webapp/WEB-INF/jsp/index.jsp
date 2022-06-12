<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%><%@taglib prefix="form"
	uri="http://www.springframework.org/tags/form"%><%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %><c:import
	url="header.jsp" />
<div>

<security:authorize access="isAuthenticated()">
	<!-- ajax ile istek gönderilip sorgu çalıştırılacak -->
    Welcome Back, <security:authentication property="name"/>
</security:authorize>
<div>
<c:import  url="slider.jsp"/>
</div>

<div class="mt-5">
<c:import  url="urunEnCokSatilan20.jsp"/>
</div>

</div>
<c:import  url="footer.jsp"/> 