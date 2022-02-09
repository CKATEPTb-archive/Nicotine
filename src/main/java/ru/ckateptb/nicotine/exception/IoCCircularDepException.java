package ru.ckateptb.nicotine.exception;

public class IoCCircularDepException extends Exception {
    public IoCCircularDepException(String message) {
        super(message);
    }
}
