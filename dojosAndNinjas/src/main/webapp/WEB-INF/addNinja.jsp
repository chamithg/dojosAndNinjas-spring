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
<body>

<div class = "m-5 d-5 d-flex justify-content-center"> 

<div class="w-50">
<h3>Add Ninja</h3>

<form:form  action="/ninjas/add" method="post" modelAttribute="ninja">
    <p>
        <form:label path="firstName">First name</form:label>
        <br>
        <form:errors path="firstName" class="text-danger"/>
        <br>
        <form:input path="firstName" class="form-control"/>
    </p>
    
     <p>
        <form:label path="lastName">Last name</form:label>
        <br>
        <form:errors path="lastName" class="text-danger"/>
        <br>
        <form:input path="lastName" class="form-control"/>
    </p>
    
     <p>
        <form:label path="age">Age</form:label>
        <br>
        <form:errors path="age" class="text-danger"/>
        <br>
        <form:input path="age" type="number" class="form-control"/>
    </p>
     <p>
        <form:label path="dojo">Dojo</form:label>
        <br>
        <form:errors path="dojo" class="text-danger"/>
        <br>
        <form:select path="dojo" class="form-control">
        <c:forEach items="${dojos}" var="dojo" >
        <option value="${dojo.id}"><c:out value="${dojo.name}"></c:out></option>
        
        </c:forEach>
        
        </form:select>
    </p>
    
    <input type="submit" class="btn btn-primary" value="Submit"/>
</form:form>  

</div>

</div>

</body>
</html>