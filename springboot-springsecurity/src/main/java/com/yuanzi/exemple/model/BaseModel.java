package com.yuanzi.exemple.model;

import com.yuanzi.exemple.util.StatusConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by ZuoYun on 12/06/2017.
 * Time: 10:53 PM
 * Information:
 */
@ApiModel(value = "标准响应头")
public class BaseModel {

    @ApiModelProperty(value = "状态码")
    private Integer status;
    @ApiModelProperty(value = "错误消息")
    private String msg;
    @ApiModelProperty(value = "结果集")
    private Object data;

    public static BaseModel buildSuccess(Object o) {
        return new BaseModel().setData(o).setMsg("响应成功！").setStatus(StatusConstant.SUCCESS.val());
    }

    public static BaseModel buildSuccess() {
        return new BaseModel().setData("请求执行成功").setMsg("响应成功！").setStatus(StatusConstant.SUCCESS.val());
    }

    public static BaseModel buildFail(StatusConstant statusConstant) {
        return new BaseModel().setData("").setMsg(statusConstant.msg()).setStatus(statusConstant.val());
    }

    public static BaseModel buildFail(StatusConstant statusConstant, String data) {
        return new BaseModel().setData(data).setMsg(statusConstant.msg()).setStatus(statusConstant.val());
    }


    public Integer getStatus() {
        return status;
    }

    public BaseModel setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public BaseModel setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public BaseModel setData(Object data) {
        this.data = data;
        return this;
    }
}
