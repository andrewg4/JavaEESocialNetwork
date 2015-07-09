package net.simplesn.vo;

import java.sql.Timestamp;

/**
 * Created by Andrew on 07.07.2015.
 */
public class MessagesVo {

    private int idMessage;

    private String from;
    private String to;
    private String message;
    private Timestamp datetime;

    public MessagesVo(String from, String to, String message, Timestamp datetime) {
        this.from = from;
        this.to = to;
        this.message = message;
        this.datetime = datetime;
    }

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;

    }

}
