package com.d6td.bbs.core;

import com.alibaba.fastjson.JSON;

/**
 * 统一API响应结果封装
 *
 * @author xuxinlong
 */
public class Result<T> {
    private static final String DEFAULT_SUCCESS_MESSAGE = "success";

    private int code;

    private String message;

    private T data;

    public Result<T> setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Result<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static <T> Result<T> success() {
        return new Result<T>()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> Result<T> fail(String message) {
        return new Result<T>()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }
}
