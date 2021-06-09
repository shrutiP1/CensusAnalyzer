package com.bridgeLabz.indiancensus;

public class CustomeException extends Exception
{

    public ExceptionType exceptionType;

    public CustomeException(String message, ExceptionType exceptionType)
    {
        super(message);
        this.exceptionType=exceptionType;

    }

    public  enum ExceptionType
    {
        NO_EXTENSION_FOUND,UNABLE_TO_PARSE,CENSUS_FILE_PROBLEM;


    }
}
