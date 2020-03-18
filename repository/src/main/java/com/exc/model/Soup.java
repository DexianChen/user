package com.exc.model;

import java.io.Serializable;

/**
 * 浓郁靓汤
 * @author cdx
 * date: 2020/03/18
 */
public class Soup implements Serializable{
    private static final long serialVersionUID = -1048483959099801920L;

    private Integer id;

    private String href;

    private String alt;

    private String src;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
