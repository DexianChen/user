package cn.com.huaruan.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String addressProvince;
    private String addressCity;
    private String addressArea;
    private String addressDetails;
    private String email;
    private String picture;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date registeredTime;
}
