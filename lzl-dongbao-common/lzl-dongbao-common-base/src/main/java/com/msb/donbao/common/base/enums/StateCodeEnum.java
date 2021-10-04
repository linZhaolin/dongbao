package com.msb.donbao.common.base.enums;

import lombok.Builder;
import lombok.Data;

/*
 * 100-199：用户业务的。
 * 200-299：支付业务的。
 * 以此类推。上面例子。
 *
 * */


public enum StateCodeEnum {

    /*
    *
    * 请求失败
    * */

    FAIL(500,"请求失败"),

    /*
    * 请求成功
    *
    * */

    SUCCESS(200,"请求成功");

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    StateCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
