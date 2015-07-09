<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>friendstem.net</title>
    <link rel="stylesheet" type="text/css" href="css/style-profile.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script src="http://cytoscape.github.io/cytoscape.js/api/cytoscape.js-latest/cytoscape.min.js"></script>
    <script src="js/code.js"></script>
    <style>
        .conv-block {
            display: none;
        }

        .regblock {
            display: block;
        }

        .formlogo {
            display: block;
        }
    </style>
    <script src="js/jquery-1.10.2.min.js"></script>
    <script>
        var wsocket;
        var serviceLocation = "ws://" + document.location.host + document.location.pathname;
        var nickName = '<c:out value="${myEmail}" />';
        var $message;
        var $conversationWindow;
        var msgAccumulator = '';
        var friend = '';

        function showConvBlock() {
            $('.conv-block').show();
            $('.regblock').hide();
            $('.formlogo').hide();
        }

        function onMessageReceived(evt) {
            var msg = JSON.parse(evt.data); // native API
            var $messageLine = $('<tr><td class="received">' + msg.received
                    + '</td><td class="user label label-info">' + msg.sender
                    + '</td><td class="message badge">' + msg.message
                    + '</td></tr>');
            $conversationWindow.append($messageLine);
            msgAccumulator += msg.received + "," + msg.sender + "," + msg.message + "BBB";
        }

        function sendMessage() {
            var msg = '{"message":"' + $message.val() + '", "sender":"'
                    + nickName + '", "received":""}';
            console.log(msg.toString());
            wsocket.send(msg);
            $message.val('').focus();
        }

        function connectToConversationServer() {
            friend = $('#conversation-friend').find('option:selected').val();
            wsocket = new WebSocket(serviceLocation + "/" + nickName + "" + friend);
            console.log(serviceLocation + "/" + nickName + "" + friend);
            wsocket.onmessage = onMessageReceived;
        }

        function leaveConversation() {
            wsocket.close();
            $('.conversation-wrapper').hide();
            $('.choose-friend').show();
            console.log(msgAccumulator);
            console.log(document.getElementById("msg"));
//            customSubmit(msgAccumulator);
        }

        $(document).ready(function () {
            $message = $('#message');

            $conversationWindow = $('#response');

            // show history
            <c:forEach var="p" items="${messages}">
            $conversationWindow.append('<tr><td class="received">' + '${p.datetime}' +
                    '</td><td class="user label label-info">' + '${p.from}' +
                    '</td><td class="message badge">' + '${p.message}' + '</td></tr>');
            </c:forEach>
            $('.conversation-wrapper').hide();

            $('#start-conversation').click(function (evt) {
                evt.preventDefault();
                connectToConversationServer();
                $('.conversation-wrapper h2').text('Conversation: ' + nickName + ' :: ' + friend);
                $('.choose-friend').hide();
                $('.conversation-wrapper').show();
                $message.focus();
            });
            $('#do-conversation').submit(function (evt) {
                evt.preventDefault();
                sendMessage()
            });

            $('#end-conversation').click(function () {
                leaveConversation();
                localStorage.removeItem("justOnce");
            });
        });

        function customSubmit(someValue) {
            document.saveform.hiddenValue.value = someValue;
            document.saveform.submit();
        }
    </script>
</head>
<body>

<header>
    <div class="search">
        <form class="edit" method="POST" action="">
            <input type="text" name="search" id="search-field">
            <input type="submit" value="Search">
        </form>
    </div>
</header>
<div class="main">
    <div id="cy"></div>
    <div class="avatar"></div>
    <div class="info">
            <div class="regblock">
                <div class="formreg">
                    <div class="layout-pos">
                        <div class="content">
                            <table width="204" border="2" cellspacing="5" cellpadding="10" rules="rows" frame="void">
                                <tr>
                                    <th>Name</th>
                                    <td><c:out value="${profile.name}"/></td>
                                </tr>
                                <tr>    <th>E-mail</th>
                                    <td><c:out value="${profile.email}"/></td>
                                </tr>
                                <tr>
                                    <th>Friends</th>
                                    <td><c:out value="${profile.friends}"/></td>
                                </tr>
                                    <th>Subscribers</th>
                                    <td><c:out value="${profile.subscribers}"/></td>
                                <tr>
                                    <th>Following</th>
                                    <td><c:out value="${profile.following}"/></td>
                                </tr>
                            </table>


                        </div>
                    </div>
                </div>
            </div>
    </div>
    <div class="buttons">

            <a class="add" href="getusers?email=${profile.email}">Find Friends</a>
        <form action="signout" method="post">
            <input class="delete" type="submit" value="Logout">
        </form>
    </div>
    <div class="news">

        <button onclick="showConvBlock()">Show conversations</button>

        <div class="conv-block">
            <div class="choose-friend">
                <form>
                    <h2>Conversation with friend</h2>

                    <div>
                        <label for="conversation-friend">Friend:</label> <select size="1" id="conversation-friend"> %>
                        <option>${emails}</option>
                    </select>
                    </div>
                    <button type="submit"
                            id="start-conversation">Start conversation
                    </button>
                </form>
            </div>

            <div class="conversation-wrapper">
                <form id="do-conversation">
                    <h2></h2>
                    <table id="response"></table>
                    <fieldset>
                        <legend>Enter your message..</legend>
                        <div>
                            <input type="text" placeholder="Your message..." id="message"/>
                            <input type="submit"
                                   value="Send message"/>
                            <button type="button" id="end-conversation">End conversation</button>
                        </div>
                    </fieldset>
                </form>
                <form name="saveform" action="savemessages?to=${emails}">
                    <form name="saveform" action="getusers">
                        <input type="hidden" name="hiddenValue"/>
                    </form>
                </form>
            </div>
        </div>
    </div>

</div>
<%
    if (session.getAttribute("email") == null) {
        response.sendRedirect("signupin.jsp");
    }
%>
</body>
</html>
