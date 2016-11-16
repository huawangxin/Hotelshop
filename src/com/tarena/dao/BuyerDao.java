package com.tarena.dao;

import java.util.List;

import com.tarena.entity.BuyList;
import com.tarena.entity.Buyer;
import com.tarena.entity.Cart;
import com.tarena.entity.Sellergoods;

//�û����ʶ���ӿ�
public interface BuyerDao {
	//�����û����������ݿ��û���
	public Buyer findByName(String name);
	/*ע�����û�*/
	public void addBuyer(String name,String pwd);
	/*����������Ʒ��*/
	public List<Sellergoods> findGood();
	/*��ѯĳ�û����ﳵ��*/
	public List<Cart> findCarts(String name);
	/*���빺�ﳵ��*/
	public void addCart(String name, String goodname, int numbers, int price);
	/*ɾ��ָ��ID���ﳵ����*/
	public void delCart(int cartid);
	/*������Ʒname��ȡָ����Ʒ��Ϣ*/
	public Sellergoods findGoodById(String goodname);
	/*����µĶ���*/
	public void addList(BuyList buyList);
	/*�޸Ķ���״̬Ϊ��ԤԼ*/
	public void update(String name, String goodname,String date1);
	/*��ѯ�û�����*/
	public List<BuyList> findList(String name);
	/*ɾ��������*/
	public void delList(int listid);
	/*����ID���Ҷ���*/
	public BuyList findListById(int listid);
	/*�ܾ�ID�޸Ķ���״̬*/
	public void update(int listid);
	/*�����û�����ȡ�û�����Ϣ*/
	public Buyer findBuyer(String name);
	/*�޸��û�����*/
	public void updateBuyer(int id, String name, String pwd);
	
}
