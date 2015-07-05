package net.simplesn.vo;

/**
 * Created by Andrew on 02.07.2015.
 */
public class UserVo {

    private int idUser;
    private String name;
    private String password;
    private String email;
    private String friends;
    private String subscribers;
    private String following;
    private byte[] avatar;

    public UserVo(int idUser, String name, String password, String email, String friends) {
        this.idUser = idUser;
        this.name = name;
        this.password = password;
        this.email = email;
        this.friends = friends;
    }

    public UserVo(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }


    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFriends() {
        return friends;
    }

    public void setFriends(String friends) {
        this.friends = friends;
    }

    public String getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(String subscribers) {
        this.subscribers = subscribers;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }


}
