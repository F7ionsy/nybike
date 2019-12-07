package cn.tedu.nybike.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.tedu.nybike.dao.startDAO;
import cn.tedu.nybike.pojo.Item;
import cn.tedu.nybike.pojo.TestVO;
import cn.tedu.nybike.pojo.startDO;

public class startService {
	private startDAO dao = new startDAO();
	public TestVO findStart(){
		List<startDO> list = dao.liststart();
		List<Item> xData = new ArrayList<Item>(793);
		for(startDO tc:list) {
			Item item=new Item((tc.getValue()/30),tc.getName());
			xData.add(item);
		}
		
		Map<String, Double[]> yData = new  HashMap<String, Double[]>(793);
		for(startDO tc:list) {
			Double[] arr= new Double[2];
			arr[1] = tc.getLat();
			arr[0] = tc.getLon();
			yData.put(tc.getName(),arr);
		}
		
		TestVO vo = new TestVO(xData,yData);
		
		return vo;
	}

}
