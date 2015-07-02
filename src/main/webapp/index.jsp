<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <input type="password" name="password" id="password-field" placeholder="Password" required >
            <input type="submit" value="Log In">
        </form>
    </div>
</header>

<div class="formreg">
    <p>Make you friend stem bigger!</p>

    <p>Get started - it's free.</p>

    <form class="edit" method="POST" action="signup">
        <label>Name <input type="text" name="name" placeholder="Your name" required></label><br/>
        <label>Password <input type="password" name="password" placeholder="Password" required></label><br/>
        <label>Email <input type="email" name="email" placeholder="E-mail" required></label><br/>

        <p class="ok">By clicking Join now, you agree to friendstem's User Agreement, Privacy Policy, and Cookie
            Policy</p>
        <input class="sub" type="submit" value="Sign up"/>
    </form>
</div>

<footer>
    Contacts
</footer>


</body>
</html>
