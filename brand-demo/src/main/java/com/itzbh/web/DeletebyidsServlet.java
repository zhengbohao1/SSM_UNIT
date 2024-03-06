package com.itzbh.web;

import com.alibaba.fastjson.JSON;
import com.itzbh.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/deletebyids")
public class DeletebyidsServlet extends HttpServlet {
    BrandService service=new BrandService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String params = reader.readLine();

        int[] ids = JSON.parseObject(params, int[].class);
        try {
            service.deletebyids(ids);
        } catch (Exception e) {
            resp.getWriter().write("error");
        }
        resp.getWriter().write("success");
    }
}
