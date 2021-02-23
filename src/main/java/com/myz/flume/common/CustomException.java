package com.myz.flume.common;

public class CustomException extends RuntimeException {
    private static final long serialVersionUID = 5548597370439218144L;

    private int code;

    private String msg;

    public CustomException(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public CustomException(int code, String msg, Throwable cause) {
        super(cause);
        this.code = code;
        this.msg = msg;

    }

}

