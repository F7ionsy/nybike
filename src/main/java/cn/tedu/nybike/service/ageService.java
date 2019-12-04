package cn.tedu.nybike.service;

import java.util.ArrayList;
import java.util.List;
import cn.tedu.nybike.dao.ageDAO;
import cn.tedu.nybike.pojo.ageDO;
import cn.tedu.nybike.pojo.ageVO;
public class ageService {
	private ageDAO	dao = new ageDAO();
	public ageVO age() {
		List<ageDO> list = dao.age();
		List<Integer> Data1 = new ArrayList<Integer>(5);
		for(ageDO tc:list) {
			Data1.add(tc.getCount());
		}
		ageVO vo = new ageVO(Data1);
		return vo;
	}
}
