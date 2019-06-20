package cn.com.huaruan.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class RequestParamVo implements Serializable {
    private String account;
    private String pwd;
    private String realName;
    private int sex;
    private String idCard;
    private String phone;
    private String addressProvince;
    private String addressCity;
    private String addressArea;
    private String addressDetails;
    private String email;
    private String picture;
}
