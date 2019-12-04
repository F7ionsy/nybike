package cn.tedu.nybike.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.tedu.nybike.pojo.everyVO;
import cn.tedu.nybike.service.everyService;

/**
 * Servlet implementation class everyServlet
 */
public class everyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private everyService service = new everyService();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		everyVO vo = service.every();
		String jsonStr = JSON.toJSONString(vo);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(jsonStr);
	}

}
