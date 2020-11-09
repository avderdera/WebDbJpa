<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>User Management Application</title>
</head>
<body>
	<center>
		<h1>User Management</h1>
        <h2>
        	<a href="new">Add New User</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Users</a>
        	
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>Barcode</th>
                <th>Name</th>
                <th>Color</th>
                <th>Description</th>
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.barcode}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.color}" /></td>
                    <td><c:out value="${user.description}" /></td>
                  
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>
