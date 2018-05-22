package com.myself.mybatis.tx;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class TransactionTest2 {
	private SqlSessionTemplate sqlSession;

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	public TransactionTemplate transactionTemplate;

	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	@Transactional
	public void funTest() {
		Map map1 = new HashMap();
		map1.put("id", 112);
		map1.put("name", "name2");
		map1.put("password", "password2");
		sqlSession.insert("Information.insertUserTransaction", map1);

	}

	public void transactionTest() {
		@SuppressWarnings("unchecked")
		Object result = transactionTemplate.execute(new TransactionCallback() {
			public Object doInTransaction(TransactionStatus status) {
				Map map2 = new HashMap();
				map2.put("id", 114);
				map2.put("name", "name2");
				map2.put("password", "password2");
				sqlSession.insert("Information.insertUserTransaction", map2);
				return null;
			}
		});
	}
}
