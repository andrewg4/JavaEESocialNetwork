package net.simplesn.db;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Andrew on 05.07.2015.
 */
@Entity
@Table(name = "messages", schema = "", catalog = "simplesndb")
public class MessagesEntity implements Serializable {
    private int idMessage;
    private String from;
    private String to;
    private String message;
    private Timestamp datetime;

    @Id
    @Column(name = "id_message")
    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }


    @Basic
    @Column(name = "from")
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Basic
    @Column(name = "to")
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Basic
    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "datetime")
    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessagesEntity that = (MessagesEntity) o;

        if (idMessage != that.idMessage) return false;
        if (from != null ? !from.equals(that.from) : that.from != null) return false;
        if (to != null ? !to.equals(that.to) : that.to != null) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (datetime != null ? !datetime.equals(that.datetime) : that.datetime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMessage;
        result = 31 * result + (from != null ? from.hashCode() : 0);
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (datetime != null ? datetime.hashCode() : 0);
        return result;
    }

}
