package cn.ptp.hibernate.message;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jsp_message")

public class Message
{
	private int id;
	private String name;
	private String msString;
	private int create_at;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name.length() > 20) name = name.substring(0,20);
		this.name = name;
	}
	
	public String getMsg() {
		return msString;
	}
	public void setMsg(String msString) {
		this.msString = msString;
	}
	
	@Column(updatable=false)
	public int getCreate_at() {
		return create_at;
	}
	public void setCreate_at(int create_at) {
		this.create_at = create_at;
	}

}
