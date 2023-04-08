<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ page import="entity.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Product</title>
</head>
<body>

	<%
	Product selProduct = (Product) session.getAttribute("selProduct");
	%>

	<form action="Controller">
		<input type="hidden" name="action" value="update_product" />

		<h1>
			Product ID:<input name="productId" readonly="true"
				valu               e="<%=selProduct.getProductId()%>" />
		</h1>
		Enter Product Name:<input name="productName"
			maxlength="50" value="<%=selProduct.getProductName()%>" /><br />
		Enter description:<input name="description" maxlength="50"
			value="<%=selProduct.getDescription()%>" /><br /> <br /> 
		<select
			name="state">
			<option value="disable">disable</option>
			<option value="enable">enable</option>
		</select> 
		<input type="submit" value="Update" />
	</form>
</body>
</html>