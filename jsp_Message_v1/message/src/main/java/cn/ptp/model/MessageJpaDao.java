package cn.ptp.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MessageJpaDao implements MessageDao
{
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	    
	public void delete(int id)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Message message = select(id);	//需要多一次查询，防止并发删除时已经删除了报错
		try {
			message.setId(id);
			tx = session.beginTransaction();
			session.delete(message);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace(System.out);
		}finally{
			session.close();
		}
	}
	
	public Message select(int id) {
		Session session = sessionFactory.openSession();
		Message message = session.get(Message.class, id);
		return message;
	}
	
	@SuppressWarnings("unchecked")
	public List<Message> msgList()
	{
		List<Message> list=null;
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Message ORDER BY id ASC");
		list = query.list(); 
		return list;
	}
	
	public void save(Message message) 
	{  
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(message);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace(System.out);
		}finally{
			session.close();
		}
    }
	
}