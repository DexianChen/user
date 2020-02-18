package com.exc.model;

import java.io.Serializable;

/**
 * @author cdx
 * date 2020-02-18
 * 响应实体类
 */
public class ResultVo implements Serializable {
    private static final long serialVersionUID = -8211501960615037081L;
    /**
     * 响应状态
     */
    private Boolean status;
    /**
     * 响应信息
     */
    private String message;

    public ResultVo(Boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
