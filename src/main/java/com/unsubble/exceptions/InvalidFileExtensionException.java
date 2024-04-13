package com.unsubble.exceptions;

public class InvalidFileExtensionException extends RuntimeException {

    public InvalidFileExtensionException(String expected, String actual) {
        super(String.format("Invalid file extension! expected: <%s> found: <%s>", expected, actual));
    }


}
