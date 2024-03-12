package com.example.utils;

public enum MyResultEnum {
    SUCCESS(200, "成功"),
    USER_NOT_EXISTS(100, "用户不存在"),
    DATA_NOT_EXISTS(100, "数据不存在"),
    PASSWORD_ERROR(101, "登录密码错误"),
    TOKEN_ERROR(102, "Token 验证失败"),
    OPERATOR_NOT_ALLOW(103, "操作不允许"),
    DATA_EXISTS(104, "数据已存在"),
    PRARM_ERROR(105, "参数错误"),
    FAIL(400, "失败"),
    NOT_FOUND(404, "不存在"),
    SERVER_ERROR(500, "服务异常");

    private int code;
    private String msg;

    MyResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}