package net.simplesn.db;

import net.simplesn.vo.UserVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew on 30.06.2015.
 */
public class DbSimulator {

    private List<UserVo> newUsers = new ArrayList<>();

    private static DbSimulator dbSimulator = new DbSimulator();

    public static DbSimulator getDB() {
        return dbSimulator;
    }

    public DbSimulator() {
    }

    public List<UserVo> getNewUsers() {
        return newUsers;
    }

    public boolean isRegisteredUser(String email, String password) {
        for (UserVo dbs : newUsers) {
            if (dbs.getEmail().equals(email) && dbs.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }


}