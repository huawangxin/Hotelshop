package com.tarena.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tarena.dao.BuyerDao;
import com.tarena.entity.BuyList;
import com.tarena.entity.Buyer;
import com.tarena.entity.Cart;
import com.tarena.entity.Sellergoods;
@Service//Ĭ�ϵ�Bean ID��buyService
public class BuyService {
	private BuyerDao buyerDao;
	@Resource(name="buyerDao")
	public void setBuyerDao(BuyerDao buyerDao) {
		this.buyerDao = buyerDao;
	}
	public BuyerDao getBuyerDao() {
		return buyerDao;
	}
	/*��¼ϵͳ*/
	public Buyer login(String name,String pwd) throws NameOrPwdException,NullParamException{
		if(name==null||name.equals("")||pwd==null||pwd.equals("")){
			throw new NullParamException("��½��������Ϊ��");
		}
		Buyer buyer=buyerDao.findByName(name);
		if(buyer!=null&&pwd.equals(buyer.getPwd())){
			return buyer;
		}
		throw new NameOrPwdException("�û������������");
	}
	/*ע���û�*/
	public Buyer register(String name, String pwd)throws NameOrPwdException,NullParamException{
		if(name==null||name.equals("")||pwd==null||pwd.equals("")){
			throw new NullParamException("ע���������Ϊ��");
		}
		buyerDao.addBuyer(name,pwd);
		Buyer buyer=buyerDao.findByName(name);
		if(buyer!=null&&pwd.equals(buyer.getPwd())){
			return buyer;
		}
		throw new NameOrPwdException("ע���û�δ֪����");
	}
	/*��ȡ��Ʒ��*/
	public List<Sellergoods> findGood() {
		List<Sellergoods> list=new ArrayList<Sellergoods>();
		list=buyerDao.findGood();
		return list;
	}
	/*��ȡĳ�û����ﳵ��Ϣ*/
	public List<Cart> findCarts(String name) {
		List<Cart> cartlist=new ArrayList<Cart>();
		cartlist=buyerDao.findCarts(name);
		return cartlist;
	}
	/*���빺�ﳵ*/
	public void addCart(String name, String goodname, int numbers, int price) {
		buyerDao.addCart(name,goodname,numbers,price);
	}
	/*ɾ��ָ�����ﳵ��Ʒ*/
	public void delCart(int cartid) {
		buyerDao.delCart(cartid);
	}
	/*������Ʒname��ȡ��Ʒ��Ϣ*/
	public Sellergoods findGoodById(String goodname) {
		Sellergoods sellergoods=buyerDao.findGoodById(goodname);
		return sellergoods;
	}
	/*���ɶ�����ɾ�����ﳵ����*/
	public void addList(BuyList buyList) {
		buyerDao.addList(buyList);
	}
	/*�޸Ķ���״̬Ϊ��ԤԼ*/
	public void updateList(String name, String goodname,String date1) {
		buyerDao.update(name,goodname,date1);
	}
	/*��ѯ�û�����*/
	public List<BuyList> findList(String name) {
		List<BuyList> list=buyerDao.findList(name);
		return list;
	}
	/*ɾ��������*/
	public void delList(int listid) {
	buyerDao.delList(listid);
		
	}
	/*����ID���Ҷ���*/
	public BuyList findListById(int listid) {
		BuyList buyList=buyerDao.findListById(listid);
		return buyList;
	}
	/*����ID�޸Ķ���״̬*/
	public void updateList(int listid) {
		buyerDao.update(listid);
	}
	/*�����û�����ȡ�û�����Ϣ*/
	public Buyer findBuyer(String name) {
		Buyer buyer=buyerDao.findBuyer(name);
		return buyer;
	}
	/*�޸��û�����*/
	public void updateBuyer(int id, String name, String pwd) {
		buyerDao.updateBuyer(id,name,pwd);
	}
	
}
