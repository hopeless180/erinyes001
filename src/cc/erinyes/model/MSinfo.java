package cc.erinyes.model;

public class MSinfo {
	private int id;
	private int mid;
	private int quantity;
	private String repository;
	private String name;
	private String date;
	
	public int getid(){
		return id;
	}
	public void setid(int id){
		this.id = id;
	}
	public int getmid(){
		return mid;
	}
	public void setmio(int mid){
		this.mid = mid;
	}
	public int getquantity(){
		return quantity;
	}
	public void setquantity(int quantity){
		this.quantity = quantity;
	}
	public String getrepository(){
		return repository;
	}
	public void setrepository(String repository){
		this.repository = repository;
	}
	public String getdate(){
		return date;
	}
	public void setdate(String date){
		this.date = date;
	}
	public String getname(){
		return name;
	}
	public void setname(String name){
		this.name = name;
	}
}
