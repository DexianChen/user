package com.exc.model;

import java.io.Serializable;

/**
 * @author cdx
 * date: 2020/03/19
 */
public class Category implements Serializable {
    private static final long serialVersionUID = 5506999935896069251L;

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
