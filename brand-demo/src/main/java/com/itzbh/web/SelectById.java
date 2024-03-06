package com.itzbh.web;

import com.itzbh.pojo.Brand;
import com.itzbh.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectbyid")
public class SelectById extends HttpServlet {
    BrandService service=new BrandService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        Brand brand = service.selectbyid(Integer.parseInt(id));
        req.setAttribute("brand",brand);
        req.getRequestDispatcher("/update.jsp").forward(req,resp);
    }
}
