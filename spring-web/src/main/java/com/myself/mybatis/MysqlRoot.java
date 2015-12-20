package com.myself.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.myself.mybatis.interfaces.UserService;

public class MysqlRoot {
	private static SqlSessionFactory sqlSessionFactory = null;
	private static SqlSession sqlSession = null;
	private static Reader reader ;
	// 使用xml
	public static SqlSession getSqlSessionXML(){
		 try {
	        	//将数据库的配置文件加载进来
			 	reader = Resources.getResourceAsReader("mybatis/SqlMapConfig.xml");
	            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	            sqlSession = sqlSessionFactory.openSession();
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		return sqlSession;
	}
	
	//使用注解
	public static SqlSession getSqlSessionAnno(){
		 try {
	        	//将数据库的配置文件加载进来
			 	reader = Resources.getResourceAsReader("mybatis/SqlMapConfig.xml");
	            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	            /**
	             * 此处一定要将自己的接口注册进去，不然报错
	             * Type interface xxxx is  not known to the MapperRegistry
	             */
	            sqlSessionFactory.getConfiguration().addMapper(UserService.class); 
	            sqlSession = sqlSessionFactory.openSession();
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		return sqlSession;
	}
}
