package cc.erinyes.model;

public class RXinfo {
	private int id;
	private String name;
	private String location;
	private String status;
	
	public int getid(){
		return id;
	}
	public void setid(int id){
		this.id = id;
	}
	public String getname(){
		return name;
	}
	public void setname(String name){
		this.name = name;
	}
	public String getlocation(){
		return location;
	}
	public void setlocation(String location){
		this.location = location;
	}
	public String getstatus(){
		return status;
	}
	public void setstatus(String status){
		this.status = status;
	}
}
