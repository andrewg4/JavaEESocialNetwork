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
@ServerEndpoint(value = "/conversation/{friend}", encoders = ConversationMessageEncoder.class, decoders = ConversationMessageDecoder.class)
public class ConversationEndpoint {

    @OnOpen
    public void open(final Session session, @PathParam("friend") final String friend) {
        session.getUserProperties().put("friend", friend);
    }

    @OnMessage
    public void onMessage(final Session session, final ConversationMessage chatMessage) {
        String friend = (String) session.getUserProperties().get("friend");
        try {
            for (Session s : session.getOpenSessions()) {
                if (s.isOpen() && friend.equals(s.getUserProperties().get("friend"))) {
                    s.getBasicRemote().sendObject(chatMessage);
                }
            }
        } catch (IOException | EncodeException e) {
            e.printStackTrace();
        }
    }
}