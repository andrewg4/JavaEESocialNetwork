package net.simplesn.conversations;

import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by Andrew on 02.07.2015.
 */
@ServerEndpoint(value = "/conv/{iaccountfriend}", encoders = ConversationMessageEncoder.class, decoders = ConversationMessageDecoder.class)
public class ConversationEndpoint {

    @OnOpen
    public void open(final Session session, @PathParam("iaccount") final String iaccount, @PathParam("friend") final String friend) {
        session.getUserProperties().put("iaccount" + "" + "friend", iaccount + ""+ friend);
    }

    @OnMessage
    public void onMessage(final Session session, final ConversationMessage chatMessage) {
        String friend = (String) session.getUserProperties().get("iaccount" + "" + "friend");
        try {
            for (Session s : session.getOpenSessions()) {
                if (s.isOpen() && friend.equals(s.getUserProperties().get("iaccount" + "" + "friend"))) {
                    s.getBasicRemote().sendObject(chatMessage);
                }
            }
        } catch (IOException | EncodeException e) {
            e.printStackTrace();
        }
    }
}