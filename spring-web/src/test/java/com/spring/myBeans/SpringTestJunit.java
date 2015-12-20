package com.spring.myBeans;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.myBeans.xml.SpringTest3;

public class SpringTestJunit {

	@Test
	public void TestSpring(){
		//sping容器启动后会调用bean的构造方法创建类的实例，但是属性值还没有注入进来
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring/spring-config.xml");
		//获取bean相当于初始化完成了，相应的属性值都被注入进来
		((SpringTest3) ctx.getBean("SpringTest3")).funTest();
		
//		System.out.println(((org.mybatis.spring.SqlSessionTemplate)ctx.getBean("sqlSession")).selectList("selectUser"));
	}
}
