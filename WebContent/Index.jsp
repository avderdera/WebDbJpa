<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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
  		text-align:center;
	}
	table {
  		font-family: arial, sans-serif;
  		border-collapse: collapse;
  		width: 20%;
  		color: rgb(255, 255, 255);
	}

	td, th {
  		border: 1px solid #dddddd;
  		text-align: left;
  		padding: 8px;
	}

	
	</style> 
<body>
	<div align="center">
		<form action="insert" method="post">
        
        	<table border="1" cellpadding="5" >
            	<caption>
            		<h1>Add New Product</h1>
            		<p>(At most 10 integers)</p>
            	</caption>	     
           		<tr bgcolor="#154c63">
                	<th>Barcode: </th>
                	<td>
                	<input type="text" name="barcode" size="15"
                			value="<c:out value='${product.barcode}' />"
                		/>
                	</td>
                </tr>
                <tr bgcolor="#154c63">
            	<td colspan="5" align="center">
            		<input type="submit" value="Check" />
            	</td>
           		 </tr>
       		 </table>
        </form>
    </div>	

</body>
</html>