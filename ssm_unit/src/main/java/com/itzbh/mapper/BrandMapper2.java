package com.itzbh.mapper;

import com.itzbh.domain.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
@Mapper
public interface BrandMapper2 {
    List<Brand> selectAll();
    Brand selectbyid(int id);

    List<Brand> selectBycondition(@Param("status") int status, @Param("company_name") String company_name, @Param("brand_name") String brand_name);
    List<Brand> selectBycondition(Map map);

    boolean insert(Brand brand);

    boolean update(Brand brand);

    boolean deletebyid(int id);

    boolean deletebyids(@Param("items") int[] ids);



    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand")Brand brand);

    int selectTotalCount();

    int selectTotalCountByCondition(Brand brand);
}

