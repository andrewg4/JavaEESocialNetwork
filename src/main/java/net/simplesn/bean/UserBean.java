package net.simplesn.bean;

import net.simplesn.dao.UserDao;
import net.simplesn.db.UserEntity;
import net.simplesn.vo.UserVo;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew on 05.07.2015.
 */
@Stateless(name = "UserEJB")
public class UserBean {

    @EJB
    UserDao userDao;

    public UserBean() {
    }

    public List<UserVo> getAll() {
        List<UserVo> userVoList = new ArrayList<>();

        List<UserEntity> userTableEntityList = userDao.getAll();
        for (UserEntity userEntity : userTableEntityList){
            userVoList.add(toValueObj(userEntity));
        }
        return userVoList;
    }

    public UserVo toValueObj(UserEntity userEntity) {
        UserVo userVo = new UserVo(
                userEntity.getIdUser(),
                userEntity.getName(),
                userEntity.getPassword(),
                userEntity.getEmail(),
                userEntity.getFriends()
        );
        userVo.setIdUser(userEntity.getIdUser());
        return userVo;
    }
}