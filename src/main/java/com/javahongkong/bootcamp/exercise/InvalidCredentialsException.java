package com.javahongkong.bootcamp.exercise;

public class InvalidCredentialsException extends RuntimeException{
    
    public InvalidCredentialsException(String message){
        super(message);
    }
}
