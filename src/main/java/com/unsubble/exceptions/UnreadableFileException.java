package com.unsubble.exceptions;

public class UnreadableFileException extends RuntimeException {

    public UnreadableFileException(String msg) {
        super(msg);
    }
}
