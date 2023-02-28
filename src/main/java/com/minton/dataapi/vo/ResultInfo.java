package com.minton.dataapi.vo;


import java.util.HashMap;

public class ResultInfo extends HashMap<String, Object> {

    public static final String CODE_TAG = "code";
    public static final String MSG_TAG = "msg";
    public static final String DATA_TAG = "data";


    public ResultInfo(){
    }

    /**
     * @param code
     * @param msg
     */
    public ResultInfo(Integer code, String msg){
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    /**
     * @param data
     */
    public ResultInfo(Integer code, String msg, Object data){
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if(data != null){
            super.put(DATA_TAG, data);
        }
    }

    public static ResultInfo success(){
        return new ResultInfo(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg());
    }

    public static ResultInfo success(Object obj){
        return new ResultInfo(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg(),obj);
    }
    public static ResultInfo error(){
        return new ResultInfo(ResultEnum.ERROR.getCode(),ResultEnum.ERROR.getMsg());
    }
    public static ResultInfo error(String msg){
        return new ResultInfo(ResultEnum.ERROR.getCode(),msg);
    }
    public static ResultInfo error(Integer code,String msg) {
        return new ResultInfo(code, msg);
    }
}
