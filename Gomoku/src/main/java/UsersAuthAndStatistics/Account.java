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

    /**
     * @return
     */
    public abstract boolean canLogin();

}