<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1 align="center"> Calculator </h1>
<hr/>

<h2>The Calculator Predicts : </h2>
<br/>
  ${userInfo.userName} and ${userInfo.crushName} are
  <br/>
  FRIEND
  <br/>
  
  <!-- <a href="/spring-calculator/sendEmail"> Send Result to Your Email</a> -->
  
  <a href="<c:url value = "/sendEmail" />"> Send Result to Your Email</a>

</body>
</html>