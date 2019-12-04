package cn.tedu.nybike.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.nybike.util.DButil1;

/**
 * Servlet implementation class testdemo
 */
public class testdemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 获取用户发来的站点id
				String sidStr=request.getParameter("sid");
				// 将字符串类型的sid转成对应的int类型
				int sid=Integer.parseInt(sidStr);
				//2. 基于sid查询站点name和nba tb_ss tb_is
				String sql="select t1.name,t2.nba "
						+"from tb_is t1, tb_ss t2 "
						+"where t1.sid=t2.sid "
						+"and t1.sid=?";
				// 声明用于保存查询结果的变量
				String name="未查到";
				int nba=999;
				
				try(Connection conn=DButil1.getConn();
						PreparedStatement ps=conn.prepareStatement(sql)){
					// 绑定参数
					ps.setInt(1, sid);
					// 执行请求
					ResultSet rs=ps.executeQuery();
					if(rs.next()) {
						name=rs.getString("name");
						nba=rs.getInt("nba");
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				//3. 将查询结果返回给用户
				response.setCharacterEncoding("UTF-8");
				response.setHeader("content-type","text/html;charset=UTF-8");
				response.getWriter().write(name+","+nba);
	}

	
}
