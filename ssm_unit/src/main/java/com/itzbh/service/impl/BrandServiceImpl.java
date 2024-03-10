package com.itzbh.service.impl;

import com.itzbh.domain.Brand;
import com.itzbh.mapper.BrandMapper2;
import com.itzbh.service.BrandService;
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
    public List<Brand> selectByPageAndCondition(int begin, int size, Brand brand) {
        return brandmapper.selectByPageAndCondition(begin, size, brand);
    }

    @Override
    public int selectTotalCount() {
        return brandmapper.selectTotalCount();
    }

    @Override
    public int selectTotalCountByCondition(Brand brand) {
        return brandmapper.selectTotalCountByCondition(brand);
    }
}
