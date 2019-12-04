package cn.tedu.nybike.pojo;

import java.util.Arrays;

public class demo3VO {
	
	private String [] xData;
	private Integer[] yData;
	public String[] getxData() {
		return xData;
	}
	public void setxData(String[] xData) {
		this.xData = xData;
	}
	public Integer[] getyData() {
		return yData;
	}
	public void setyData(Integer[] yData) {
		this.yData = yData;
	}
	@Override
	public String toString() {
		return "demo3VO [xData=" + Arrays.toString(xData) + ", yData=" + Arrays.toString(yData) + "]";
	}
	public demo3VO(String[] xData, Integer[] yData) {
		super();
		this.xData = xData;
		this.yData = yData;
	}
	public demo3VO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
