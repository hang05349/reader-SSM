package com.imooc.reader.service.exception;

/**
 * @author : [xieHang]
 * @version : [v1.0.0]
 * @date : [2021/11/23 20:47]
 * Description   : [业务逻辑异常]
 */
public class BussinessException extends RuntimeException {
    private String code;
    private String msg;

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

    public BussinessException(String code, String msg){
        super(code+":"+msg);
        this.code = code;
        this.msg = msg;

    }

}
