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
import java.io.IOException;

@WebServlet("/selectByPageservlet")
public class SelectPageServlet extends HttpServlet {
    BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收 当前页码 和 每页展示条数 url?currentPage=&pageSize=
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");

        int currentPage=Integer.parseInt(_currentPage);
        int pageSize=Integer.parseInt(_pageSize);

        //调用service查询
        pagebean<Brand> pagebean = brandService.selectByPage(currentPage, pageSize);

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
