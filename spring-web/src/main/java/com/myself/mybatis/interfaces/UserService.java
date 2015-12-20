package com.myself.mybatis.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.myself.mybatis.Mappers.User;
import com.myself.mybatis.Mappers.UserRoleInfo;
import com.myself.mybatis.Providers.TestSqlProvider;

public interface UserService {
	// 返回一个存储User的List
	@Select("select * from users")
	public List<User> getAllUsers();

	@Select("select u.id,u.username,password,password_salt,role_name from users u ,user_roles r "
			+ "where u.id = r.id and u.username = r.username;")
	@Options(useCache = true, flushCache = false, timeout = 10000)
	@Results(value = {
			@Result(id = true, property = "id", column = "id", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "username", column = "username", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "password", column = "password", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "password_salt", column = "password_salt", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "role_name", column = "role_name", javaType = String.class, jdbcType = JdbcType.VARCHAR)})
	public List<UserRoleInfo> getUserRoleInfo();

	@Insert(" insert into users (id,username,password) values (#{id},#{username},#{password})")
	void add(@Param("id") Integer id, @Param("username") String username, @Param("password") String password);

	@Delete(" delete from users where id=#{id}")
	void delete(Integer id);

	@Update(" update users set username=#{username},password=#{password} where id=#{id}")
	int update(@Param("username") String username, @Param("password") String password, @Param("id") Integer id);

}
