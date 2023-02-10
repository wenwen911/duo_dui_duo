package org.qingqiao.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.qingqiao.bean.Ren;
import org.qingqiao.bean.Wuqi;
import org.qingqiao.mapper.renren;

import java.io.IOException;
import java.util.ArrayList;

public class renrenServlert implements renrenServices {






    @Override
    public ArrayList<Ren> queryren() throws IOException {
        SqlSessionFactory sse = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybaties.xml"));
        SqlSession session = sse.openSession();
        renren mapper = session.getMapper(renren.class);
        ArrayList<Ren> list = mapper.queryren();
        return list;
    }

    @Override
    public ArrayList<Wuqi> querywuqi() throws IOException {
        SqlSessionFactory sse = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybaties.xml"));
        SqlSession session = sse.openSession();
        renren mapper = session.getMapper(renren.class);
        ArrayList<Wuqi> list = mapper.querywuqi();
        return list;
    }

    @Override
    public int add(Ren ren, String[] cds) throws IOException {
        int i = 0;
        SqlSessionFactory sse = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybaties.xml"));
        SqlSession session = sse.openSession();
        renren mapper = session.getMapper(renren.class);
        mapper.addren(ren);

        for (String cdd : cds){
            mapper.addwuqi(ren.getNid(),cdd);
        }

        session.commit();
        i=1;
        return i;

    }

    @Override
    public Ren queryByid(int id) throws IOException {
        SqlSessionFactory sse = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybaties.xml"));
        SqlSession session = sse.openSession();
        renren mapper = session.getMapper(renren.class);
        return mapper.queryByid(id);
    }

    @Override
    public int update(Ren ren, String[] cds) throws IOException {
        SqlSessionFactory sse = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybaties.xml"));
        SqlSession session = sse.openSession();
        renren mapper = session.getMapper(renren.class);
        mapper.update(ren);
        //删除中间表在进行添加
        mapper.deleteren(ren.getNid(),"");
        //人改了改武器
        for (String cdd : cds){
            mapper.addwuqi(ren.getNid(),cdd);
        }
        session.commit();
        return 1;
    }

    @Override
    public int delete(int nid) throws IOException {
        SqlSessionFactory sse = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybaties.xml"));
        SqlSession session = sse.openSession();
        renren mapper = session.getMapper(renren.class);
        mapper.delete(nid);
        session.commit();
        return 1;
    }
}
