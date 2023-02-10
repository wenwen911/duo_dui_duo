package org.qingqiao.bean;

public class Zhongjianshang {
    private Integer id;
    private Ren ren;
    private Wuqi wuqi;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ren getRen() {
        return ren;
    }

    public void setRen(Ren ren) {
        this.ren = ren;
    }

    public Wuqi getWuqi() {
        return wuqi;
    }

    public void setWuqi(Wuqi wuqi) {
        this.wuqi = wuqi;
    }

    public Zhongjianshang() {
    }

    public Zhongjianshang(Integer id, Ren ren, Wuqi wuqi) {
        this.id = id;
        this.ren = ren;
        this.wuqi = wuqi;
    }
}
