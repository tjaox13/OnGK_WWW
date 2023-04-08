<%@ page import="java.util.List" %>
<%@ page import="entity.Manufacturer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manufacturer</title>
</head>
<body>
<h1>Welcome to Manufacturer table</h1>
<%
    List<Manufacturer> lstManufacturers= (List<Manufacturer>) session.getAttribute("manufacturers");
%>
<br>
<table border="1" width="80%" align="center">
    <tr>
        <th>manId</th>
        <th>manName</th>
        <th>manContactName</th>
        <th>manContactEmail</th>
        <th>manContactPhone</th>
        <th>manWebsite</th>
        <th><a href="Controller?action=add_new_manufacturer">Add New Manufacturer</a></th>
    </tr>
<%
    for (Manufacturer manufacturer:lstManufacturers){
    %>

    <tr>
        <td><%=manufacturer.getManId()%></td>
        <td><%=manufacturer.getManName()%></td>
        <td><%=manufacturer.getManContactName()%></td>
        <td><%=manufacturer.getManContactEmail()%></td>
        <td><%=manufacturer.getManContactPhone()%></td>
        <td><%=manufacturer.getManWebsite()%></td>
        <td>
            <a href="Controller?action=update_manufacturer&id=<%=manufacturer.getManId()%>">Edit</a>
            <a href=""
            onclick='if (confirm("Are you sure to execute this action?"))
            {window.open("Controller?action=delete_product&id=<%=manufacturer.getManId()%>");window.close();}'
            >Delete</a>
        </td>
    </tr>
    <%
        }
    %>

</table>
</body>
</html>
