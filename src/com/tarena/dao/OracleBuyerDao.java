package com.tarena.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import oracle.net.aso.r;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import sun.security.timestamp.TSRequest;

import com.tarena.entity.BuyList;
import com.tarena.entity.Buyer;
import com.tarena.entity.Cart;
import com.tarena.entity.Sellergoods;
/*BuyerDao���巽��ʵ����*/
@Repository("buyerDao")//�����ض���Bean id ����setBuyerDaoע��
public class OracleBuyerDao implements BuyerDao,Serializable{
	private JDBCDataSource dataSource;
	public OracleBuyerDao(){
		
	}
	/*����oraclebuyerdao�������������JDBCDataSourceʵ��*/
	public OracleBuyerDao(JDBCDataSource dataSource){
		this.dataSource=dataSource;
	}
	@Autowired//���������Զ�װ��
	public void setDataSource(@Qualifier("dataSource")
			JDBCDataSource dataSource) {
		this.dataSource = dataSource;
	}
	public JDBCDataSource getDataSource() {
		return dataSource;
	}
	/*�����û��������û���*/
	public Buyer findByName(String name) {
		System.out.println("����JDBC��������Buyer��Ϣ");
		String sql="select id,name,pwd from buyer_wangxin where name=?";
		Connection conn=null;
		try {
			conn=dataSource.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			Buyer buyer=null;
			while(rs.next()){
				buyer=new Buyer();
				buyer.setId(rs.getInt("id"));
				buyer.setName(rs.getString("name"));
				buyer.setPwd(rs.getString("pwd"));
			}
			rs.close();
			ps.close();
			return buyer;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			dataSource.close(conn);
		}
		
	}
	/*������û�*/
	public void addBuyer(String name, String pwd) {
		System.out.println("������û�");
		String sql="insert into buyer_wangxin (id,name,pwd) values(SEQ_buyer_wangxin.nextval,?,?)";
		Connection conn=null;
		try {
			conn=dataSource.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			dataSource.close(conn);
		}
		
	}
	/*����������Ʒ��*/
	public List<Sellergoods> findGood() {
		System.out.println("����������Ʒ��");
		String sql="select goodid,goodname,price,types,states from sellergoods_wangxin where states='��Ԥ��' ";
		Connection conn=null;
		try {
			List<Sellergoods> list=new ArrayList<Sellergoods>();
			conn=dataSource.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			Sellergoods sellergoods=null;
			while(rs.next()){
				sellergoods=new Sellergoods(rs.getInt("goodid"), 
						rs.getString("goodname"), rs.getInt("price"),
						rs.getString("types"), rs.getString("states"));
				list.add(sellergoods);
			}
			rs.close();
			ps.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			dataSource.close(conn);
		}
		
	}
	/*��ѯĳ�û����ﳵ��Ϣ*/
	public List<Cart> findCarts(String name) {
		System.out.println("�������й��ﳵ��Ϣ"+name);
		String sql="select cartid,name,goodname,numbers,price from cart_wangxin where name=? ";
		Connection conn=null;
		try {
			List<Cart> list=new ArrayList<Cart>();
			conn=dataSource.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			Cart cart=null;
			while(rs.next()){
				cart=new Cart(rs.getInt("cartid"), rs.getString("name"), 
	rs.getString("goodname"), rs.getInt("numbers"), rs.getInt("price"));
				list.add(cart);
			}
			rs.close();
			ps.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			dataSource.close(conn);
		}
		
	}
	/*���빺�ﳵ*/
	public void addCart(String name, String goodname, int numbers, int price) {
		System.out.println("���빺�ﳵ");
		String sql="insert into cart_wangxin (cartid, name,goodname, numbers,price) " +
				"values(SEQ_cart_wangxin.nextval,?,?,?,?)";
		Connection conn=null;
		try {
			conn=dataSource.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, goodname);
			ps.setInt(3, numbers);
			ps.setInt(4, price);
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			dataSource.close(conn);
		}
	}
	/*ɾ��ָ��ID���ﳵ����*/
	public void delCart(int cartid) {
		String sql="delete from cart_wangxin where cartid=?";
		Connection conn=null;
		try {
			conn=dataSource.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, cartid);
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			dataSource.close(conn);
		}
	}
	/*����goodname��ȡָ����Ʒ��Ϣ*/
	public Sellergoods findGoodById(String goodname) {
		String sql="select goodid,goodname,price,types,states from sellergoods_wangxin where goodname=? ";
		Connection conn=null;
		try {
			Sellergoods sellergoods=new Sellergoods();
			conn=dataSource.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, goodname);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				sellergoods=new Sellergoods(rs.getInt("goodid"), 
						rs.getString("goodname"), rs.getInt("price"),
						rs.getString("types"), rs.getString("states"));
			}
			rs.close();
			ps.close();
			return sellergoods;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			dataSource.close(conn);
		}
	}
	/*�����¶���*/
	public void addList(BuyList buyList) {
		String sql="insert into list_wangxin " +
				"(listid, goodname,numbers, prices,name,phone,date1,date2,states) " +
				"values (SEQ_list_wangxin.nextval,?,?,?,?,?,?,?,?)";
		Connection conn=null;
		try {
			conn=dataSource.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, buyList.getGoodname());
			ps.setInt(2, buyList.getNumbers());
			ps.setInt(3, buyList.getPrices());
			ps.setString(4, buyList.getName());
			ps.setString(5, buyList.getPhone());
			ps.setString(6, buyList.getDate1());
			ps.setString(7, buyList.getDate2());
			ps.setString(8, buyList.getStates());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			dataSource.close(conn);
		}
	}
	/*�޸Ķ���״̬Ϊ��ԤԼ*/
	public void update(String name, String goodname,String date1) {
		String sql="update list_wangxin set states='��ԤԼ' where name=? and goodname=? and date1=? ";
		Connection conn=null;
		try {
			conn=dataSource.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, goodname);
			ps.setString(3, date1);
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			dataSource.close(conn);
		}
	}
	/*��ѯ�û�����*/
	public List<BuyList> findList(String name) {
		String sql="select listid,goodname,numbers,prices,name,phone,date1,date2,states from list_wangxin where name=? ";
		Connection conn=null;
		try {
			List<BuyList> list=new ArrayList<BuyList>();
			conn=dataSource.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			BuyList buyList=null;
			while(rs.next()){
				buyList=new BuyList(rs.getInt("listid"), rs.getString("goodname"),
		rs.getInt("numbers"), rs.getInt("prices"), rs.getString("name"), 
		rs.getString("phone"), rs.getString("date1"), rs.getString("date2"), 
		rs.getString("states"));
				list.add(buyList);
			}
			rs.close();
			ps.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			dataSource.close(conn);
		}
		
	}
	/*ɾ��������*/
	public void delList(int listid) {
		String sql="delete from list_wangxin where listid=?";
		Connection conn=null;
		try {
			conn=dataSource.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, listid);
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			dataSource.close(conn);
		}
	}
	/*����Id���Ҷ���*/
	public BuyList findListById(int listid) {
		String sql="select * from list_wangxin where listid=? ";
		Connection conn=null;
		try {
			BuyList buyList=new BuyList();
			conn=dataSource.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, listid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				buyList=new BuyList(rs.getInt("listid"), rs.getString("goodname"), 
	rs.getInt("numbers"), rs.getInt("prices"), rs.getString("name"), rs.getString("phone"), 
	rs.getString("date1"), rs.getString("date2"), rs.getString("states"));
			}
			rs.close();
			ps.close();
			return buyList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			dataSource.close(conn);
		}
	}
	/*����ID�޸Ķ���״̬*/
	public void update(int listid) {
		String sql="update list_wangxin set states='��ԤԼ' where listid=? ";
		Connection conn=null;
		try {
			conn=dataSource.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, listid);
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			dataSource.close(conn);
		}
	}
	/*�����û�����ȡ�û�����Ϣ*/
	public Buyer findBuyer(String name) {
		String sql="select * from buyer_wangxin where name=? ";
		Connection conn=null;Buyer buyer=new Buyer();
		try {
			conn=dataSource.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				buyer=new Buyer(rs.getInt("id"),rs.getString("name"),rs.getString("pwd"));
			}
			rs.close();
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			dataSource.close(conn);
		}
		return buyer;
	}
	/*�޸��û�����*/
	public void updateBuyer(int id, String name, String pwd) {
		String sql="update buyer_wangxin set pwd=? where id=? and name=?";
		Connection conn=null;
		try {
			conn=dataSource.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, pwd);
			ps.setInt(2, id);
			ps.setString(3, name);
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			dataSource.close(conn);
		}
	}
}
