package com.itzbh.mapper;

import com.itzbh.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface Usermapper {
    void insert_new_user(@Param("username")String username, @Param("password")String password);

    User get_user(@Param("username") String username, @Param("password") String password);

    User select_by_username(String username);
}
