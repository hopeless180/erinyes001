package cc.erinyes.model;

public class EHinfo {
	private int id;
	private int errid;
	private String handler;
	private String date;
	private String info;
	
	public int getid(){
		return id;
	}
	public void setid(int id){
		this.id = id;
	}
	public int geterrid(){
		return errid;
	}
	public void seterrid(int errid){
		this.errid = errid;
	}
	public String getdate(){
		return date;
	}
	public void setdate(String date){
		this.date = date;
	}
	public String getinfo(){
		return info;
	}
	public void setinfo(String info){
		this.info = info;
	}
	public String gethandler(){
		return handler;
	}
	public void sethandler(String handler){
		this.handler = handler;
	}
}
