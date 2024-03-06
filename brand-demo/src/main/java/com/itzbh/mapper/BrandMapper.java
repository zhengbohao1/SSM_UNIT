package com.itzbh.mapper;


import com.itzbh.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    List<Brand> selectAll();
    Brand selectbyid(int id);

    List<Brand> selectBycondition(@Param("status") int status,@Param("company_name") String company_name,@Param("brand_name") String brand_name);
    List<Brand> selectBycondition(Map map);

    void insert(Brand brand);

    void update(Brand brand);

    void deletebyid(int id);

    void deletebyids(@Param("items") int[] ids);

    List<Brand> selectByPage(@Param("begin") int begin,@Param("size") int size);

    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand")Brand brand);

    int selectTotalCount();

    int selectTotalCountByCondition(Brand brand);
}
