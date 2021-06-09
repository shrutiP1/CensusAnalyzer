package com.bridgeLabz.indiancensus;

public class CustomeException extends Exception
{
    private ExceptionType exceptionType;

    public CustomeException(String message, ExceptionType exceptionType)
    {
        super(message);
        this.exceptionType=exceptionType;


    }

    public static enum ExceptionType
    {
        NO_EXTENSION_FOUND,WRONG_FILE_CONTENT

    }
}
