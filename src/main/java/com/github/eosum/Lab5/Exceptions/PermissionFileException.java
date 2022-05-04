package com.github.eosum.Lab5.Exceptions;

public class PermissionFileException extends Throwable{
    String message;
    public PermissionFileException(String s) {
        this.message = s;
    }
}
