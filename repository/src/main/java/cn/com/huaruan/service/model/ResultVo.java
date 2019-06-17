package cn.com.huaruan.service.model;

import lombok.Data;

@Data
public class ResultVo {
    private String status;
    private String message;

    public ResultVo(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
