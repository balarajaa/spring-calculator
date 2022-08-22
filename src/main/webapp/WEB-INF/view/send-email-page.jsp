<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> Hi ${userInfo.userName}</h1>
<h2> Send Result to Your Email</h2>
<form:form action="process-email" method="GET" modelAttribute="emailDTO">
 <label> Enter Your Email</label>
 <form:input path="userEmail" />
 <input type="submit" value="send">

</form:form>

</body>
</html>