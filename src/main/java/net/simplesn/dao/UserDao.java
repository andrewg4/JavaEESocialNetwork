package net.simplesn.dao;

import net.simplesn.db.UserEntity;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by Andrew on 05.07.2015.
 */
@Stateless(name = "UserDaoEJB")
public class UserDao extends AbstractDao<UserEntity> {

    public UserDao() {
        super(UserEntity.class);
    }

    public List<UserEntity> getAll() {
        return query("SELECT c FROM UserEntity c").getResultList();
    }

}