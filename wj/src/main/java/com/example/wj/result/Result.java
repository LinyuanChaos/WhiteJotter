package com.example.wj.result;

import lombok.Data;

@Data
public class Result {
    int code;
    String message;
    Object result;

    Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.result = data;
    }
}
