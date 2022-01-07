package cn.kgc.yang.util;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class R {
    //成功状态
    private boolean success;
    //  响应消息
    private String message;
    // 响应码
    private Integer code;
    //返回数据
    private Object data;

    // 成功
    private static final String DEFAULT_SUCCESS_MESSAGE = "ok";
    private static final Integer DEFAULT_SUCCESS_CODE = 20000;

    //失败
    private static final String DEFAULT_FAIL_MESSAGE = "ERROR";
    private static final Integer DEFAULT_FAIL_CODE = 50000;

    //私有的构造函数
    private R(Boolean success, String message, Integer code, Object data) {
        this.success = success;
        this.message = message;
        this.code = code;
        this.data = data;
    }

    //成功
    public static R success() {
        R r = new R(true, DEFAULT_SUCCESS_MESSAGE, DEFAULT_SUCCESS_CODE, null);
        return r;
    }

    // 含带 自定义消息  做增删改
    public static R success(String message) {
        R r = new R(true, message, DEFAULT_SUCCESS_CODE, null);
        return r;
    }

    //做查询  成功
    public static R success(Object data) {
        R r = new R(true, DEFAULT_SUCCESS_MESSAGE, DEFAULT_SUCCESS_CODE, data);
        return r;
    }

    //做返回字符串
    public static R success(String message, Object data) {
        R r = new R(true, message, DEFAULT_SUCCESS_CODE, data);
        return r;
    }


    //失败
    public static R fail() {//默认
        R r = new R(false, DEFAULT_FAIL_MESSAGE, DEFAULT_FAIL_CODE, null);
        return r;
    }

    public static R fail(String message) {//默认
        R r = new R(false, message, DEFAULT_FAIL_CODE, null);
        return r;
    }

    public static R fail(Integer code) {
        R r = new R(false, DEFAULT_FAIL_MESSAGE, code, null);
        return r;
    }

    public static R fail(String message, Integer code) {
        R r = new R(false, message, code, null);
        return r;
    }
}
