package org.qingqiao.bean;

public class Wuqi {
private Integer wid;
private String name;


    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wuqi() {
    }

    public Wuqi(Integer wid, String name) {
        this.wid = wid;
        this.name = name;
    }
}
