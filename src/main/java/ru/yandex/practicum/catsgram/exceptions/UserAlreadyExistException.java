package ru.yandex.practicum.catsgram.exceptions;

public class UserAlreadyExistException extends Exception {

    public UserAlreadyExistException(){

    }

    public UserAlreadyExistException(String message){
        super(message);
    }

    public UserAlreadyExistException (String message, Throwable cause){
        super(message, cause);
    }

    public UserAlreadyExistException(Throwable cause){
        super(cause);
    }

}
