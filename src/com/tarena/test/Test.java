package com.tarena.test;

import java.sql.Connection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.dao.BuyerDao;
import com.tarena.dao.JDBCDataSource;
import com.tarena.entity.Buyer;
import com.tarena.service.BuyService;
import com.tarena.service.NameOrPwdException;
import com.tarena.service.NullParamException;

public class Test {
//	@org.junit.Test
	public void TestJDBCDatasource() throws Exception{
		String conf="applicationContext.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
		System.out.println(ac);
		JDBCDataSource js=ac.getBean("dataSource",JDBCDataSource.class);
		Connection conn=js.getConnection();
		System.out.println(conn);
	}
	/*构造器参数注入*/
//	@org.junit.Test
	public void testOracleBuyerDao(){
		String conf="applicationContext.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
		//获取实例
		BuyerDao buyerDao=ac.getBean("buyerDAO",BuyerDao.class);
		//查询用户对象
		Buyer buyer=buyerDao.findByName("张三");
		System.out.println(buyer);
	}
//	@org.junit.Test
	public void testBuyerService() throws Exception{
		String conf="applicationContext.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
		//获取BuyerService实例
		BuyService buyService=ac.getBean("buyService",BuyService.class);
		//调用登陆方法,测试自动注入结果
		Buyer buyer=buyService.login("张三", "123");
		System.out.println(buyer);
	}
}
