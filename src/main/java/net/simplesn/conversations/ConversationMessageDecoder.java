package net.simplesn.conversations;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.StringReader;
import java.util.Date;

/**
 * Created by Andrew on 02.07.2015.
 */
public class ConversationMessageDecoder implements Decoder.Text<ConversationMessage> {
    @Override
    public void init(final EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public ConversationMessage decode(final String textMessage) throws DecodeException {
        ConversationMessage conversationMessage = new ConversationMessage();
        JsonObject obj = Json.createReader(new StringReader(textMessage)).readObject();
        conversationMessage.setMessage(obj.getString("message"));
        conversationMessage.setSender(obj.getString("sender"));
        conversationMessage.setReceived(new Date());
        return conversationMessage;
    }

    @Override
    public boolean willDecode(final String s) {
        return true;
    }
}
