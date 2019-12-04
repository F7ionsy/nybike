package cn.tedu.nybike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import cn.tedu.nybike.pojo.TripcountDO;
import cn.tedu.nybike.util.DButil2;
//��װ�Գ������ݵ���ɾ�Ĳ������DAO��
public class tripDAO {
	public static void main(String[] args) {
		tripDAO dao = new tripDAO();
		List<TripcountDO> list = dao.listtripCount();
		for(TripcountDO tc:list) {
			System.out.println(tc);
		}
	}
	
	public List<TripcountDO> listtripCount() {
		String sql = "select * from tb_day_hour_count";
		//�������do����ü���
		List<TripcountDO> list = new LinkedList<TripcountDO>();
		try(Connection conn =DButil2.getHiveConn();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				TripcountDO tc = new TripcountDO();
				tc.setDay(rs.getInt("c_day"));
				tc.setHour(rs.getInt("c_hour"));
				tc.setCount(rs.getInt("c_count"));
				//������װ�뼯��
				list.add(tc);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
