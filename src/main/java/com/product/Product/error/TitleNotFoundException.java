package com.product.Product.error;

public class TitleNotFoundException extends Exception{
    TitleNotFoundException(){
        super();
    }

    public TitleNotFoundException(String message){
        super(message);
    }

    public TitleNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

    public TitleNotFoundException(Throwable cause){
        super(cause);
    }

    protected TitleNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
