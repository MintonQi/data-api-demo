package com.minton.dataapi.vo;

public enum ResultEnum {
    SUCCESS(200, "成功"),
    ERROR(500, "网络异常"),
    PARAM_INVALID(1001, "无效参数");

    private int code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
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

    /**
     * 通过状态码返回相应信息
     * @param code
     * @return msg
     */
    public static String getMsgByCode(Integer code){
        for(ResultEnum ele : values()){
            if(ele.getCode() == code){
                return ele.getMsg();
            }
        }
        return null;
    }
}
