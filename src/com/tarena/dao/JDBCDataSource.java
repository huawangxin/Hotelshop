package com.tarena.dao;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/*组件注解*/
@Component
public class JDBCDataSource implements Serializable{
	private String driver;
	@Value("#{dataSource.url}")
	private String url;
	@Value("#{dataSource.user}")
	private String user;
	@Value("#{dataSource.pwd}")
	private String pwd;
	/*必须使用Bean属性输入，否则不能进行JDBC Driver注册*/
	@Value("#{dataSource.driver}")
	public void setDriver(String driver){
		try {//注册数据库驱动
			Class.forName(driver);
			this.driver=driver;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getDriver() {
		return driver;
	}
	public Connection getConnection() throws Exception{
		Connection conn=DriverManager.getConnection(url,user,pwd);
		return conn;
	}
	public void close(Connection conn) {
		if(conn!=null){
			try{
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
