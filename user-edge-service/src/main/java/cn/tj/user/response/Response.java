package cn.tj.user.response;

import java.io.Serializable;

public class Response implements Serializable {

    public static final Response USERNAME_PASSWORD_INVALID = new Response("1001","username or password invalid");

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
