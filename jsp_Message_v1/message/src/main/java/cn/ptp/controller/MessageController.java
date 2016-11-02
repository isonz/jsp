package cn.ptp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.ptp.model.Message;
import cn.ptp.model.MessageDao;

@Controller
public class MessageController 
{
	@Resource private MessageDao mdo;
	
	private void _save(int id, String name, String msg)
	{
		Message message = new Message();
		if(id > 0) message.setId(id);
		message.setName(name);
		message.setMsg(msg);
		if(0==id) message.setCreate_at(0);
		mdo.save(message);
	}
	
	@RequestMapping("/")
	public String index(Model model)
	{
		List<Message> list = mdo.msgList();
		model.addAttribute("list", list);	//addAttribute不允许空值
		return "index";
	}
	
	@RequestMapping("/add")
	public String add(@RequestParam("name") String name, @RequestParam("msg") String msg)
	{
		_save(0, name, msg);
		return "redirect:/";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id)
	{
		mdo.delete(id);
		return "redirect:/";
	}
	
	@RequestMapping("/edit")
	public String edit(Model model, @RequestParam("id") int id)
	{
		Message message = mdo.select(id);
		model.addAttribute("message", message);
		return "edit";
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("msg") String msg)
	{
		_save(id, name, msg);
		return "redirect:/";
	}

	
}
