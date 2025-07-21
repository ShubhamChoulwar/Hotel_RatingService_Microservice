package com.micro.user.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("Data not present in Database.....");
    }

    //if user pass the message then below

    public ResourceNotFoundException(String message){
        super(message);

    }
}
