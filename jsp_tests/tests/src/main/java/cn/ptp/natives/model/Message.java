package cn.ptp.natives.model;

public class Message
{
	private int id;
	private String name;
	private String msString;
	private int create_at;
	
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
	
	public int getCreateAt() {
		return create_at;
	}
	public void setCreateAt(int create_at) {
		this.create_at = create_at;
	}

}
