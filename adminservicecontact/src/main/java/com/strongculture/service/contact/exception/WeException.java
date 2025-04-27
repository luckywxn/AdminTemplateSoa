package com.strongculture.service.contact.exception;

public class WeException extends RuntimeException {
    static final long serialVersionUID = -6034897190745760002L;

    public WeException(){
        super();
    }
    public WeException(String message){
        super(message);
    }
    public WeException(Throwable cause){
        super(cause);
    }
    public WeException(String message, Throwable cause){
        super(message,cause);
    }
}
