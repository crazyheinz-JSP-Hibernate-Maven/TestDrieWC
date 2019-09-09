
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome ${name}</title>
</head>
<body>

<h1>Welcome ${name}</h1>

<form method='POST' action="logout">
    <input type='submit' name='operation' value='Log out' />

</form>

</body>
</html>
