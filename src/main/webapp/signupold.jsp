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
            <li class="active"><a href="index.jsp">Sign up</a></li>
            <li><a href="profile.jsp">Sign in</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
        </ul>
    </div>
</div>


<div class="layout-pos">
    <div class="content">
        <h1>Registration</h1>
            <form class="edit" method="POST" action="signup">
                <label>Name <input type="text" name="name" required></label><br/>
                <label>Password <input type="password" name="password" required></label><br/>
                <label>Email <input type="email" name="email" required></label><br/>
                <input class="sub" type="submit" value="Sign up"/>
            </form>
        </div>

    <div class="footer">
    </div>
</div>

</body>
</html>
