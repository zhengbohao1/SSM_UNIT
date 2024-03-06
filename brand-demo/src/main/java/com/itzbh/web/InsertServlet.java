package com.itzbh.web;

import com.alibaba.fastjson.JSON;
import com.itzbh.pojo.Brand;
import com.itzbh.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addservlet")
public class InsertServlet extends HttpServlet {
   /* WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
    BrandService service = context.getBean(BrandService.class);*/
    BrandService service=new BrandService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedReader br=req.getReader();
        String s = br.readLine();
        Brand brand = JSON.parseObject(s, Brand.class);

        try {
            service.InsertBrand(brand);
        } catch (Exception e) {
            System.out.println("插入失败");
            System.out.println(e);
            resp.getWriter().write("error");
        }
        System.out.println("插入成功");
        resp.getWriter().write("success");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
