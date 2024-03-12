package com.example.utils;

public class MyResultBuilder {
    public static <T> MyResult<T> success() {
        return new MyResult<>(MyResultEnum.SUCCESS.getCode(), MyResultEnum.SUCCESS.getMsg(), null);
    }

    public static <T> MyResult<T> success(String msg) {
        return new MyResult<>(MyResultEnum.SUCCESS.getCode(), msg, null);
    }

    public static <T> MyResult<T> success(T data) {
        return new MyResult<>(MyResultEnum.SUCCESS.getCode(), MyResultEnum.SUCCESS.getMsg(), data);
    }

    public static <T> MyResult<T> success(String msg, T data) {
        return new MyResult<>(MyResultEnum.SUCCESS.getCode(), msg, data);
    }

    public static <T> MyResult<T> error() {
        return new MyResult<>(MyResultEnum.SERVER_ERROR.getCode(), MyResultEnum.SERVER_ERROR.getMsg(), null);
    }

    public static <T> MyResult<T> error(String msg) {
        return new MyResult<>(MyResultEnum.SERVER_ERROR.getCode(), msg, null);
    }

    public static <T> MyResult<T> error(int code, String msg) {
        return new MyResult<>(code, msg, null);
    }

    public static <T> MyResult<T> error(MyResultEnum resultEnum) {
        return new MyResult<>(resultEnum.getCode(), resultEnum.getMsg(), null);
    }
}