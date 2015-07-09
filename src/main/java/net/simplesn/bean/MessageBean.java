package net.simplesn.bean;

import net.simplesn.dao.MessageDao;
import net.simplesn.db.MessagesEntity;
import net.simplesn.vo.MessagesVo;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Andrew on 07.07.2015.
 */
@Stateless(name = "MessageEJB")
public class MessageBean {

    @EJB
    MessageDao messageDao;

    public MessageBean() {
    }

    public List<MessagesVo> getAll() {
        List<MessagesVo> messagesVoList = new ArrayList<>();

        List<MessagesEntity> messagesEntities = messageDao.getAll();
        for (MessagesEntity messagesEntity : messagesEntities){
            messagesVoList.add(toValueObj(messagesEntity));
        }
        return messagesVoList;
    }

    public MessagesVo toValueObj(MessagesEntity messagesEntity) {
        MessagesVo messagesVo = new MessagesVo(
                messagesEntity.getFrom(),
                messagesEntity.getTo(),
                messagesEntity.getMessage(),
                messagesEntity.getDatetime()
        );
        messagesVo.setIdMessage(messagesEntity.getIdMessage());
        return messagesVo;
    }

    public MessagesEntity toEntity(MessagesVo messagesVo) {
        MessagesEntity messagesEntity = new MessagesEntity();
        messagesEntity.setIdMessage(messagesVo.getIdMessage());
        messagesEntity.setFrom(messagesVo.getFrom());
        messagesEntity.setTo(messagesVo.getTo());
        messagesEntity.setMessage(messagesVo.getMessage());
        messagesEntity.setDatetime(messagesVo.getDatetime());
        return messagesEntity;
    }
    public MessagesVo get(int id) {
        return toValueObj(messageDao.find(id));
    }

    public void update(MessagesVo messagesVo) {
        messageDao.remove(messagesVo.getIdMessage());
        messagesVo.setIdMessage(0);
        messageDao.persist(toEntity(messagesVo));
    }

    public void add(MessagesVo messagesVo) {
        messageDao.persist(toEntity(messagesVo));
    }


    public java.sql.Date toMysqlDateStr(String stringDate) {
        return new java.sql.Date(new Date(stringDate).getTime());
    }
}