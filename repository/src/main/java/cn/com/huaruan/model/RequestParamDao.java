package cn.com.huaruan.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class RequestParamDao implements Serializable {
    private String account;
    private String pwd;
    private String realName;
    private int sex;
    private String idCard;
    private String phone;
    private String address;
    private String email;
    private String picture;

    public RequestParamDao(RequestParamVo requestParamVo) {
        this.account = requestParamVo.getAccount();
        this.pwd = requestParamVo.getPwd();
        this.realName = requestParamVo.getRealName();
        this.sex = requestParamVo.getSex();
        this.idCard = requestParamVo.getIdCard();
        this.phone = requestParamVo.getPhone();
        this.address = requestParamVo.getAddress().toString();
        this.email = requestParamVo.getEmail();
        this.picture = requestParamVo.getPicture();
    }
}
