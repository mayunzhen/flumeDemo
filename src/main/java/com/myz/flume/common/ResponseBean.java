package com.myz.flume.common;

import lombok.Data;

/**
 * 公共响应对象
 */
@Data
public class ResponseBean {

    public static ResponseBean SERIAL_ERROR = new ResponseBean(120, "序列化失败");

    public static ResponseBean SYSTEM_ERROR = new ResponseBean(100, "系统异常");

    public static final ResponseBean INVALIDATE_PARAM = new ResponseBean(101, "参数不合法");

    public static final ResponseBean DESERIAL_ERROR = new ResponseBean(121, "反序列化失败");

    public static final ResponseBean TOJSON_ERROR = new ResponseBean(103, "转换失败");

    public static final ResponseBean TOKEN_NULL = new ResponseBean(50010, "token 为空");

    public static final ResponseBean TOKEN_INVALID = new ResponseBean(50020, "token 失效");

    private int code;

    private String msg;

    private Object data;

    public ResponseBean() {

    }

    public ResponseBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseBean(int code, String msg, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseBean(Object data) {
        super();
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

}

