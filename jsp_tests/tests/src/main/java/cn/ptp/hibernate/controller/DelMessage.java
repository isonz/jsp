package cn.ptp.hibernate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ptp.hibernate.message.MessageJpaDao;

public class DelMessage extends HttpServlet
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
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		MessageJpaDao mjDao = new MessageJpaDao();
		mjDao.delete(id);
		
		response.sendRedirect(request.getContextPath()+"/hibernate/");
	}
	
}
