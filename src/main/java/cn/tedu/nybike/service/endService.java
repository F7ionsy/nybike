package cn.tedu.nybike.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.tedu.nybike.dao.endDAO;
import cn.tedu.nybike.pojo.Item;
import cn.tedu.nybike.pojo.endDO;
import cn.tedu.nybike.pojo.endVO;

public class endService {
	private endDAO dao = new endDAO();
	public endVO findEnd(){
		List<endDO> list = dao.listend();
		List<Item> xData = new ArrayList<Item>(806);
		for(endDO tc:list) {
			Item item=new Item((tc.getValue()/30),tc.getName());
			xData.add(item);
		}
		
		Map<String, Double[]> yData = new  HashMap<String, Double[]>(806);
		for(endDO tc:list) {
			Double[] arr= new Double[2];
			arr[1] = tc.getLat();
			arr[0] = tc.getLon();
			yData.put(tc.getName(),arr);
		}
		
		endVO vo = new endVO(xData,yData);
		return vo;
	}
}
