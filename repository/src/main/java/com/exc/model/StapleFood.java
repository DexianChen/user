package com.exc.model;

import java.io.Serializable;

/**
 * 美味主食
 * @author cdx
 * date: 2020/03/18
 */
public class StapleFood implements Serializable {
    private static final long serialVersionUID = 7415493404529837195L;

    private Integer id;

    private String href;

    private String alt;

    private String src;

    private String desc;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
