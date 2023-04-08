<%@ page import="entity.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>

<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/12/2023
  Time: 9:43 PM
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Product</title>
</head>
<body>
<H1>Product Table</H1>

<%
    List<Product> lstProducts = (List<Product>) session.getAttribute("products");
%>
<br/>
<table border="1" width="80%" align="center">
    <tr>
        <th>productId</th>
        <th>productName</th>
        <th>description</th>
        <th><a href="Controller?action=add_new_product">Add New User</a></th>
    </tr>
    <%
        for(Product product: lstProducts){
    %>
    <tr>
        <td><%=product.getProductId()%></td>
        <td><%=product.getProductName()%></td>
        <td><%=product.getDescription()%></td>
        <td>
            <a href="Controller?action=update_product_view&id=<%=product.getProductId()%>">Edit  </a>
            <a href=""
               onclick='if(confirm("Are you sure to execute this action?"))
                       {window.open("Controller?action=delete_product&id=<%=product.getProductId()%>");window.close();}'
            >Delete</a>
        </td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
