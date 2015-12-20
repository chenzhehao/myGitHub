package com.myself.mybatis.interfaces;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface UserService {
	@Insert(" insert into users (id,username,password) values (#{id},#{username},#{password})")  
    void add(@Param("id")Integer id,@Param("username") String username,@Param("password")String password);  
 
    @Delete(" delete from users where id=#{id}")   
    void delete(Integer id);  
 
    @Update(" update users set username=#{username},password=#{password} where id=#{id}")  
    int update(@Param("username") String username,@Param("password")String password,@Param("id")Integer id);  
 
}
