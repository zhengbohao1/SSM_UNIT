package com.itzbh.web;

import com.alibaba.fastjson.JSON;
import com.itzbh.pojo.Brand;
import com.itzbh.pojo.pagebean;
import com.itzbh.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/selectByPageAndConditionservlet")
public class SelectPageAndConditionServlet extends HttpServlet {
    BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //post请求乱码的问题
        req.setCharacterEncoding("utf-8");
        //接收 当前页码 和 每页展示条数 url?currentPage=&pageSize=
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");

        int currentPage=Integer.parseInt(_currentPage);
        int pageSize=Integer.parseInt(_pageSize);

        //获取对应的查询条件对象
        BufferedReader br = req.getReader();
        String params = br.readLine();

        //转为brand
        Brand brand = JSON.parseObject(params, Brand.class);

        System.out.println(brand);

        //调用service查询
        //pagebean<Brand> pagebean = brandService.selectByPageAndCondition(currentPage, pageSize,brand);
        pagebean<Brand> pagebean = brandService.selectByPageAndCondition(currentPage, pageSize,brand);
        //用fastJason把brands转换为json
        String jsonString = JSON.toJSONString(pagebean);
        //再把这个json转走
        resp.setContentType("text/JSON;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }



}
