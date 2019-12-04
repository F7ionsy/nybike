package cn.tedu.nybike.pojo;

public class startDO {
	private String name;
	private double lat;
	private double lon;
	private int value;
	public startDO(String name, double lat, double lon, int value) {
		super();
		this.name = name;
		this.lat = lat;
		this.lon = lon;
		this.value = value;
	}
	public startDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "startDO [name=" + name + ", lat=" + lat + ", lon=" + lon + ", value=" + value + "]";
	}
	
}
