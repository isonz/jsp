package cn.ptp.natives.model;

import java.sql.*;
import java.util.ArrayList;

import cn.ptp.natives.lib.ConnDB;
import ison.lib.Func;

public class MessageDo
{
	private ResultSet rs=null;
	
	private int  pageSize = 6;
	private int  rowCount = 0;	//该值从数据库查询
	private int  pageCount = 0;	//该值是通过pageSize和rowCount
	
	public Message getOne(int id)
	{
		ConnDB db = new ConnDB();
		Message msg = new Message();
		
		try {
			rs = db.getResult("SELECT * FROM jsp_message WHERE id=?", id);
			if(rs.next()){
				msg.setId(rs.getInt(1));
				msg.setName(rs.getString(2));
				msg.setMsg(rs.getString(3));
				msg.setCreateAt(rs.getInt(4));
  			}			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.close();
		}
		return msg;
	}
	
	public ArrayList<Message> msgList()
	{
		ArrayList<Message> al=new ArrayList<Message>();
		ConnDB db = new ConnDB();
		rs = db.getResult("select * from jsp_message");
		try {
			while(rs.next()){
				Message msg = new Message();
				msg.setId(rs.getInt(1));
				msg.setName(rs.getString(2));
				msg.setMsg(rs.getString(3));
				msg.setCreateAt(rs.getInt(4));
				
				al.add(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.close();
		}
		return al;
	}

	//返回，分页的总页数
	public int getPageCount()
	{
		ConnDB db = new ConnDB();
		try {
			rs = db.getResult("select * from jsp_message");
			//请注意，一定要rs.next(),不然你就惨了
   			if(rs.next()){
   				rowCount=rs.getInt(1);
   			}
   			//计算pageCount,这里算法很多，可以自己设计
   			if(rowCount%pageSize==0){
   				pageCount=rowCount/pageSize;
   			}else{
   				pageCount=rowCount/pageSize+1;
   			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.close();
		}
		return pageCount;
	}

	public boolean insert(String name, String message)
	{
		ConnDB db = new ConnDB();
		Message msg = new Message();
		int create_at = Func.getTimeStemp();
		msg.setName(name);
		msg.setMsg(message);
		
		boolean bl = false;
		try {
			bl = db.insert("insert into jsp_message (name, msg, create_at) values(?, ?, ?)", msg.getName(), msg.getMsg(), create_at);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.close();
		}
		return bl;
	}
	
	public boolean delete(int id)
	{
		Message msg = new Message();
		msg.setId(id);
		id = msg.getId();
		boolean bl = false;
		
		ConnDB db = new ConnDB();
		try {
			bl = db.delete("DELETE FROM jsp_message WHERE id=?", id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.close();
		}
		return bl;		
	}
	
	public boolean update(int id, String[] args)
	{
		Message msg = new Message();
		msg.setId(id);
		msg.setName(args[0]);
		msg.setMsg(args[1]);
		
		id = msg.getId();
		String name = msg.getName();
		String mess = msg.getMsg();
		
		boolean bl = false;
		
		ConnDB db = new ConnDB();
		try {
			bl = db.update("UPDATE jsp_message SET name=?, msg=? WHERE id=?", name, mess, id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.close();
		}
		return bl;
	}
	
}
