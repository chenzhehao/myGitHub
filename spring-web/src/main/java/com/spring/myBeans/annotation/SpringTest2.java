package com.spring.myBeans.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("SpringTest2")
public class SpringTest2 {

	@Autowired
	private SpringTest1 springTest1;
	
	//注入外部属性文件中的变量
	@Value("${properties2.value}")
	private String properties2;
	
	public SpringTest2(){
		System.out.println("SpringTest2="+properties2);
	}
	
	public void funTest(){
		springTest1.funTest();
		System.out.println("funTest2="+properties2);
	}
}
