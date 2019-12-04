package cn.tedu.nybike.pojo;

public class avgDO {
	private int day;
	private double avg;
	private double max;
	private double min;
	public avgDO(int day, double avg, double max, double min) {
		super();
		this.day = day;
		this.avg = avg;
		this.max = max;
		this.min = min;
	}
	public avgDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	@Override
	public String toString() {
		return "avgDO [day=" + day + ", avg=" + avg + ", max=" + max + ", min=" + min + "]";
	}
	
}
