package org.qingqiao.service;

import org.qingqiao.bean.Ren;
import org.qingqiao.bean.Wuqi;

import java.io.IOException;
import java.util.ArrayList;

public interface renrenServices {
    ArrayList<Ren> queryren() throws IOException;

    ArrayList<Wuqi> querywuqi() throws IOException;

    int add(Ren ren, String[] cds) throws IOException;

    Ren queryByid(int id) throws IOException;

    int update(Ren ren, String[] cds) throws IOException;

    int delete(int nid) throws IOException;
}
