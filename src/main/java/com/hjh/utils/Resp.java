package com.hjh.utils;

// 同信息的响应格式
public class Resp<T> {
    private int code = 200;
    private String msg = "success";
    private T data;

    private Resp(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    // 响应成功时，调用success方法
    public static <T> Resp success(T data){
        return new Resp(200,"success",data);
    }

    // 响应成功时，调用success方法
    public static <T> Resp success(String msg,T data){
        return new Resp(200,msg,data);
    }

    // 响应失败时，调用error方法
    public static <T> Resp error(int code,String msg){
        return new Resp(code, msg, null);
    }

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
