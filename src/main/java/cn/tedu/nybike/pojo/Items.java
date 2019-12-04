package cn.tedu.nybike.pojo;

public class Items {
	private Integer value;
	private String name;
	public Items(Integer value, String name) {
		super();
		this.value = value;
		this.name = name;
	}
	public Items() {
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
		return "Items [value=" + value + ", name=" + name + "]";
	}
	
}
