package cn.ptp.message;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ptp.model.Message;
import cn.ptp.model.MessageDao;
import cn.ptp.model.MessageJpaDao;


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
		MessageDao mdo = factory.getBean("messagejpadao", MessageJpaDao.class);
		List<Message> list = mdo.msgList();
		for(Message m:list){
			System.out.println("name: "+ m.getName());  
			System.out.println("msg: "+ m.getMsg());  
			System.out.println("create at: "+ m.getCreate_at());
		}
	}
	
}
