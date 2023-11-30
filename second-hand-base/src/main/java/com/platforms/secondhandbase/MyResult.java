package com.platforms.secondhandbase;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class MyResult<T> implements Serializable{
    //code
    private String code = "";
    //返回信息
    private String msg = "";

    private String url = "";
    // 数据列表
    private List<T> results;

    private T result;

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

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public MyResult(String code, String msg, List<T> results) {
        this.code = code;
        this.msg = msg;
        this.results = results;
    }

    public MyResult() {
        results = new ArrayList<T>();
    }
}
