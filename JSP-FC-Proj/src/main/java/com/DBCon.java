package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DBCon {
	public DBCon() {
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	private static DBCon dbc;
	synchronized public static DBCon getDBCon() {
		
		if(dbc==null) {
			dbc=new DBCon();
		}
		return dbc;
		
	}
	synchronized Connection getConnection() {
		try {
			  Connection con=DriverManager.getConnection("jdbc:mysql://Localhost/julyfinal", "root", "root");
			  return con;
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
	}

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public boolean checkUser(String uname,String upass) {
		
		try {
//			Connection con= DriverManager.getConnection("jdbc:mysql://localhost/julyfinal","root","root");
			con=DBCon.getDBCon().getConnection();
			ps=con.prepareStatement("select flag from user where uname=? and upass=?");
			ps.setString(1, uname);
			ps.setString(2, upass);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
					return true;
		
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean checkFlag(String uname,String upass) {
		
		try {
			con=DBCon.getDBCon().getConnection();
			ps=con.prepareStatement("select flag from user where uname=? and upass=?");
			ps.setString(1, uname);
			ps.setString(2, upass);
			ResultSet rs=ps.executeQuery();
			int f=0;
			if(rs.next()) {
				 f=rs.getInt(1);
			}
			if (f==0) {
				con=DBCon.getDBCon().getConnection();
				ps=con.prepareStatement("update user set flag=1 where uname=? and upass=?");
				ps.setString(1, uname);
				ps.setString(2, upass);
				ps.executeUpdate();
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean reSetFlag(String uname,String upass) {
		try {
			con=DBCon.getDBCon().getConnection();
			ps=con.prepareStatement("update user set flag=0 where uname=? and upass=?");
			ps.setString(1, uname);
			ps.setString(2, upass);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public int register(int uid,String uname,String upass) {
		try {
				con=DBCon.getDBCon().getConnection();
				ps=con.prepareStatement("insert into user values (?,?,?,?)");
				ps.setInt(1, uid);
				ps.setString(2, uname);
				ps.setString(3, upass);
				ps.setInt(4, 0);
				int i=ps.executeUpdate();
				return i;
				
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}	
	}
	
	 public static void main(String[] args) {
			DBCon dbc=new DBCon();
			int add=dbc.register(2,"sadham","secret");
			System.out.println(add+" user added... ");
			System.out.println(dbc.checkUser("imran","secret"));
		}
	
}

	


