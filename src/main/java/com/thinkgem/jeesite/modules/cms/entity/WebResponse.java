package com.thinkgem.jeesite.modules.cms.entity;

public class WebResponse<T> {

    private String code = "Y";

    private T body;

    private String message;

    public WebResponse() {

    }

    public WebResponse(T body) {
        this.body = body;
    }

    public WebResponse(String code, T body, String message) {
        this.code = code;
        this.body = body;
        this.message = message;
    }


    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
