<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>

<style type="text/css">
.error {
	color: red;
	position: fixed;
	text-align: left;
	margin-left: 30px;
}
</style>

<script type="text/javascript">
	function validateUserName() {
		var userName = document.getElementById('name').value;
		if (userName.length < 3) {
			alert("your name should have atleast 3 chars");
			return false;
		} else {
			return true;
		}
	}
</script>

</head>
<body>
	<h1 align="center">Calculator</h1>
	<hr />


<%-- 	<form:form action="process-homepage" method="get"
		modelAttribute="userInfo" onsubmit="return validateUserName()">
 --%>	<form:form action="process-homepage" method="get"
		modelAttribute="userInfo">
		<div align="center">

			<p>
				<label for="name">Your Name : </label>
				<form:input id="name" path="userName" />
				<form:errors path="userName" cssClass="error" />
			</p>
			<p>
				<label for="cname">Crush Name : </label>
				<form:input id="cname" path="crushName" />
				<form:errors path="crushName" cssClass="error" />
			</p>

			<p>
			<form:checkbox path="termsAndConditions"/>
			<label>I am agreeing that this is for fun</label>
			<form:errors path="termsAndConditions" cssClass="error"></form:errors>
			</p>
			<input type="submit" value="calculate">

		</div>
	</form:form>
</body>
</html>