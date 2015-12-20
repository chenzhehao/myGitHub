package com.myself.mybatis;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Repository;

@Repository("SpringMybatisRoot")
public class SpringMybatisRoot implements BeanPostProcessor {
	@Autowired
	@Qualifier("sqlSession")
	private SqlSessionTemplate sqlSession;

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	//其中BeanPostProcessor的前置和后置处理的方法中都要返回该bean，不能是null，不然在getBean的时候获取不到，
	//被这个坑爹的，害我找问题找了半天
	public Object postProcessAfterInitialization(Object bean, String name) throws BeansException {
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean, String name) throws BeansException {
		if (bean instanceof SpringMybatisInterface) {
			((SpringMybatisInterface) bean).setSqlSession(this.sqlSession);
		}
		return bean;
	}

}
