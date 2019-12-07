package cn.tedu.nybike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import cn.tedu.nybike.pojo.TripcountDO;
import cn.tedu.nybike.pojo.startDO;
import cn.tedu.nybike.util.DButil2;
import cn.tedu.nybike.util.DButil3;

public class startDAO {
	public static void main(String[] args) {
		startDAO dao = new startDAO();
		List<startDO> list = dao.liststart();
		for(startDO tc:list) {
			System.out.println(tc);
		}
}
	public List<startDO> liststart() {
		String sql = "select * from tb_start order by name,lat,lon";
		//声明存放do对象得集合
		List<startDO> list = new LinkedList<startDO>();
		try(	Connection conn =DButil3.getConn();
				//Connection conn =DButil2.getHiveConn();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				startDO tc = new startDO();
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
