package cn.tedu.nybike.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.tedu.nybike.pojo.avgVO;
import cn.tedu.nybike.service.avgService;

/**
 * Servlet implementation class avgServlet
 */
public class avgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private avgService service = new avgService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		avgVO vo= service.avg();
		
		String jsonStr = JSON.toJSONString(vo);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(jsonStr);
	}

}
