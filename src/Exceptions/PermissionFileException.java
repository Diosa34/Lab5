package Exceptions;

public class PermissionFileException extends Throwable{
    String message;
    public PermissionFileException(String s) {
        this.message = s;
    }
}
