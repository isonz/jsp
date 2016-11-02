package cn.ptp.hibernate.message;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import cn.ptp.hibernate.message.Message;
import cn.ptp.hibernate.message.MessageDao;

public class MessageJpaDao implements MessageDao
{
	private EntityManagerFactory entityManagerFactory;
	
	public MessageJpaDao(){
		entityManagerFactory = Persistence.createEntityManagerFactory("dao");
	}
	
	public void delete(int id){
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		try{
			tx.begin();
			Message users = manager.find(Message.class, id);
			manager.remove(users);
			tx.commit();
		}catch(RuntimeException e){
			tx.rollback();
			throw e;
		}finally {
			manager.close();
		}
	}
	
	public Message select(int id) {
		EntityManager manager = entityManagerFactory.createEntityManager();  
        try {
            return manager.find(Message.class, id);  
        } finally {  
            manager.close();  
        }  
	}
	
	@SuppressWarnings("unchecked")
	public List<Message> msgList()
	{
		List<Message> list;
		EntityManager manager = entityManagerFactory.createEntityManager();  
        try {
        	Query qy = (Query) manager.createQuery("from Message ORDER BY id ASC");
        	list = qy.getResultList();
        }finally {  
            manager.close();  
        }  
		return list;
	}
	
	public void save(Message message) {  
        EntityManager manager = entityManagerFactory.createEntityManager();  
        EntityTransaction tx = manager.getTransaction();  
        try {  
            tx.begin();  
            manager.merge(message);  
            tx.commit();  
        } catch (RuntimeException e) {  
            tx.rollback();  
            throw e;  
        } finally {  
            manager.close();  
        }  
    }
	
}