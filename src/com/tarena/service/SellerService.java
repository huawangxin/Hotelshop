package com.tarena.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tarena.dao.SellerDao;
import com.tarena.entity.Buyer;
import com.tarena.entity.Seller;
import com.tarena.entity.Sellergoods;

@Service//Ĭ�ϵ�Bean ID��sellerService
public class SellerService {
	private SellerDao sellerDao;
	@Resource(name="sellerDao")
	public void setSellerDao(SellerDao sellerDao) {
		this.sellerDao = sellerDao;
	}
	public SellerDao getSellerDao() {
		return sellerDao;
	}
	/*��¼�û���ϢУ��*/
	public Seller login(String name, String pwd) throws NameOrPwdException,NullParamException{
		if(name==null||name.equals("")||pwd==null||pwd.equals("")){
			throw new NullParamException("��½��������Ϊ��");
		}
		Seller seller=sellerDao.findByName(name);
		if(seller!=null&&pwd.equals(seller.getPwd())){
			return seller;
		}
		throw new NameOrPwdException("�û������������");
	}
	/*��ѯ������Ʒ*/
	public List<Sellergoods> findGood() {
		List<Sellergoods> list=new ArrayList<Sellergoods>();
		list=sellerDao.findGood();
		return list;
	}
	/*ģ����ѯ*/
	public List<Sellergoods> findGoodByName(String keywords) {
		List<Sellergoods> list=sellerDao.findGoodByName(keywords);
		return list;
	}
}
