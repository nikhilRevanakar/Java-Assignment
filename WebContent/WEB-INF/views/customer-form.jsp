<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<style>
.error
{
color:red
}
</style>
</head>

<body>

<i>Fill out the form, * means required.</i>
<br>

<form:form action="processForm" modelAttribute="customer">
	Enter FirstName:<form:input path="firstName"/>
	<form:errors path="firstName" cssClass="error"/>
	<br>
	Enter LastName(*):<form:input path="lastName"/>
	<form:errors path="lastName" cssClass="error"/>
	<br>
	Enter free passes:<form:input path="freePasses"/>
	<form:errors path="freePasses" cssClass="error"/>
	<br>
	Enter postal Code:<form:input path="postalCode"/>
	<form:errors path="postalCode" cssClass="error"/>
	<br>
	Enter Course Code:<form:input path="courseCode"/>
	<form:errors path="courseCode" cssClass="error"/>
	<br>
<input type="submit" value="submit"/>
</form:form>

</body>
</html>
