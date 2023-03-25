<%--
  Created by IntelliJ IDEA.
  User: Noirix
  Date: 09.02.2023
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
${itemName}

<div>
    <h1>System Items</h1>
</div>
<div>
    <table>
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Brand</td>
            <td>Size</td>
            <td>Color</td>
            <td>Price</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach var="item" items="${item}">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.brand}</td>
                <td>${item.size}</td>
                <td>${item.color}</td>
                <td>${item.price}</td>

                <td><button>Edit</button></td>
                <td><button>Delete</button></td>

            </tr>
        </c:forEach>
    </table>
</div>


</body>
</html>