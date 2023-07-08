package com.platforms.secondhandbase;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
public class MyResult<T> implements Serializable{
    //code
    private String code = "";
    //返回信息
    private String msg = "";
    // 数据列表
    private List<T> result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public MyResult(String code, String msg, List<T> result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public MyResult() {
    }
}
