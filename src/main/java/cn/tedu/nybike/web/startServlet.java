package cn.tedu.nybike.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.tedu.nybike.pojo.TestVO;
import cn.tedu.nybike.service.startService;

/**
 * Servlet implementation class startServlet
 */
public class startServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private startService service = new startService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TestVO vo = service.findStart();
		String jsonStr = JSON.toJSONString(vo);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(jsonStr);
	}

}
