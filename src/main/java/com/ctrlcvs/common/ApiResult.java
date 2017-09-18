package com.ctrlcvs.common;

/**
 * @author tsy
 * @Description
 * @date 15:37 2017/9/15
 */
public class ApiResult {

    private Integer resCode;
    private String resMsg;
    private Object obj;

    public ApiResult(Integer resCode, String resMsg) {
        this.resCode = resCode;
        this.resMsg = resMsg;
    }

    public ApiResult(Integer resCode, String resMsg, Object obj) {
        this.resCode = resCode;
        this.resMsg = resMsg;
        this.obj = obj;
    }

    public ApiResult() {

    }

    public ApiResult success(Object obj) {
        return new ApiResult(200, "成功", obj);
    }

    public ApiResult error(String msg) {
        return new ApiResult(500, "失败");
    }

    public Integer getResCode() {
        return resCode;
    }

    public void setResCode(Integer resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }
}
