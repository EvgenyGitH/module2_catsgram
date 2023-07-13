package ru.yandex.practicum.catsgram.exceptions;

public class InvalidEmailException extends Exception {
    public InvalidEmailException(){

    }

    public InvalidEmailException(String message){
        super(message);
    }

    public InvalidEmailException (String message, Throwable cause){
        super(message, cause);
    }

    public InvalidEmailException(Throwable cause){
        super(cause);
    }
}
