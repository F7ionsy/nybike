package cn.tedu.nybike.pojo;

public class Item {
	private Integer value;
	private String name;
	public Item(Integer value, String name) {
		super();
		this.value = value;
		this.name = name;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Item [value=" + value + ", name=" + name + "]";
	}
	
	
}
