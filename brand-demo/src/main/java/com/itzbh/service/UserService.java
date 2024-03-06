package com.itzbh.service;

import com.itzbh.mapper.BrandMapper;
import com.itzbh.mapper.Usermapper;
import com.itzbh.pojo.Brand;
import com.itzbh.pojo.User;
import com.itzbh.util.SqlSessionFactoryutils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {
        //获取session工厂
     SqlSessionFactory factory=SqlSessionFactoryutils.get_SqlSessionFactory();
    public User login(String username,String password){
        //获取sqlsession
        SqlSession sqlSession= factory.openSession(true);
        //获取mapper
        Usermapper mapper = sqlSession.getMapper(Usermapper.class);
        //调用函数

        User user=mapper.get_user(username,password);
        sqlSession.close();
        return user;
    }

    public boolean Register(String username,String password){
        //获取sqlsession
        SqlSession sqlSession= factory.openSession(true);
        //获取mapper
        Usermapper mapper = sqlSession.getMapper(Usermapper.class);
        //调用函数
        User user=mapper.select_by_username(username);
        if(user==null){
            //可以注册
            mapper.insert_new_user(username, password);

            return  true;
        }
        else{
            //不可以注册
            sqlSession.close();
            return false;
        }
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
        return  brand;
    }
}
