package com.exc.model;

import java.io.Serializable;
import java.util.List;

public class PageVo implements Serializable {
    private static final long serialVersionUID = -57797528313042975L;

    private Integer total;
    private List<Menu> rows;

    public PageVo(Integer total, List<Menu> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Menu> getRows() {
        return rows;
    }

    public void setRows(List<Menu> rows) {
        this.rows = rows;
    }
}
