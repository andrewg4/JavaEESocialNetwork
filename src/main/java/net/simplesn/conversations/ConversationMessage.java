package net.simplesn.conversations;

import java.util.Date;

/**
 * Created by Andrew on 02.07.2015.
 */
public class ConversationMessage {

    private String message;
    private String sender;
    private Date received;

    public final String getMessage() {
        return message;
    }

    public final void setMessage(final String message) {
        this.message = message;
    }

    public final String getSender() {
        return sender;
    }

    public final void setSender(final String sender) {
        this.sender = sender;
    }

    public final Date getReceived() {
        return received;
    }

    public final void setReceived(final Date received) {
        this.received = received;
    }

    @Override
    public String toString() {
        return "Message [message=" + message + ", sender=" + sender
                + ", received=" + received + "]";
    }
}
