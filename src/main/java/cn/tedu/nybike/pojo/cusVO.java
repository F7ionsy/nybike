package cn.tedu.nybike.pojo;

import java.util.List;
import java.util.Map;

public class cusVO {
	List<Item> xData;
	Map<String, Double[]> yData;
	@Override
	public String toString() {
		return "cusVO [xData=" + xData + ", yData=" + yData + "]";
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
	public cusVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public cusVO(List<Item> xData, Map<String, Double[]> yData) {
		super();
		this.xData = xData;
		this.yData = yData;
	}
}
