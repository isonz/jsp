package cn.ptp.natives;

import java.util.ArrayList;

import ison.lib.Func;
import cn.ptp.natives.model.Message;
import cn.ptp.natives.model.MessageDo;
import junit.framework.Test;
import junit.framework.TestSuite;

public class TestMessage
{
	static private MessageDo msgd = null;
	
	public static void main(String[] args) throws Exception
	{
		msgd = new MessageDo();
		update();
		list();
    }
	
	static public void insert()
	{
		msgd.insert("啊大法师父", "啊发生大幅所发生的发生的发生");
	}
	
	static public void delet()
	{
		msgd.delete(18);
	}
	
	static public void select()
	{
		Message msg = msgd.getOne(19);
		
		System.out.println(msg.getId());
		System.out.println(msg.getName());
		System.out.println(msg.getMsg());
		System.out.println(Func.getTime(msg.getCreateAt(), "yyyy-MM-dd HH:mm:ss"));
	}
	
	static public void list()
	{
		ArrayList<Message> msglist = msgd.msgList();
		Message msg = new Message();
		for(int i=0; i<msglist.size(); i++){
			msg = msglist.get(i);
			System.out.println(msg.getId());
			System.out.println(msg.getName());
			System.out.println(msg.getMsg());
			System.out.println(Func.getTime(msg.getCreateAt(), "yyyy-MM-dd HH:mm:ss"));
		}
	}

	static public void update()
	{
		String[] args = {"我的", "网盘网盘"};
		msgd.update(14, args);
	}
	
	static public Test suite()
	{
		TestSuite suite = new TestSuite("Test for Message...");
		suite.addTestSuite(MessageDo.class);
		return suite;
	}
}
