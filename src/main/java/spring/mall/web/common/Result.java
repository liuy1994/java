package spring.mall.web.common;

import org.springframework.stereotype.Component;

public class Result<T> {
    private String msg = "success";
    private Integer code = 200;

    private T data;


    public Result(T data) {
        this.data = data;
    }
    public Result(String msg) {
        this.code = 400;
        this.msg = msg;
    }
    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
