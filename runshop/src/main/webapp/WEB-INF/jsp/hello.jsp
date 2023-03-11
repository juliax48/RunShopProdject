<%--
  Created by IntelliJ IDEA.
  User: Runstore
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
${userName}

<div>
    <h1>System User</h1>
</div>
<div>
    <table>
        <tr>
            <td>User Id</td>
            <td>User Name</td>
            <td>User Surname</td>
            <td>Birth date</td>
            <td>Height</td>
            <td>Weight</td>

        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>${user.birthDate}</td>
                <td>${user.height}</td>
                <td>${user.weight}</td>
            </tr>
        </c:forEach>
    </table>
</div>


</body>
</html>
