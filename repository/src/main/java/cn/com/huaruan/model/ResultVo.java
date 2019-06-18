package cn.com.huaruan.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultVo implements Serializable {
    private Boolean status;
    private String message;

    public ResultVo(Boolean status, String message) {
        this.status = status;
        this.message = message;
    }
}
