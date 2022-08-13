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
<body class="d-flex justify-content-center">

<div class="w-75 w-5 p-5">

<h1><span><c:out value="${dojo}"/> </span> Location Ninjas</h1>

<table class="table">
  <thead class="thead-dark">
  
  
    <tr>
      
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Age</th>
    </tr>
    
    
  </thead>
  <tbody>
  <c:forEach items="${ninjas}" var="ninja">
    <tr>
      <td><c:out value="${ninja.firstName}"></c:out></td>
      <td><c:out value="${ninja.lastName}"></c:out></td>
      <td><c:out value="${ninja.age}"></c:out></td>
      
    </tr>
    
    </c:forEach>
  </tbody>
</table>
<a href="/">Go Back!</a>
</div>

</body>
</html>