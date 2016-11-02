//得到数据库的连接
package cn.ptp.natives.lib;

import java.sql.*;
public class ConnDB 
{
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	private Connection _getConn()
	{
		try {
	    	Class.forName("com.mysql.jdbc.Driver");		//1.加载驱动
	    	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8","root","admin888");  //2.得到链接
		} catch (Exception e) {
			e.printStackTrace();	//一定写上..
		}
		return conn;
	}
	
	public ResultSet getResult(String sql)
	{
		try {
			ps = this._getConn().prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet getResult(String sql, int id)
	{
		try {
			ps = this._getConn().prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public boolean insert(String sql, String name, String msg, int create_at)
	{
		boolean bl = false;
		try {
			ps = this._getConn().prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, msg);
			ps.setInt(3, create_at);
			if(1 == ps.executeUpdate()) bl = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return bl;
	}
	
	public boolean update(String sql, String name, String msg, int id)
	{
		boolean bl = false;
		try {
			ps = this._getConn().prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, msg);
			ps.setInt(3, id);
			if(1 == ps.executeUpdate()) bl = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return bl;
	}
	
	public boolean delete(String sql, int id)
	{
		boolean bl = false;
		try {
			ps = this._getConn().prepareStatement(sql);
			ps.setInt(1, id);
			if(1 == ps.executeUpdate()) bl = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return bl;
	}
	
	//关闭资源
	public void close()
	{
		try {
			if(rs!=null){ rs.close(); rs=null;}
			if(ps!=null){ ps.close(); ps=null;}
			if(conn!=null){ conn.close(); conn=null;}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
}
