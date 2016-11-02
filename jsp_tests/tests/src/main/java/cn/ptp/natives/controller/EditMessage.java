package cn.ptp.natives.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ptp.natives.model.MessageDo;

public class EditMessage extends HttpServlet
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
		
		int id = Integer.parseInt(request.getParameter("mid"));
		String name = request.getParameter("name");
		String msg = request.getParameter("msg");
		
		MessageDo msgd = new MessageDo();
		String[] args = {name, msg};
		msgd.update(id, args);
		response.sendRedirect(request.getContextPath()+"/natives/");
	}
	
}
