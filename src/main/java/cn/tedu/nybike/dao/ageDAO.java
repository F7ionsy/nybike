package cn.tedu.nybike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import cn.tedu.nybike.pojo.ageDO;

import cn.tedu.nybike.util.DButil2;
import cn.tedu.nybike.util.DButil3;


public class ageDAO {
	public static void main(String[] args) {
		ageDAO dao = new ageDAO();
		List<ageDO> list = dao.age();
		for(ageDO tc:list) {
			System.out.println(tc);
		}
	}
	public List<ageDO> age() {
		String sql = "select * from tb_age";
		//声明存放do对象得集合
		List<ageDO> list = new LinkedList<ageDO>();
		try(	Connection conn =DButil3.getConn();
				//Connection conn =DButil2.getHiveConn();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ageDO tc = new ageDO();
				tc.setCount(rs.getInt("a"));
				
				//将对象装入集合
				list.add(tc);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;

	}}
