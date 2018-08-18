<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>>
<!DOCTYPE html>
<html>
<body>
<h1>Successful</h1>
The Customer is confirmed : ${customer.firstName} ${customer.lastName }
<br>
FreePasses are: ${customer.freePasses}
<br>
Posatl Code: ${customer.postalCode}
<br>
Course Code: ${customer.courseCode}
</body>
</html>