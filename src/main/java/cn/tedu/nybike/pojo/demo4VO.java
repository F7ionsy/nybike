package cn.tedu.nybike.pojo;

import java.util.Arrays;

public class demo4VO {

	private Integer[][] yData;

	public Integer[][] getyData() {
		return yData;
	}

	public void setyData(Integer[][] yData) {
		this.yData = yData;
	}

	@Override
	public String toString() {
		return "demo4VO [yData=" + Arrays.toString(yData) + "]";
	}

	public demo4VO(Integer[][] yData) {
		super();
		this.yData = yData;
	}

	public demo4VO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
