package com.myself.mybatis;

import org.mybatis.spring.SqlSessionTemplate;
/*
 * 每个继承这个接口的类都可以直接进行数据库操作
 */
public abstract interface SpringMybatisInterface {
	public abstract void setSqlSession(SqlSessionTemplate sqlSession);
}
