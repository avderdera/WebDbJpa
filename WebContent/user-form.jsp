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
		<h1>Barcode validation</h1>
       
	
    <div align="center">
		<c:if test="${user != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${user == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${user != null}">
            			Welcome Back
            		</c:if>
            		<c:if test="${user == null}">
            			Add New Product
            		</c:if>
            	</h2>
            </caption>
             
        		<c:if test="${user != null}">
        			<input type="hidden" name="barcode" value="<c:out value='${user.barcode}' />" />
        		</c:if>      
        		     
           <tr>
                <th>Barcode: </th>
                <td>
                	<input type="text" name="barcode" size="45"
                			value="<c:out value='${user.barcode}' />"
                		/>
                </td>
            </tr>
           
            <tr>
                <th>Name: </th>
                <td>
                	<input type="text" name="name" size="45"
                			value="<c:out value='${user.name}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Color: </th>
                <td>
                	<input type="text" name="color" size="45"
                			value="<c:out value='${user.color}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Description: </th>
                <td>
                	<input type="text" name="description" size="45"
                			value="<c:out value='${user.description}' />"
                	/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>
