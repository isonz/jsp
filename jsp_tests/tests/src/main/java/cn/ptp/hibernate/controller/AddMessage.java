package cn.ptp.hibernate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ptp.hibernate.message.Message;
import cn.ptp.hibernate.message.MessageJpaDao;
import ison.lib.Func;

public class AddMessage extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException
	{
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text ml;charset=UTF-8");
		
		String name = request.getParameter("name");
		String msg = request.getParameter("msg");

		MessageJpaDao mjDao = new MessageJpaDao();
		Message message = new Message();
		message.setName(name);
		message.setMsg(msg);
		message.setCreate_at(Func.getTimeStemp());
		mjDao.save(message);
		
		response.sendRedirect(request.getContextPath()+"/hibernate/");
	}
	
}
