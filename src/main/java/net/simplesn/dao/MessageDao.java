package net.simplesn.dao;

import net.simplesn.db.MessagesEntity;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by Andrew on 07.07.2015.
 */
@Stateless(name = "MessageDaoEJB")
public class MessageDao extends AbstractDao<MessagesEntity> {

    public MessageDao() {
        super(MessagesEntity.class);
    }

    public List<MessagesEntity> getAll() {
        return query("SELECT c FROM MessagesEntity c").getResultList();
    }

}
