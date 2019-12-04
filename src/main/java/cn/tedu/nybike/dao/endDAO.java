package cn.tedu.nybike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import cn.tedu.nybike.pojo.endDO;
import cn.tedu.nybike.util.DButil2;

public class endDAO {
	public static void main(String[] args) {
		endDAO dao = new endDAO();
		List<endDO> list = dao.listend();
		for(endDO tc:list) {
			System.out.println(tc);
		}
}
	public List<endDO> listend() {
		String sql = "select * from tb_end";
		//声明存放do对象得集合
		List<endDO> list = new LinkedList<endDO>();
		try(	Connection conn =DButil2.getHiveConn();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				endDO tc = new endDO();
				tc.setName(rs.getString("name"));
				tc.setLat(rs.getDouble("lat"));
				tc.setLon(rs.getDouble("lon"));
				tc.setValue(rs.getInt("count"));
				//将对象装入集合
				list.add(tc);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
