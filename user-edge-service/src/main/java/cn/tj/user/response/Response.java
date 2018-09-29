package cn.tj.user.response;

import java.io.Serializable;

public class Response implements Serializable {

    public static final Response USERNAME_PASSWORD_INVALID = new Response("1001","username or password invalid");

    public static final Response MOBILE_OR_EMAIL_REQUIRED = new Response("1002","mobile or email invalid");

    public static final Response SEND_VARIFYCODE_FAILD = new Response("1003","send varify code faild");

    public static final Response VERIFY_CODE_INVALID = new Response("1004","verify code invalid");

    public static final Response SUCCESS = new Response();

    private String code;
    private String messgae;

    public Response() {
        this.code = "0";
        this.messgae = "success";
    }

    public Response(String code, String messgae){
        this.code = code;
        this.messgae = messgae;
    }

    public static Response exception(Exception e) {
        return new Response("9999", e.getMessage());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }
}
