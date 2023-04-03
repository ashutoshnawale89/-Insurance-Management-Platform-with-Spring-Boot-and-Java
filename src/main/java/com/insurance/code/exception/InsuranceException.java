package com.insurance.code.exception;

public class InsuranceException extends RuntimeException {



    public enum ExceptionType {
        EMAIL_NOT_FOUND,
        PASSWORD_INVALID,
        USER_ALREADY_PRESENT,
        BOOK_ALREADY_PRESENT,

        USER_NOT_FOUND,

    }

    public ExceptionType type;


    public InsuranceException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public InsuranceException(String message) {
        super(message);
    }
}
