<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>friendstem.net</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<header>
    <div class="formlogo">
        <form class="edit" method="POST" action="signin">
            <input type="email" name="email" id="email-field" placeholder="E-mail" required>
            <input type="password" name="password" id="password-field" placeholder="Your name" required>
            <input type="submit" value="Log In">
        </form>
    </div>
</header>


<div class="formreg">
    <div class="layout-pos">
        <div class="content">



            <h1>Users</h1>
            <hr/>
            <%--private int idUser;
                private String name;
                private String password;
                private String email;
                private String friends;
                private String subscribers;
                private String following;
                private byte[] avatar;--%>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Password</th>
                    <th>E-mail</th>
                    <th>Friends</th>
                    <%--<th>Subscribers</th>--%>
                    <%--<th>Following</th>--%>
                    <%--<th>Avatar</th>--%>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="u" items="${users}">
                    <tr>
                        <td>${u.idUser}</td>
                        <td>${u.name}</td>
                        <td>${u.password}</td>
                        <td>${u.email}</td>
                        <td>${u.friends}</td>
                        <%--<td>${u.subscribers}</td>--%>
                        <%--<td>${u.following}</td>--%>
                        <%--<td>${u.avatar}</td>--%>
                        <td>Удалить</td>
                        <td>Изменить</td>
                    </tr>
                </c:forEach>
            </table>
            <div class="btn">
                <a href="#">Добавить</a>
            </div>
        </div>
    </div>
</div>
<footer>
    Contacts
</footer>


</body>
</html>