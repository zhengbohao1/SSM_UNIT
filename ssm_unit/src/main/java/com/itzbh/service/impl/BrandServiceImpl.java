package com.itzbh.service.impl;

import com.itzbh.domain.Brand;
import com.itzbh.domain.pagebean;
import com.itzbh.mapper.BrandMapper2;
import com.itzbh.service.BrandService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper2 brandmapper;

    @Override
    public List<Brand> selectAll() {
        return brandmapper.selectAll();
    }

    @Override
    public Brand selectbyid(int id) {
        return brandmapper.selectbyid(id);
    }

    @Override
    public List<Brand> selectBycondition(int status, String company_name, String brand_name) {
        return brandmapper.selectBycondition(status, company_name, brand_name);
    }

    @Override
    public List<Brand> selectBycondition(Map map) {
        return brandmapper.selectBycondition(map);
    }

    @Override
    public boolean insert(Brand brand) {
        brandmapper.insert(brand);
        return true;
    }

    @Override
    public boolean update(Brand brand) {
        brandmapper.update(brand);
        return true;
    }

    @Override
    public boolean deletebyid(int id) {
        brandmapper.deletebyid(id);
        return true;
    }

    @Override
    public boolean deletebyids(int[] ids) {
        brandmapper.deletebyids(ids);
        return true;
    }

    @Override
    public pagebean<Brand> selectByPageAndCondition(int currentPage,int pageSize,Brand brand) {
        //计算
        int begin=(currentPage-1)*pageSize;
        //计算条目数
        int size=pageSize;

        String brandName = brand.getBrandName();
        if (brandName != null && brandName.length() > 0) {
            brand.setBrandName("%" + brandName + "%");
        }

        String companyName = brand.getCompanyName();
        if (companyName != null && companyName.length() > 0) {
            brand.setCompanyName("%" + companyName + "%");
        }
        //
        //封装pagebean对象
        List<Brand> rows = brandmapper.selectByPageAndCondition(begin,size,brand);
        int totalCount= brandmapper.selectTotalCountByCondition(brand);
        //封装
        pagebean<Brand> brandpagebean = new pagebean<>();
        brandpagebean.setRows(rows);
        brandpagebean.setTotalcount(totalCount);
        /*//释放资源
        sqlSession.close();*/

        return brandpagebean;
    }


}
