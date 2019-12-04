package cn.tedu.nybike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import cn.tedu.nybike.pojo.subDO;
import cn.tedu.nybike.util.DButil2;

public class subDAO {
	
	public static void main(String[] args) {
		subDAO dao = new subDAO();
		List<subDO> list = dao.sub();
		for(subDO tc:list) {
			System.out.println(tc);
		}
}
	public List<subDO> sub() {
		String sql = "select * from tb_sub";
		//声明存放do对象得集合
		List<subDO> list = new LinkedList<subDO>();
		try(	Connection conn =DButil2.getHiveConn();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				subDO tc = new subDO();
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
