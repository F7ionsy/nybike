package cn.tedu.nybike.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.LinkedMap;

import cn.tedu.nybike.dao.everyDAO;
import cn.tedu.nybike.pojo.Items;
import cn.tedu.nybike.pojo.everyDO;
import cn.tedu.nybike.pojo.everyVO;


public class everyService {
	 private everyDAO dao = new everyDAO();
	 public everyVO every(){
			List<everyDO> list = dao.every();
			List<Items> Datas = new ArrayList<Items>(3);
			List<List<Items>> arr = new ArrayList<List<Items>>(30);
			for(int i=0;i<list.size();i++) {
				Items items = new Items(list.get(i).getCount(),list.get(i).getType());
				Datas.add(items);
				if((i+1)%3==0) {
					arr.add(Datas);
					Datas = new ArrayList<Items>(3);
				}
			}	
			everyVO vo = new everyVO(arr);
			return vo;
			
	 }
}
