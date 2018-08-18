<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h1>Displaying Form Page</h1>
<form:form action="processForm" modelAttribute="employee">
Enter id:	<form:input type="text" path="eid"/>
Enter name:	<form:input type="text" path="ename"/>
Enter city:	<form:input type="text" path="city"/>
	<input type="submit"/>
</form:form>
</body>
</html>