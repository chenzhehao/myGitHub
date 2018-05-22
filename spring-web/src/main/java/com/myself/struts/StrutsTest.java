package com.myself.struts;

import java.sql.Savepoint;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.myself.mybatis.tx.TransactionTest2;
import com.mysql.jdbc.MysqlSavepoint;
import com.opensymphony.xwork2.ActionSupport;

public class StrutsTest extends ActionSupport {

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

	public TransactionTemplate transactionTemplate;

	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	private TransactionTest2 transactionTest2;

	public TransactionTest2 getTransactionTest2() {
		return transactionTest2;
	}

	public void setTransactionTest2(TransactionTest2 transactionTest2) {
		this.transactionTest2 = transactionTest2;
	}

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		// 事物处理－－编程式事物，另外可以使用xml配置声明式事物
		// 这是一个回调函数，实现了 TransactionCallback 接口的 doInTransaction
		// 方法，就是在这个方法里写数据库新增数据的操作
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus paramTransactionStatus) {
				System.out.println("无返回结果的事物");
			}
		});
		// 有返回的事物
		Object result = transactionTemplate.execute(new TransactionCallback() {
			public Object doInTransaction(TransactionStatus status) {
//				try {
					Map map = new HashMap();
					map.put("id", 111);
					map.put("name", "name1");
					map.put("password", "password1");
					sqlSession.insert("Information.insertUserTransaction", map);

					transactionTest2.transactionTest();
					
					// 设置事物保存点
//					Savepoint point1 = sqlSession.getConnection().setSavepoint();

					Object result = transactionTemplate.execute(new TransactionCallback() {
						public Object doInTransaction(TransactionStatus status) {
							try {
								Map map2 = new HashMap();
								map2.put("id", 112);
								map2.put("name", "name2");
								map2.put("password", "password2");
								sqlSession.insert("Information.insertUserTransaction", map2);
								return null;
							} catch (Exception e) {
								// TODO: handle exception
							}
							return null;
						}
					});

//					try {
						// 处理异常
						Map map3 = new HashMap();
						map3.put("id", 113);
						map3.put("name", "name1");
						map3.put("password", "password1");
						sqlSession.insert("Information.insertUserTransaction", map3);
//					} catch (Exception e) {
//						// 捕获异常，回滚到自定义的事物保存点
//						status.rollbackToSavepoint(point1);
//					}
					
					int i = 5/0;
					return null;
//				} catch (Exception e) {
//					status.setRollbackOnly();
//				}
//				return null;

			}
		});

		System.out.println(username + password + getText("login"));
		Map m1 = new HashMap();
		m1.put("username", "chenzhehao");
		m1.put("password", "111111");
		List list = sqlSession.selectList("selectUser");
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));

		if (SecurityUtils.getSubject().isAuthenticated()) {
			System.out.println("已经登录");
		} else {
			System.out.println("还未登录");
		}

		return SUCCESS;
	}

}
