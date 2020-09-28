package io.haicheng.cfundtool.domain;

import java.io.Serializable;
import lombok.Data;

/**
 */
@Data
public class ServiceVO<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;
    private T info;

    public ServiceVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ServiceVO(int code, String msg, T info) {
        this.code = code;
        this.msg = msg;
        this.info = info;
    }

}
