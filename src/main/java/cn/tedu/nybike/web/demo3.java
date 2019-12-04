package cn.tedu.nybike.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.tedu.nybike.pojo.demo3VO;
import cn.tedu.nybike.util.DButil1;

/**
 * Servlet implementation class demo3
 */
public class demo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接受浏览器请求
		//向数据库查询数据
		//将数据转换成json格式
		//返回
		String sql="select t1.name,t2.nba "
				+"from tb_is t1, tb_ss t2 "
				+"where t1.sid=t2.sid "
				+"ORDER BY t2.nba";
		
		String [] names = new String[912];
		Integer [] nbas = new Integer[912];
		int i =0;
		try(	Connection conn=DButil1.getConn();
				PreparedStatement ps=conn.prepareStatement(sql)) {
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					String name = rs.getString("name");
					names[i] = name;
					Integer nba = rs.getInt("nba");
					nbas[i] = nba;
					i++;
					
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		demo3VO vo = new demo3VO(names, nbas);
		String jsonStr = JSON.toJSONString(vo);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(jsonStr);
	}


}
