package com.forum.exception;

public class UserNotExistException extends Exception{
    public UserNotExistException(String username){
        super("user not exist:"+username);
    }
}
