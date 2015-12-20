package com.myself.mybatis;

import org.mybatis.spring.SqlSessionTemplate;

public class SpringMybatisClass implements SpringMybatisInterface {
	private SqlSessionTemplate sqlSession;

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

}
