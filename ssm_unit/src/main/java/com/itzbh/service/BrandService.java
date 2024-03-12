package com.itzbh.service;

import com.itzbh.domain.Brand;
import com.itzbh.domain.pagebean;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Transactional
public interface BrandService {
    List<Brand> selectAll();
    Brand selectbyid(int id);

    List<Brand> selectBycondition(@Param("status") int status, @Param("company_name") String company_name, @Param("brand_name") String brand_name);
    List<Brand> selectBycondition(Map map);

    boolean insert(Brand brand);

    boolean update(Brand brand);

    boolean deletebyid(int id);

    boolean deletebyids(@Param("items") int[] ids);

    pagebean<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand")Brand brand);



}
