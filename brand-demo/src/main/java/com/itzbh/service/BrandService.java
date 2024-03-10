package com.itzbh.service;

import com.itzbh.mapper.BrandMapper;
import com.itzbh.pojo.Brand;
import com.itzbh.pojo.pagebean;
import com.itzbh.util.SqlSessionFactoryutils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("BrandService")
public class BrandService {
        //获取session工厂
    //ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);

    /*@Autowired
    private BrandMapper brandMapper;*/
     SqlSessionFactory factory=SqlSessionFactoryutils.get_SqlSessionFactory();


    public void InsertBrand(Brand brand){
        //获取sqlsession
        SqlSession sqlSession= factory.openSession(true);
        //获取mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //调用函数
        mapper.insert(brand);
        sqlSession.close();
    }

    public void UpdateBrand(Brand brand){
        SqlSession sqlSession=factory.openSession(true);
        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
        mapper.update(brand);
        sqlSession.close();
    }

    public Brand selectbyid(int id){
        SqlSession sqlSession=factory.openSession(true);
        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectbyid(id);
        sqlSession.close();
        return  brand;
    }

    public void deletebyids(int[] id){
        SqlSession sqlSession=factory.openSession(true);
        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
        mapper.deletebyids(id);
        sqlSession.close();
    }
    public void deletebyid(int id){
        SqlSession sqlSession=factory.openSession(true);
        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
        mapper.deletebyid(id);
        sqlSession.close();
    }

    public pagebean<Brand> selectByPage(int currentPage,int pageSize){
        SqlSession sqlSession=factory.openSession(true);
        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
        //计算
        int begin=(currentPage-1)*pageSize;
        //计算条目数
        int size=pageSize;
        //封装pagebean对象
        List<Brand> rows = mapper.selectByPage(begin, size);
        int totalCount= mapper.selectTotalCount();
        //封装
        pagebean<Brand> brandpagebean = new pagebean<>();
        brandpagebean.setRows(rows);
        brandpagebean.setTotalcount(totalCount);
        //释放资源
        sqlSession.close();

        return brandpagebean;
    }

    public pagebean<Brand> selectByPageAndCondition(int currentPage,int pageSize,Brand brand){
        SqlSession sqlSession=factory.openSession(true);
        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
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
        List<Brand> rows = mapper.selectByPageAndCondition(begin,size,brand);
        int totalCount= mapper.selectTotalCountByCondition(brand);
        //封装
        pagebean<Brand> brandpagebean = new pagebean<>();
        brandpagebean.setRows(rows);
        brandpagebean.setTotalcount(totalCount);
        //释放资源
        sqlSession.close();

        return brandpagebean;
    }

}
