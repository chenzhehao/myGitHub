package com.myself.mybatis.JTA;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.opensymphony.xwork2.ActionSupport;
@Transactional
public class JTATest2  extends ActionSupport {
	private JTATest3 jTest3;
	private JTATest4 jTest4;

	public void funTest() {
		jTest3.addBook();
		jTest4.addBook();
		System.out.println(5 / 0);
	}

	public JTATest3 getjTest3() {
		return jTest3;
	}

	public void setjTest3(JTATest3 jTest3) {
		this.jTest3 = jTest3;
	}

	public JTATest4 getjTest4() {
		return jTest4;
	}

	public void setjTest4(JTATest4 jTest4) {
		this.jTest4 = jTest4;
	}

	public void transactionTest() {
		
	}
	
	public String execute() throws Exception {
		funTest();
		return SUCCESS;
	}
}
