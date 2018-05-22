package com.myself.mybatis.JTA;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JTATest3 extends JdbcDaoSupport{
	public void addBook(){
        try{
            JdbcTemplate jt=getJdbcTemplate();
            String str_sql="insert into users (id,username,password) values (111,'name','vae')";
            jt.update(str_sql);
        }catch(RuntimeException e){
            System.out.println("添加Book失败");
            e.printStackTrace();
            throw e;
        }
    }
}
