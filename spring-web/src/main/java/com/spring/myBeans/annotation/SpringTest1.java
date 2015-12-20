package com.spring.myBeans.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("SpringTest1")
public class SpringTest1 {
	//引入日志
	protected final Logger looger = LoggerFactory.getLogger(this.getClass());
	
	//注入外部属性文件中的变量
	@Value("${properties1.value}")
	private String properties1;

	public SpringTest1() {
		System.out.println("SpringTest1="+properties1);
//		looger.debug("dubug");
	}
	public void funTest(){
		System.out.println("funTest1="+properties1);
	}
	
}
