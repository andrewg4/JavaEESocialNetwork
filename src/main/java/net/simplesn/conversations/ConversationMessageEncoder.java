package net.simplesn.conversations;

import javax.json.Json;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * Created by Andrew on 02.07.2015.
 */
public class ConversationMessageEncoder implements Encoder.Text<ConversationMessage> {
    @Override
    public void init(final EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public String encode(final ConversationMessage conversationMessage) throws EncodeException {
        return Json.createObjectBuilder()
                .add("message", conversationMessage.getMessage())
                .add("sender", conversationMessage.getSender())
                .add("received", conversationMessage.getReceived().toString()).build()
                .toString();
    }
}