package com.example.kursrabota.exception;

public class QuestionsIsEmptyException extends RuntimeException{
    public QuestionsIsEmptyException() {
    }

    public QuestionsIsEmptyException(String message) {
        super(message);
    }

    public QuestionsIsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionsIsEmptyException(Throwable cause) {
        super(cause);
    }

    public QuestionsIsEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
