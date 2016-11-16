package com.tarena.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.tarena.entity.Buyer;
import com.tarena.entity.Seller;
import com.tarena.entity.Sellergoods;

/*BuyerDao具体方法实现类*/
@Repository("sellerDao")//方便特定的Bean id
public class OracleSellerDao implements SellerDao,Serializable{
	private JDBCDataSource dataSource;
	public OracleSellerDao(){
		
	}
	/*创建oraclebuyerdao对象必须依赖于JDBCDataSource实例*/
	public OracleSellerDao(JDBCDataSource dataSource){
		this.dataSource=dataSource;
	}
	@Autowired//按照类型自动装配
	public void setDataSource(@Qualifier("dataSource")
			JDBCDataSource dataSource) {
		this.dataSource = dataSource;
	}
	public JDBCDataSource getDataSource() {
		return dataSource;
	}
	/*根据用户名查找数据库用户表*/
	public Seller findByName(String name) {
		String sql="select id,name,pwd from seller_wangxin where name=?";
		Connection conn=null;
		try {
			conn=dataSource.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			Seller seller=null;
			while(rs.next()){
				seller=new Seller();
				seller.setId(rs.getInt("id"));
				seller.setName(rs.getString("name"));
				seller.setPwd(rs.getString("pwd"));
			}
			rs.close();
			ps.close();
			return seller;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			dataSource.close(conn);
		}
	}
	public List<Sellergoods> findGood() {
		String sql="select goodid,goodname,price,types,states from sellergoods_wangxin ";
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
	/*模糊查询*/
	public List<Sellergoods> findGoodByName(String keywords) {
		List<Sellergoods> list=new ArrayList<Sellergoods>();
		Sellergoods goods=new Sellergoods();
		Connection conn=null;
		ResultSet rs=null;
		try{
			conn=dataSource.getConnection();
			String sql="select * from sellergoods_wangxin where types like ? ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+keywords+"%");
			rs=ps.executeQuery();
			while(rs.next()){
				goods=new Sellergoods(rs.getInt("goodid"), 
						rs.getString("goodname"), rs.getInt("price"),
						rs.getString("types"), rs.getString("states"));
				list.add(goods);
			}
			rs.close();
			ps.close();
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dataSource.close(conn);
		}
		return list;
	}
	
	
	
}
