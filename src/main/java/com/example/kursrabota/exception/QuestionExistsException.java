package com.example.kursrabota.exception;

public class QuestionExistsException extends RuntimeException {
    public QuestionExistsException() {
    }

    public QuestionExistsException(String message) {
        super(message);
    }

    public QuestionExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionExistsException(Throwable cause) {
        super(cause);
    }

    public QuestionExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
