package cn.com.huaruan.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageVo implements Serializable {
    private Integer total;
    private List<User> rows;

    public PageVo(Integer total, List<User> rows) {
        this.total = total;
        this.rows = rows;
    }
}
