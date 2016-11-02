package cn.ptp.hibernate;

import java.util.List;
import ison.lib.*;
import cn.ptp.hibernate.message.*;

public class TestMessage
{
	public static void main(String[] args) throws Exception
	{
		//list();
		add();
		//del();
		//update();
    }
	
	public static void list()
	{
		MessageJpaDao mjDao = new MessageJpaDao();
		List<Message> list = mjDao.msgList();
		for(Message m:list){
			System.out.println("name: "+ m.getName());  
			System.out.println("msg: "+ m.getMsg());  
			System.out.println("create at: "+ m.getCreate_at());
		}
	}
	
	public static void add() 
	{
		MessageJpaDao mjDao = new MessageJpaDao();
		Message message = new Message();
		message.setName("珅");
		message.setMsg("张");
		mjDao.save(message);
		
	}
	
	public static void del()
	{
		MessageJpaDao mjDao = new MessageJpaDao();
		mjDao.delete(24);
	}
	
	public static void update() 
	{
		MessageJpaDao mjDao = new MessageJpaDao();
		Message message = new Message();
		
		message.setId(28);
		message.setName("ISON");
		message.setMsg("ZHANGs");
		message.setCreate_at(Func.getTimeStemp());
		mjDao.save(message);
	}
	
}
