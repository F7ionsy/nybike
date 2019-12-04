package cn.tedu.nybike.pojo;

import java.util.List;

public  class TripcountVO {
	
			private List<Integer> xData;
			private List<Integer> yData;
			@Override
			public String toString() {
				return "TripcountVO [xData=" + xData + ", yData=" + yData + "]";
			}
			public List<Integer> getxData() {
				return xData;
			}
			public void setxData(List<Integer> xData) {
				this.xData = xData;
			}
			public List<Integer> getyData() {
				return yData;
			}
			public void setyData(List<Integer> yData) {
				this.yData = yData;
			}
			public TripcountVO(List<Integer> xData, List<Integer> yData) {
				super();
				this.xData = xData;
				this.yData = yData;
			}
			public TripcountVO() {
				super();
				// TODO Auto-generated constructor stub
			}

}
