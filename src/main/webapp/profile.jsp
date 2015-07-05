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
            <h1>Czongratulation!</h1>
            <%
                //TODO: allow access only if session exists    jstl
                String user = null;
                if (session.getAttribute("email") == null) {
                    response.sendRedirect("index.jsp");
                }
                String userName = null;
                String sessionID = null;
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("email")) userName = cookie.getValue();
                        if (cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
                    }
                }
            %>
            <h3>Hi <%=userName %>, sign in successful. Session ID = <%=sessionID %>
            </h3>
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
