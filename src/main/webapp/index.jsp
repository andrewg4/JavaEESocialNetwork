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
            <h1>Congratulation!</h1>

            <%--<c:if test="${header.cookie != 'email'}">--%>
                <%--<c:redirect url="signin"/>--%>
            <%--</c:if>${requestScope.Error_Message}--%>

            <%
                //TODO: allow access only if session exists    jstl
                if (session.getAttribute("email") == null) {
                    response.sendRedirect("signupin.jsp");
                }
            %>

            <a href="getusers">Show all users</a>

            <form action="signout" method="post">
                <input type="submit" value="Logout">
            </form>
        </div>
    </div>
</div>
<footer>
    Contacts
</footer>


</body>
</html>
