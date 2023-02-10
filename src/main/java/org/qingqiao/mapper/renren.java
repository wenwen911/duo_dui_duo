package org.qingqiao.mapper;

import org.apache.ibatis.annotations.Param;
import org.qingqiao.bean.Ren;
import org.qingqiao.bean.Wuqi;

import java.util.ArrayList;

public interface renren {
    ArrayList<Ren> queryren();

    ArrayList<Wuqi> querywuqi();

    void addren(Ren ren);

    void addwuqi(@Param("nid") Integer nid,@Param("wid") String i);

    Ren queryByid(int id);

    void update(Ren ren);

    void deleteren(@Param("nid")Integer nid, @Param("wid")String s);


    void delete(int nid);
}
