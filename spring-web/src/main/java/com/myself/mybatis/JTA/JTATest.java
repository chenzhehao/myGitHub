package com.myself.mybatis.JTA;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;
public class JTATest extends ActionSupport {

	private SqlSessionTemplate sqlSession;

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	private SqlSessionTemplate sqlSession2;
	
	public SqlSessionTemplate getSqlSession2() {
		return sqlSession2;
	}

	public void setSqlSession2(SqlSessionTemplate sqlSession2) {
		this.sqlSession2 = sqlSession2;
	}

	private JdbcTemplate sqlTemplate1;
	public JdbcTemplate getSqlTemplate1() {
		return sqlTemplate1;
	}

	public void setSqlTemplate1(JdbcTemplate sqlTemplate1) {
		this.sqlTemplate1 = sqlTemplate1;
	}

	private JdbcTemplate sqlTemplate2;

	public JdbcTemplate getSqlTemplate2() {
		return sqlTemplate2;
	}

	public void setSqlTemplate2(JdbcTemplate sqlTemplate2) {
		this.sqlTemplate2 = sqlTemplate2;
	}

	public String execute() throws Exception {
		fun1();
		System.out.println(5 / 0);
		
		return SUCCESS;
	}
	
	public void fun1(){
		Map map1 = new HashMap();
		map1.put("id", 111);
		map1.put("name", "name2");
		map1.put("password", "password2");
//		sqlTemplate1.execute("insert into users (id,username,password) values (112,'name','vae')");
		sqlSession.insert("Information.insertUserTransaction", map1);
		
		Map map2 = new HashMap();
		map2.put("id", 113);
		map2.put("name", "name2");
		map2.put("password", "password2");
//		sqlTemplate2.execute("insert into users (id,username,password) values (114,'name','vae')");
		sqlSession.insert("Information.insertUserTransaction", map2);
		System.out.println(5 / 0);
	}
	
	private JTATest2 jTest2;
	public void fun2(){
		jTest2.funTest();
	}

	public JTATest2 getjTest2() {
		return jTest2;
	}

	public void setjTest2(JTATest2 jTest2) {
		this.jTest2 = jTest2;
	}

}
