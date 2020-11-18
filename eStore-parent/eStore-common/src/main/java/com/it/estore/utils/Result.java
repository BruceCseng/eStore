package com.it.estore.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "Result",value = "Result")
public class Result<T> implements Serializable {

    @ApiModelProperty(value = "执行是否成功",required = true)
    private boolean flag;

    @ApiModelProperty(value = "返回状态码",required = true)
    private Integer code;

    @ApiModelProperty(value = "提示信息",required = true)
    private String message;

    @ApiModelProperty(value = "逻辑数据",required = true)
    private T data;

    public Result() {
    }

    public Result(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = (T) data;
    }

    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
