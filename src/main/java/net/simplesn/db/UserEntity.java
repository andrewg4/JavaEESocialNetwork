package net.simplesn.db;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Andrew on 05.07.2015.
 */
@Entity
@Table(name = "user", schema = "", catalog = "simplesndb")
public class UserEntity implements Serializable {
    private int idUser;
    private String name;
    private String password;
    private String email;
    private String friends;
    private String subscribers;
    private String following;
    private byte[] avatar;

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "friends")
    public String getFriends() {
        return friends;
    }

    public void setFriends(String friends) {
        this.friends = friends;
    }

    @Basic
    @Column(name = "subscribers")
    public String getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(String subscribers) {
        this.subscribers = subscribers;
    }

    @Basic
    @Column(name = "following")
    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    @Basic
    @Column(name = "avatar")
    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (idUser != that.idUser) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (friends != null ? !friends.equals(that.friends) : that.friends != null) return false;
        if (subscribers != null ? !subscribers.equals(that.subscribers) : that.subscribers != null) return false;
        if (following != null ? !following.equals(that.following) : that.following != null) return false;
        if (!Arrays.equals(avatar, that.avatar)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (friends != null ? friends.hashCode() : 0);
        result = 31 * result + (subscribers != null ? subscribers.hashCode() : 0);
        result = 31 * result + (following != null ? following.hashCode() : 0);
        result = 31 * result + (avatar != null ? Arrays.hashCode(avatar) : 0);
        return result;
    }
}
