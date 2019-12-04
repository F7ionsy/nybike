package cn.tedu.nybike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import cn.tedu.nybike.pojo.avgDO;
import cn.tedu.nybike.util.DButil2;

public class avgDAO {
	public static void main(String[] args) {
		avgDAO dao = new avgDAO();
		List<avgDO> list = dao.avg();
		for(avgDO tc:list) {
			System.out.println(tc);
		}
	}
	
	public List<avgDO> avg() {
		String sql = "select * from tb_avg1";
		//声明存放do对象得集合
		List<avgDO> list = new LinkedList<avgDO>();
		try(Connection conn =DButil2.getHiveConn();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				avgDO tc = new avgDO();
				tc.setDay(rs.getInt("day"));
				tc.setAvg((double)(Math.round(rs.getDouble("avg")*100)/100.0));
				tc.setMax((double)(Math.round(rs.getDouble("max")*100)/100.0));
				tc.setMin((double)(Math.round(rs.getDouble("min")*100)/100.0));
				//将对象装入集合
				list.add(tc);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}


}
