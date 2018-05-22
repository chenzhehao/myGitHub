package com.myself.mybatis.tx;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;

@Transactional
public class TransactionTest extends ActionSupport {

	private SqlSessionTemplate sqlSession;

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	private TransactionTest2 transactionTest2;

	public TransactionTest2 getTransactionTest2() {
		return transactionTest2;
	}

	public void setTransactionTest2(TransactionTest2 transactionTest2) {
		this.transactionTest2 = transactionTest2;
	}

	public String execute() throws Exception {
		Map map1 = new HashMap();
		map1.put("id", 111);
		map1.put("name", "name2");
		map1.put("password", "password2");
		sqlSession.insert("Information.insertUserTransaction", map1);
		
		transactionTest2.funTest();
		
		Map map2 = new HashMap();
		map2.put("id", 113);
		map2.put("name", "name2");
		map2.put("password", "password2");
		sqlSession.insert("Information.insertUserTransaction", map2);
		System.out.println(5 / 0);
		return SUCCESS;
	}
}
