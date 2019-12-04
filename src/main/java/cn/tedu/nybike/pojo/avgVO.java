package cn.tedu.nybike.pojo;

import java.util.List;

public class avgVO {
	private List<Integer> Data1;
	private List<Double> Data2;
	private List<Double> Data3;
	private List<Double> Data4;
	public avgVO(List<Integer> data1, List<Double> data2, List<Double> data3, List<Double> data4) {
		super();
		Data1 = data1;
		Data2 = data2;
		Data3 = data3;
		Data4 = data4;
	}
	public avgVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Integer> getData1() {
		return Data1;
	}
	public void setData1(List<Integer> data1) {
		Data1 = data1;
	}
	public List<Double> getData2() {
		return Data2;
	}
	public void setData2(List<Double> data2) {
		Data2 = data2;
	}
	public List<Double> getData3() {
		return Data3;
	}
	public void setData3(List<Double> data3) {
		Data3 = data3;
	}
	public List<Double> getData4() {
		return Data4;
	}
	public void setData4(List<Double> data4) {
		Data4 = data4;
	}
	@Override
	public String toString() {
		return "avgVO [Data1=" + Data1 + ", Data2=" + Data2 + ", Data3=" + Data3 + ", Data4=" + Data4 + "]";
	}
	
}