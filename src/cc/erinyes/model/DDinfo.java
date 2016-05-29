package cc.erinyes.model;

public class DDinfo {
	private int id;
	private int quantity;
	private double cost;
	private double total;
	private String name;
	private String creator;
	private String status;
	private String content;
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public int getquantity() {
		return quantity;
	}
	public void setquantity(int quantity) {
		this.quantity = quantity;
	}
	public double getcost() {
		return cost;
	}
	public void setcost(double cost) {
		this.cost = cost;
	}
	public double gettotal() {
		return total;
	}
	public void settotal(double total) {
		this.total = total;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getcreator() {
		return creator;
	}
	public void setcreator(String creator) {
		this.creator = creator;
	}
	public String getstatus() {
		return status;
	}
	public void setstatus(String status) {
		this.status = status;
	}
	public String getcontent() {
		return content;
	}
	public void setcontent(String content) {
		this.content = content;
	}
}
