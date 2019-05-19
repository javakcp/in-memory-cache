package com.kcp.in.memory.service.exception;

/**
 * 
 * @author kapanda
 *
 */
public class InMemoryServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InMemoryServiceException() {
        super();
    }

    public InMemoryServiceException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public InMemoryServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public InMemoryServiceException(String message) {
        super(message);
    }

    public InMemoryServiceException(Throwable cause) {
        super(cause);
    }
}
