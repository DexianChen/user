package cn.com.huaruan.model;

import lombok.Data;

@Data
public class AddressVo {
    private String province;
    private String city;
    private String area;
    private String suffix;

    @Override
    public String toString() {
        return province +  city  + area + suffix;
    }
}
