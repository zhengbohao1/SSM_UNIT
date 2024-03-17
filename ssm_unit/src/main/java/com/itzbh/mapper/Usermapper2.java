package com.itzbh.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.itzbh.domain.User;
@Mapper
public interface Usermapper2 {
    void insert_new_user(@Param("username")String username, @Param("password")String password);

    User get_user(@Param("username") String username, @Param("password") String password);

    User select_by_username(String username);
}
