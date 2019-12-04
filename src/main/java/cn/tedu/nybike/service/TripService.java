package cn.tedu.nybike.service;

import java.util.ArrayList;
import java.util.List;

import cn.tedu.nybike.dao.tripDAO;
import cn.tedu.nybike.pojo.TripcountDO;
import cn.tedu.nybike.pojo.TripcountVO;

/**
 * 封装车次数据业务逻辑得类
 * @author F7ionsy
 *
 */
public class TripService {
		private tripDAO	dao = new tripDAO();
		public TripcountVO findTripCount() {
			List<TripcountDO> list = dao.listtripCount();
			List<Integer> xData = new ArrayList<Integer>(24);
			for(int i = 0;i<24;i++) {
				xData.add(i);
			}
			List<Integer> yData = new ArrayList<Integer>(24);
			for(TripcountDO tc:list) {
				yData.add(tc.getCount());
			}
			TripcountVO vo = new TripcountVO(xData,yData);
			return vo;
		}
}
