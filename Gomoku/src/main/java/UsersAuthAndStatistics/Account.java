package UsersAuthAndStatistics;

import java.io.*;
import java.util.*;

/**
 * 
 */
public abstract class Account {

    /**
     * Default constructor
     */
    public Account() {

    }

    /**
     * 
     */
    private String nickName;

    /**
     * 
     */
    private String hashedPassword;

    /**
     * 
     */
    private String id;


    /**
     * @param nickName 
     * @param hashedPassword
     */
    public Account(String nickName, String hashedPassword) {
        this.nickName = nickName;
        this.hashedPassword = hashedPassword;

        this.id = UUID.randomUUID().toString();
    }

    public String getNickName() {
        return nickName;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public String getId() {
        return id;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return
     */
    public abstract boolean canLogin();

}