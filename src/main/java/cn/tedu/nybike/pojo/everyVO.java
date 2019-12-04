package cn.tedu.nybike.pojo;

import java.util.List;
import java.util.Map;

public class everyVO {
	List<List<Items>> Data;

	public everyVO(List<List<Items>> data) {
		super();
		Data = data;
	}

	public everyVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<List<Items>> getData() {
		return Data;
	}

	public void setData(List<List<Items>> data) {
		Data = data;
	}

	@Override
	public String toString() {
		return "everyVO [Data=" + Data + "]";
	}
	
	

}
