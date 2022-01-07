package com.zj.springcloud.entities;

public enum Code {
    ERROR(444),
    SUCCESS(200);
    private Integer code;
    Code(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
