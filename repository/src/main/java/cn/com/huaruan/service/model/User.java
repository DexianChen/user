package cn.com.huaruan.service.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer userId;
    private String password;
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
