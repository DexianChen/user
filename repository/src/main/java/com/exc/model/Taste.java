package com.exc.model;

import java.io.Serializable;

/**
 * 味道
 * @author cdx
 * date: 2020/03/19
 */
public class Taste implements Serializable {
    private static final long serialVersionUID = 867473392760093858L;

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
