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
		//�������do����ü���
		List<everyDO> list = new ArrayList<everyDO>();
		try(	Connection conn =DButil2.getHiveConn();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				everyDO tc = new everyDO();
				tc.setDay(rs.getInt("day"));
				if(rs.getInt("type")==0) {
					tc.setType("���Ա�");
				}
				if(rs.getInt("type")==1) {
					tc.setType("��");
				}
				if(rs.getInt("type")==2) {
					tc.setType("Ů");
				}
				tc.setCount(rs.getInt("count")/1000);
				//������װ�뼯��
				list.add(tc);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
