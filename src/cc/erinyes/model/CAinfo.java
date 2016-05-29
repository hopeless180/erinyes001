package cc.erinyes.model;

public class CAinfo {
	private int id;
	private String item;
	private String name;
	private String analyst;
	private String date;
	private String conclusion;
	
	public int getid(){
		return id;
	}
	public void setid(int id){
		this.id = id;
	}
	public String getitem(){
		return item;
	}
	public void setitem(String item){
		this.item = item;
	}
	public String getname(){
		return name;
	}
	public void setname(String name){
		this.name = name;
	}
	public String getanalyst(){
		return analyst;
	}
	public void setanalyst(String analyst){
		this.analyst = analyst;
	}
	public String getdate(){
		return date;
	}
	public void setdate(String date){
		this.date = date;
	}
	public String getconclusion(){
		return conclusion;
	}
	public void setconclusion(String conclusion){
		this.conclusion = conclusion;
	}
}
