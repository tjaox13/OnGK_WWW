
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Manufacturer</title>
</head>
<body>
<form action="Controller">
    <input type="hidden" name="action" value="add_manufacturer">
    Enter Manufacturer Name:<input name="ManufacturerName" maxlength="50"><br>
    Enter ManufacturerContactName:<input name="ManufacturerContactName" maxlength="50"><br>
    Enter ManufacturerContactEmail:<input name="ManufacturerEmail" maxlength="50"><br>
    Enter ManufacturerContactPhone:<input name="ManufacturerPhone" maxlength="50"><br>
    Enter ManufacturerWebsite:<input name="ManufacturerWebsite" maxlength="50"><br>
    <input type="submit" value="Save">

</form>
</body>
</html>
