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
	/*����������ע��*/
//	@org.junit.Test
	public void testOracleBuyerDao(){
		String conf="applicationContext.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
		//��ȡʵ��
		BuyerDao buyerDao=ac.getBean("buyerDAO",BuyerDao.class);
		//��ѯ�û�����
		Buyer buyer=buyerDao.findByName("����");
		System.out.println(buyer);
	}
//	@org.junit.Test
	public void testBuyerService() throws Exception{
		String conf="applicationContext.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
		//��ȡBuyerServiceʵ��
		BuyService buyService=ac.getBean("buyService",BuyService.class);
		//���õ�½����,�����Զ�ע����
		Buyer buyer=buyService.login("����", "123");
		System.out.println(buyer);
	}
}
