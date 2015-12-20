package com.spring.myBeans.xml;

import java.util.List;

import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.myself.mybatis.SpringMybatisClass;
import com.myself.mybatis.Mappers.User;
import com.myself.mybatis.Mappers.UserRoleInfo;
import com.myself.mybatis.interfaces.UserService;
import com.spring.myBeans.annotation.SpringTest1;
import com.spring.myBeans.annotation.SpringTest2;

public class SpringTest3 extends SpringMybatisClass{

	private String properties3;

	public String getProperties3() {
		return properties3;
	}

	public void setProperties3(String properties3) {
		this.properties3 = properties3;
	}

	@Autowired
	private SpringTest1 springTest1;
	@Autowired
	private SpringTest2 springTest2;
	
	@Autowired
	@Qualifier("userMapper")
	private MapperFactoryBean userMapper;

	// sping容器启动后会调用bean的构造方法创建类的实例，但是属性值还没有注入进来
	public SpringTest3() {
		System.out.println("SpringTest3=" + properties3);
	}

	public void funTest() {
		// springTest1.funTest();
		springTest2.funTest();
		System.out.println("funTest3=" + properties3);
//		System.out.println(sqlSession.selectList("selectUser"));
		System.out.println(this.getSqlSession().selectList("selectUser"));
//		userMapper.getSqlSession().getMapper(UserService.class).add(4, "mybatis", "test");
		List<User> usersList = userMapper.getSqlSession().getMapper(UserService.class).getAllUsers();
		List<UserRoleInfo> userRoleInfo = (List<UserRoleInfo>) userMapper.getSqlSession().getMapper(UserService.class).getUserRoleInfo();
		System.out.println(usersList);
		System.out.println(userRoleInfo);
		//userMapper.getSqlSession().commit();
		//userMapper.getSqlSession().close();
	}

}
