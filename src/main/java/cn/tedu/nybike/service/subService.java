package cn.tedu.nybike.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.tedu.nybike.dao.subDAO;
import cn.tedu.nybike.pojo.Item;
import cn.tedu.nybike.pojo.subDO;
import cn.tedu.nybike.pojo.subVO;


public class subService {
	private subDAO dao = new subDAO();
	public subVO sub(){
		List<subDO> list = dao.sub();
		List<Item> xData = new ArrayList<Item>(799);
		for(subDO tc:list) {
			Item item=new Item((tc.getValue()/25),tc.getName());
			xData.add(item);
		}
		
		Map<String, Double[]> yData = new  HashMap<String, Double[]>(799);
		for(subDO tc:list) {
			Double[] arr= new Double[2];
			arr[1] = tc.getLat();
			arr[0] = tc.getLon();
			yData.put(tc.getName(),arr);
		}
		
		subVO vo = new subVO(xData,yData);
		
		return vo;
	}
}
