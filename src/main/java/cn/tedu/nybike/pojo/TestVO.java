package cn.tedu.nybike.pojo;

import java.util.List;
import java.util.Map;

public class TestVO {
	
	List<Item> xData;
	Map<String, Double[]> yData;
	public TestVO(List<Item> xData, Map<String, Double[]> yData) {
		super();
		this.xData = xData;
		this.yData = yData;
	}
	public TestVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TestVO [xData=" + xData + ", yData=" + yData + "]";
	}
	public List<Item> getxData() {
		return xData;
	}
	public void setxData(List<Item> xData) {
		this.xData = xData;
	}
	public Map<String, Double[]> getyData() {
		return yData;
	}
	public void setyData(Map<String, Double[]> yData) {
		this.yData = yData;
	}
	

}
