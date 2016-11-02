package cn.ptp.hibernate.message;

import java.util.List;
import cn.ptp.hibernate.message.Message;;

public interface MessageDao
{
	public void save(Message message);
	public void delete(int id);
	public Message select(int id);
	public List<Message> msgList();
}