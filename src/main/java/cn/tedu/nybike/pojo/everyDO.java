package cn.tedu.nybike.pojo;

public class everyDO {
	private int day;
	private String type;
	private int count;
	public everyDO(int day, String type, int count) {
		super();
		this.day = day;
		this.type = type;
		this.count = count;
	}
	public everyDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "everyDO [day=" + day + ", type=" + type + ", count=" + count + "]";
	}

	

}
