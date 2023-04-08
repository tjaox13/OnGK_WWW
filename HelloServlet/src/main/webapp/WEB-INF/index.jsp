<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a> <br>
<a href="Controller?action=Manufacturer">Manufacturer</a><br>
<a href="Controller?action=ListProduct">List Product</a>
<%--<jsp:forward page="/hello-servlet"></jsp:forward>--%>
</body>
</html>