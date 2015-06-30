package net.simplesn.db;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew on 30.06.2015.
 */
public class DbSimulator {

    private String name;
    private String password;
    private String email;

    private List<DbSimulator> newUsers = new ArrayList<>();

    // register a new user
    public DbSimulator(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    // initialize authorisation data
    public DbSimulator(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public DbSimulator() {
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

    public List<DbSimulator> getNewUsers() {
        return newUsers;
    }

    public boolean exist(DbSimulator dbSimulator) {
        for (DbSimulator dbs : newUsers) {
            if (dbs.getName().equals(dbSimulator.getName()) &&
                    dbs.getEmail().equals(dbSimulator.getEmail()) &&
                    dbs.getPassword().equals(dbSimulator.getPassword())) {
                return true;
            }
        }
        return false;
    }

}