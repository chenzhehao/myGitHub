package com.myself.struts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.myself.mybatis.MysqlRoot;
import com.opensymphony.xwork2.ActionSupport;

public class StrutsTest extends ActionSupport{

	String username;
	String password;
	String aa;
	public String getAa() {
		return aa;
	}
	public void setAa(String aa) {
		this.aa = aa;
	}

	private SqlSessionTemplate sqlSession;

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String execute() throws Exception{
		System.out.println(username+password+getText("login"));
        Map m1 = new HashMap();
		m1.put("username", "chenzhehao");
		m1.put("password", "111111");
		List list = sqlSession.selectList("selectUser");
        for(int i=0;i<list.size();i++)
        	System.out.println(list.get(i));
		return SUCCESS;
	}
	
}
