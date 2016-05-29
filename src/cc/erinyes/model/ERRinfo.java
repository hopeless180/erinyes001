package cc.erinyes.model;

public class ERRinfo {
	private int id;
	private String finder;
	private String name;
	private String date;
	private String info;
	private String status;
	
	public int getid(){
		return id;
	}
	public void setid(int id){
		this.id = id;
	}
	public String getfinder(){
		return finder;
	}
	public void setfinder(String finder){
		this.finder = finder;
	}
	public String getname(){
		return name;
	}
	public void setname(String name){
		this.name = name;
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
	public String getstatus(){
		return status;
	}
	public void setstatus(String status){
		this.status = status;
	}
}
