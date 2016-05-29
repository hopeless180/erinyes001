package cc.erinyes.model;

public class RDinfo {
	private int id;
	private String date;
	private String begin;
	private String end;
	private String ygname;
	private String item;
	private String location;
	
	public int getid(){
		return id;
	}
	public void setid(int id){
		this.id = id;
	}
	public String getdate(){
		return date;
	}
	public void setdate(String date){
		this.date = date;
	}
	public String getbegin(){
		return begin;
	}
	public void setbegin(String begin){
		this.begin = begin;
	}
	public String getend(){
		return end;
	}
	public void setend(String end){
		this.end = end;
	}
	public String getygname(){
		return ygname;
	}
	public void setygname(String ygname){
		this.ygname = ygname;
	}
	public String getitem(){
		return item;
	}
	public void setitem(String item){
		this.item = item;
	}
	public String getlocation(){
		return location;
	}
	public void setlocation(String location){
		this.location = location;
	}
}
