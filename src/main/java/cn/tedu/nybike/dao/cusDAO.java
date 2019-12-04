package cn.tedu.nybike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import cn.tedu.nybike.pojo.cusDO;
import cn.tedu.nybike.pojo.startDO;
import cn.tedu.nybike.util.DButil2;



public class cusDAO {
	public static void main(String[] args) {
		cusDAO dao = new cusDAO();
		List<cusDO> list = dao.cus();
		for(cusDO tc:list) {
			System.out.println(tc);
		}
	}
	public List<cusDO> cus() {
		String sql = "select * from tb_cus";
		//声明存放do对象得集合
		List<cusDO> list = new LinkedList<cusDO>();
		try(	Connection conn =DButil2.getHiveConn();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cusDO tc = new cusDO();
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
