package cn.tedu.nybike.service;

import java.util.ArrayList;
import java.util.List;

import cn.tedu.nybike.dao.avgDAO;
import cn.tedu.nybike.pojo.avgDO;
import cn.tedu.nybike.pojo.avgVO;



public class avgService {
	
	private avgDAO	dao = new avgDAO();
	public avgVO avg() {
		List<avgDO> list = dao.avg();
		List<Integer> Data1 = new ArrayList<Integer>(30);
		List<Double> Data2 = new ArrayList<Double>(30);
		List<Double> Data3 = new ArrayList<Double>(30);
		List<Double> Data4 = new ArrayList<Double>(30);
		for(avgDO tc:list) {
			Data1.add(tc.getDay());
			Data2.add(tc.getAvg());
			Data3.add(tc.getMax());
			Data4.add(tc.getMin());
		}
		avgVO vo = new avgVO(Data1,Data2,Data3,Data4);
		return vo;
	}

}
