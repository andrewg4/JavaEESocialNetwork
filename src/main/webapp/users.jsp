<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>friendstem.net</title>
    <link rel="stylesheet" type="text/css" href="css/style-main.css">
</head>
<body>

<header>

</header>


<div class="formreg">
    <div class="layout-pos">
        <div class="content">
            <h1>Users</h1>
            <hr/>
            <a href="index.jsp?myEmail=${myEmail}">Profile</a>
            <p>I'm  <c:out value="${myEmail}"/></p>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>E-mail</th>
                    <th>Friends</th>
                    <th>Subscribers</th>
                    <th>Following</th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="u" items="${users}">
                    <tr>
                        <td>${u.idUser}</td>
                        <td>${u.name}</td>
                        <td>${u.email}</td>
                        <td>${u.friends}</td>
                        <td>${u.subscribers}</td>
                        <td>${u.following}</td>
                        <td><a href="addtofriends?uEmail=${u.email}&myEmail=${myEmail}">Add to friends</a></td>
                        <td><a href="conv?myEmail=${myEmail}&user=${u.email}">Send a message</a></td>
                        <td><a href="unfollow?myEmail=${myEmail}&uEmail=${u.email}">Unfollow</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<footer>
    Contacts
</footer>


</body>
</html>