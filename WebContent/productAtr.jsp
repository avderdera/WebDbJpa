<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html> 
  <head> 
   	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
   	<title>Product List</title> 
  	</head>
  	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<style>
	html,body,h1,h2,h3,h4,h5,h6 {font-family: "Roboto", sans-serif 
	}
	
	p, h1{
	color: rgb(255, 255, 255);
  	font-size: 1.3em;
	}
	h2 {
		color: rgb(255, 0, 0);
	}
	body {
  		background-image: url('https://images.idgesg.net/images/article/2017/09/networking-100735059-large.jpg');
  		background-size: cover;
	}
	table {
  		font-family: arial, sans-serif;
  		border-collapse: collapse;
  		width: 100%;
  		color: rgb(255, 255, 255);
	}

	td, th {
  		border: 1px solid #dddddd;
  		text-align: left;
  		padding: 8px;
	}

	
	</style> 
<body>
	
		<h2>
        	<a href="new">Add New Product</a>
  		</h2>
	
    <div align="center">
        <table border="1" cellpadding="5">
        	<h2><%=request.getAttribute("Error") %></h2>
            <caption><h4>List of Product Atributes</h4></caption>
            <tr>
                <th>Barcode</th>
                <th>Name</th>
                <th>Color</th>
                <th>Description</th>
            </tr>
           
                <tr>
                 <c:set var="product" scope="session" value="${Product}"/>
                    <td><c:out value="${product.barcode}" /></td>
                    <td><c:out value="${product.name}" /></td>
                    <td><c:out value="${product.color}" /></td>
                    <td><c:out value="${product.description}" /></td>
                  
                </tr>
            
        </table>
    </div>	
</body>
</html>
