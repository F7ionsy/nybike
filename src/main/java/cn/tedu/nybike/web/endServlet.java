package cn.tedu.nybike.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.tedu.nybike.pojo.endVO;
import cn.tedu.nybike.service.endService;

/**
 * Servlet implementation class endServlet
 */
public class endServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private endService service = new endService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		endVO vo = service.findEnd();
		
		String jsonStr = JSON.toJSONString(vo);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(jsonStr);
	}

}
