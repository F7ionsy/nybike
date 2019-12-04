package cn.tedu.nybike.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.LinkedMap;

import cn.tedu.nybike.dao.cusDAO;
import cn.tedu.nybike.pojo.Item;
import cn.tedu.nybike.pojo.cusDO;
import cn.tedu.nybike.pojo.cusVO;


public class cusService {
	private cusDAO dao = new cusDAO();
	public cusVO cus(){
		List<cusDO> list = dao.cus();
		List<Item> xData = new ArrayList<Item>(800);
		for(cusDO tc:list) {
			Item item=new Item((tc.getValue()/10),tc.getName());
			xData.add(item);
		}
		
		Map<String, Double[]> yData = new LinkedMap(800);
		for(cusDO tc:list) {
			Double[] arr= new Double[2];
			arr[1] = tc.getLat();
			arr[0] = tc.getLon();
			yData.put(tc.getName(),arr);
		}
		
		cusVO vo = new cusVO(xData,yData);
		
		return vo;
	}

}
