package com.myself.mybatis;
 
import java.util.HashMap;
import java.util.Map;

import com.myself.mybatis.interfaces.UserService;
 
/**
 * @author xudongwang 2011-12-31
 *
 *         Email:xdwangiflytek@gmail.com
 *
 */
public class TestIbatis {
	
    public static void main(String[] args) {
    	
        Map m1 = new HashMap();
        m1.put("id", 5);
		m1.put("username", "chenzhehao");
		m1.put("password", "111111");
        Map a = new HashMap();
        try {
            a = (Map)MysqlRoot.getSqlSessionXML().selectOne("Information.selectUser" ,"1");
            MysqlRoot.getSqlSessionXML().insert("Information.insertUser", m1);
//            a =  MysqlRoot.sqlSession.selectMap("Information.selectUser" ,"");
//            List list = MysqlRoot.sqlSession.selectList("Information.selectUser", "1");
//            for(int i=0;i<list.size();i++){
//            	System.out.println(list.get(i));
//            }
            System.out.println(a);
            MysqlRoot.getSqlSessionXML().commit();
            MysqlRoot.getSqlSessionXML().close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        MysqlRoot.getSqlSessionAnno().getMapper(UserService.class).add(4, "mybatis", "test");
        MysqlRoot.getSqlSessionAnno().commit();
        MysqlRoot.getSqlSessionAnno().close();
        
    }
}
