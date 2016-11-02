package cn.ptp.model;

import java.util.List;

public interface MessageDao
{
	public void save(Message message);
	public void delete(int id);
	public Message select(int id);
	public List<Message> msgList();
}