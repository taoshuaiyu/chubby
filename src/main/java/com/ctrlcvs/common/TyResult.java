package com.ctrlcvs.common;

/**
 * @author tsy
 * @Description
 * @date 15:37 2017/9/15
 */
public class TyResult {

    private Integer code; //layui 返回成功code默认为0
    private String msg;
    private long count;
    private Object data;

    public TyResult(Integer resCode, String resMsg) {
        this.code = resCode;
        this.msg = resMsg;
    }

    public TyResult(Integer resCode, String resMsg, Object data) {
        this.code = resCode;
        this.msg = resMsg;
        this.data = data;
    }

    public TyResult() {

    }

    public static TyResult success(Object data) {
        return new TyResult(0, "成功", data);
    }

    public static TyResult error(String msg) {
        return new TyResult(500, "失败");
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
