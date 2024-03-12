package com.itzbh.Controller;

import com.itzbh.domain.Brand;
import com.itzbh.domain.each_page;
import com.itzbh.domain.pagebean;
import com.itzbh.service.BrandService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    private BrandService brandService;
    //迁移成功
    @PostMapping("/insert")
    public Result insert(@RequestBody Brand brand) {
        boolean flag=brandService.insert(brand);
        return new Result(flag? Code.SAVE_OK:Code.SAVE_ERROR,flag);
    }
    //迁移成功
    @PutMapping
    public Result update(@RequestBody Brand brand) {
        boolean flag=brandService.update(brand);
        return new Result(flag? Code.UPDATE_OK:Code.UPDATE_OK,flag);
    }
    //迁移成功
    @DeleteMapping("/{id}")
    public Result deletebyid(@PathVariable int id) {
        boolean flag=brandService.deletebyid(id);
        return new Result(flag? Code.DELETE_OK:Code.DELETE_ERROR,flag);
    }
    @DeleteMapping("deletebyids")
    public Result deletebyids(@RequestBody int[] ids) {
        boolean flag=brandService.deletebyids(ids);
        return new Result(flag? Code.DELETE_OK:Code.DELETE_ERROR,flag);
    }
    //迁移成功
    @PostMapping("getbrands")
    public Result selectByPageAndCondition(@RequestBody each_page page){

        System.out.println(page.getBrand().getStatus());
        pagebean<Brand> pagebean = brandService.selectByPageAndCondition(page.getCurrentPage(), page.getPageSize(), page.getBrand());
        int code=pagebean!=null?Code.GET_OK:Code.GET_ERROR;
        String msg=pagebean!=null?"查询成功":"数据查询失败，请重试";
        return new Result(code,pagebean,msg);

    }

}
