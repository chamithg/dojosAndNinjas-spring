<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="m-5 p-5">
<div class="d-flex justify-content-center">
<div class = "m-5 d-5">
<h2>All Dojos</h2>
<ul>
<c:forEach items="${dojos}" var="dojo">
<li> <a href="dojo/${dojo.id}"><c:out value="${dojo.name}"/></a></li>
</c:forEach>
</ul>
<a href="/ninja" class="btn btn-secondary">Add ninja</a>

</div>

<div class = "m-5 d-5">
<h3>Add Dojo</h3>
<form:form  action="/dojos/add" method="post" modelAttribute="dojo">
    <p>
        <form:label path="name">Dojo name</form:label>
        <br>
        <form:errors path="name" class="text-danger"/>
        <br>
        <form:input path="name" class="form-control"/>
    </p>
    
    <input type="submit" class="btn btn-primary" value="Submit"/>
</form:form>  
</div>
</div>

</body>
</html>