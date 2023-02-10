package org.qingqiao.bean;

import java.util.List;

public class Ren {
    private Integer nid;
    private String name;
    private Integer age;
    private List<Zhongjianshang> mc;

    public Ren(Integer nid, String name, Integer age) {
        this.nid = nid;
        this.name = name;
        this.age = age;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Zhongjianshang> getMc() {
        return mc;
    }

    public void setMc(List<Zhongjianshang> mc) {
        this.mc = mc;
    }

    public Ren() {
    }

    public Ren(Integer nid, String name, Integer age, List<Zhongjianshang> mc) {
        this.nid = nid;
        this.name = name;
        this.age = age;
        this.mc = mc;
    }
}
