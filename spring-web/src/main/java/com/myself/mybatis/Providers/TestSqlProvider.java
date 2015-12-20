package com.myself.mybatis.Providers;

import java.util.Map;
import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;  
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;  
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;  
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;  
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;  
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;  
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;  
import static org.apache.ibatis.jdbc.SqlBuilder.SET;  
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;  
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;  

public class TestSqlProvider {
	public String getSql(Map<String, Object> parameters) {
		String uid = (String) parameters.get("id");
		BEGIN();
		SELECT("test_id, test_text");
		if (uid != null) {
			WHERE("test_id = #{id,javaType=string,jdbcType=VARCHAR}");
		}
		return SQL();
	}
}
