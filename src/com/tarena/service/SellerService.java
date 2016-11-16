package com.tarena.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tarena.dao.SellerDao;
import com.tarena.entity.Buyer;
import com.tarena.entity.Seller;
import com.tarena.entity.Sellergoods;

@Service//默认的Bean ID是sellerService
public class SellerService {
	private SellerDao sellerDao;
	@Resource(name="sellerDao")
	public void setSellerDao(SellerDao sellerDao) {
		this.sellerDao = sellerDao;
	}
	public SellerDao getSellerDao() {
		return sellerDao;
	}
	/*登录用户信息校验*/
	public Seller login(String name, String pwd) throws NameOrPwdException,NullParamException{
		if(name==null||name.equals("")||pwd==null||pwd.equals("")){
			throw new NullParamException("登陆参数不能为空");
		}
		Seller seller=sellerDao.findByName(name);
		if(seller!=null&&pwd.equals(seller.getPwd())){
			return seller;
		}
		throw new NameOrPwdException("用户名或密码错误");
	}
	/*查询所有商品*/
	public List<Sellergoods> findGood() {
		List<Sellergoods> list=new ArrayList<Sellergoods>();
		list=sellerDao.findGood();
		return list;
	}
	/*模糊查询*/
	public List<Sellergoods> findGoodByName(String keywords) {
		List<Sellergoods> list=sellerDao.findGoodByName(keywords);
		return list;
	}
}
