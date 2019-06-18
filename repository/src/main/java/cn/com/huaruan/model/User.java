package cn.com.huaruan.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private Integer userId;
    private String account;
    private String pwd;
    private String realName;
    /**
     * 性别, 0-男; 1-女
     */
    private int sex;
    private String idCard;
    private String phone;
    private String address;
    private String email;
    private String picture;
    private Date registeredTime;
}
