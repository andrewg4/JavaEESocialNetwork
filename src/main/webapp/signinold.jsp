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
            <li><a href="index.jsp">Sign up</a></li>
            <li class="active"><a href="#">Sign in</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
        </ul>
    </div>
</div>


<div class="layout-pos">
    <div class="content">
        <h1>Authorization</h1>
        <form class="edit" method="POST" action="signin">
            <label>Email <input type="email" name="email" required></label><br/>
            <label>Password <input type="password" name="password" required></label><br/>
            <input class="sub" type="submit" value="Sign in"/>
        </form>
    </div>

    <div class="footer">
    </div>
</div>

</body>
</html>
