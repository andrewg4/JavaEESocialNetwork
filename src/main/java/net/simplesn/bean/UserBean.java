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
                userEntity.getName(),
                userEntity.getPassword(),
                userEntity.getEmail(),
                userEntity.getFriends(),
                userEntity.getSubscribers(),
                userEntity.getFollowing(),
                userEntity.getAvatar()
        );
        userVo.setIdUser(userEntity.getIdUser());
        return userVo;
    }

    public UserEntity toEntity(UserVo userVo) {
        UserEntity userEntity = new UserEntity();
        userEntity.setIdUser(userVo.getIdUser());
        userEntity.setName(userVo.getName());
        userEntity.setPassword(userVo.getPassword());
        userEntity.setEmail(userVo.getEmail());
        userEntity.setFriends(userVo.getFriends());
        userEntity.setFollowing(userVo.getFollowing());
        userEntity.setAvatar(userVo.getAvatar());
        return userEntity;
    }
    public UserVo get(int id) {
        return toValueObj(userDao.find(id));
    }

    public void update(UserVo userVo) {
        userDao.remove(userVo.getIdUser());
        userVo.setIdUser(0);
        userDao.persist(toEntity(userVo));
    }

    public void add(UserVo userVo) {
        userDao.persist(toEntity(userVo));
    }

    // check if user with this e-mail already exist
    public boolean isRegisteredUser(String email) {
        List<UserVo> listOfUsers = getAll();
        for (UserVo dbUser : listOfUsers) {
            if (dbUser.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public UserVo getProfileData(String email){
        List<UserVo> listOfUsers = getAll();
        for (UserVo dbUser : listOfUsers) {
            if (dbUser.getEmail().equals(email)) {
                return dbUser;
            }
        }
        return null;
    }

    public void addToFriends(String myEmail, String uEmail){
        UserVo me = getProfileData(myEmail);
        UserVo userVo = getProfileData(uEmail);
        // check if user is already follower
        if (me.getFollowing().equals(uEmail) || userVo.getFollowing().equals(uEmail)){
            me.setFriends(uEmail);
            me.setFollowing("");
            userVo.setFollowing("");
            userVo.setFriends(myEmail);
        }
        else {
            me.setFollowing(uEmail);
            userVo.setSubscribers(myEmail);
        }
        update(me);
        update(userVo);
    }

    public String getFriends(String myEmail){
        List<UserVo> listOfUsers = getAll();
        for (UserVo user : listOfUsers){
            if (user.getEmail().equals(myEmail)){
                return user.getFriends();
            }
        }
        return null;
    }

    public String[] getListOfFriends(String myEmail){
        return getFriends(myEmail).split(",");
    }


    public void unfollow(String myEmail, String uEmail) {
        // update my profile
        UserVo me = getProfileData(myEmail);
        me.setFollowing("");

        // update user profile
        UserVo userVo = getProfileData(uEmail);
        userVo.setSubscribers("");

        update(me);
        update(userVo);
    }
}