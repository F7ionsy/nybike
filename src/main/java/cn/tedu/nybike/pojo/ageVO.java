package cn.tedu.nybike.pojo;

import java.util.List;

public class ageVO {
	private List<Integer> Data1;

	public ageVO(List<Integer> data1) {
		super();
		Data1 = data1;
	}

	public ageVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Integer> getData1() {
		return Data1;
	}

	public void setData1(List<Integer> data1) {
		Data1 = data1;
	}

	@Override
	public String toString() {
		return "ageVO [Data1=" + Data1 + "]";
	}

}
