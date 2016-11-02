package cn.ptp.spring;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestMessage
{
	private static BeanFactory factory;

	public static void main(String[] args)
	{
		factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		//getMsgId();
		getList();
    }	
	
	public static void getMsgId() 
	{
		Message message = factory.getBean("message", Message.class);
		message.getId();
		System.out.println(message.getId());
	}
	
	public static void getList()
	{
		MessageDo mdo = factory.getBean("messagedo", MessageDo.class);
		List<cn.ptp.hibernate.message.Message> list = mdo.msgList();
		for(cn.ptp.hibernate.message.Message m:list){
			System.out.println("name: "+ m.getName());  
			System.out.println("msg: "+ m.getMsg());  
			System.out.println("create at: "+ m.getCreate_at());
		}
	}
	
}
