package org.qingqiao.servlert;

import com.alibaba.fastjson.JSON;
import org.qingqiao.bean.Ren;
import org.qingqiao.bean.Wuqi;
import org.qingqiao.service.renrenServices;
import org.qingqiao.service.renrenServlert;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/dao")
public class RRservlert extends HttpServlet {
    renrenServices aaa = new renrenServlert();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/http;charset=UTF-8");
        String m = request.getParameter("m");
        if ("queryren".equals(m)){
            queryren(request,response);
        }else if ("add".equals(m)){
            add(request,response);
        }else if ("delete".equals(m)){
            delete(request,response);
        }else if ("update".equals(m)){
            update(request,response);
        }else if ("querywuqi".equals(m)){
            querywuqi(request,response);
        }else if ("queryByid".equals(m)){
            queryByid(request,response);
        }
    }

    private void queryByid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Ren user=aaa.queryByid(id);
        String s = JSON.toJSONString(user);
        response.getWriter().print(s);
    }

    private void querywuqi(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<Wuqi> list = aaa.querywuqi();
        String s = JSON.toJSONString(list);
        response.getWriter().print(s);

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int nid = Integer.parseInt(request.getParameter("nid"));
        System.out.println("+++++++++++++"+nid);
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String[] cds = request.getParameterValues("cd");
        System.out.println(cds);
        Ren ren = new Ren(nid, name, age);
        int i=aaa.update(ren,cds);
        response.getWriter().print(i>0);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int nid = Integer.parseInt(request.getParameter("nid"));
        int i =aaa.delete(nid);
        response.getWriter().print(i>0);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String[] cds = request.getParameterValues("cd");
        System.out.println(cds);
        Ren ren = new Ren(null, name, Integer.parseInt(age));
        int i = aaa.add(ren,cds);
        response.getWriter().print(i>0);

    }

    private void queryren(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Ren> list = aaa.queryren();
        System.out.println(list);
        request.setAttribute("am",list);
        request.getRequestDispatcher("renrenren/list.jsp").forward(request,response);

    }
}
