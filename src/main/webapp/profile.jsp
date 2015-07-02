<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
    <link href="css/style.css" rel="stylesheet"/>
</head>
<body>
<div class="header">
    <div class="layout-pos">

        <ul class="main-menu">
            <li><a href="#">Sign out</a></li>
        </ul>
    </div>
</div>


<div class="layout-pos">
    <div class="content">
        <h1>Congratulation!</h1>
        <%
            //allow access only if session exists
            String user = null;
            if (session.getAttribute("email") == null) {
                response.sendRedirect("index.jsp");
            } else user = (String) session.getAttribute("email");
            String userName = null;
            String sessionID = "asd";
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("email")) userName = cookie.getValue();
                    if (cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
                }
            }
        %>
        <h3>Hi <%=userName %>, Login successful. Your Session ID=<%=sessionID %>
        </h3>
    </div>

    <div class="footer">
        <form action="signout" method="post">
            <input type="submit" value="Sign out" >
        </form>
    </div>
</div>

</body>
</html>
