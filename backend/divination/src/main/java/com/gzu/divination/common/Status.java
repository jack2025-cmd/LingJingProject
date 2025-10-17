package com.gzu.divination.common;

import lombok.Getter;

@Getter
public enum Status {
    // 通用请求状态
    SUCCESS(200, "成功"),
    ERROR(400, "未知错误"),

    // 用户

    // 通用异常
    REQUEST_BODY_MISSING(400, "请求体缺失");


    private final Integer code;
    private final String message;

    Status(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
