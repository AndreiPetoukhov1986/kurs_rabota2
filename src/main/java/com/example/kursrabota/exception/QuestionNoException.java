package com.example.kursrabota.exception;

public class QuestionNoException extends RuntimeException{
    public QuestionNoException() {
    }

    public QuestionNoException(String message) {
        super(message);
    }

    public QuestionNoException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionNoException(Throwable cause) {
        super(cause);
    }

    public QuestionNoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
