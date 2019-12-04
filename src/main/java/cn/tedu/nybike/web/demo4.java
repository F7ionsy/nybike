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
import cn.tedu.nybike.pojo.demo4VO;
import cn.tedu.nybike.util.DButil1;

public class demo4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql="select a,b,c "
				+"from j "
				+"where a<8";
		Integer[][]d = new Integer[7][24];
		try(	Connection conn=DButil1.getConn();
				PreparedStatement ps=conn.prepareStatement(sql)) {
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					Integer a = rs.getInt("a");
					Integer b = rs.getInt("b");
					Integer c = rs.getInt("c");
					d[a-1][b]=c;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		demo4VO vo = new demo4VO(d);
		String jsonStr = JSON.toJSONString(vo);
		System.out.println(jsonStr);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(jsonStr);
	}
	

}
