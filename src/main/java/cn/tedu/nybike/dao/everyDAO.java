package cn.tedu.nybike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.tedu.nybike.pojo.everyDO;
import cn.tedu.nybike.pojo.startDO;
import cn.tedu.nybike.util.DButil2;



public class everyDAO {
	public static void main(String[] args) {
		everyDAO dao = new everyDAO();
		List<everyDO> list = dao.every();
		for(everyDO tc:list) {
			System.out.println(tc);
		}
}
	public List<everyDO> every() {
		String sql = "select * from tb_every";
		//声明存放do对象得集合
		List<everyDO> list = new ArrayList<everyDO>();
		try(	Connection conn =DButil2.getHiveConn();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				everyDO tc = new everyDO();
				tc.setDay(rs.getInt("day"));
				if(rs.getInt("type")==0) {
					tc.setType("无性别");
				}
				if(rs.getInt("type")==1) {
					tc.setType("男");
				}
				if(rs.getInt("type")==2) {
					tc.setType("女");
				}
				tc.setCount(rs.getInt("count")/1000);
				//将对象装入集合
				list.add(tc);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
