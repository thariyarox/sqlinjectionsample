<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SQL Injection Demo - Search Product</title>
</head>
<body>
<%
    if ((session.getAttribute("username") == null) || (session.getAttribute("username") == "")) {
%>
You are not logged in<br/>
<a href="index.jsp">Please Login</a>
<%} else {
%>
Welcome <%=session.getAttribute("username")%>
<h2><a href="search.jsp">Search Product</a></h2>
<h1>Add Product</h1>

<form action="add" method="post">
    Product Name: <input type="text" name="product_name" value="" /><br />
    Product Price: <input type="text" name="product_price" value="" /><br />
    <input type="submit" value="Add" />
</form>
<%
    }
%>

</body>
</html>