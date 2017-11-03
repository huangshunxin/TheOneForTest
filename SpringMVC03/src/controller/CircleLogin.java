package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import entity.userInf;

@Controller
@SessionAttributes(value={"ui"})
public class CircleLogin {
	@RequestMapping("/dolog")
	public ModelAndView dolog(HttpServletResponse response,userInf ui){
		ModelAndView mav =new ModelAndView();
		//这里默认用户同意将用户名和密码保存在本地
		Cookie u=new Cookie("uName",ui.getUsername());
		response.addCookie(u);
		Cookie p = new Cookie("pwd",ui.getPws());
		response.addCookie(p);
		//用户名admin，密码：888888
		if("admin".equals(ui.getUsername()) && "888888".equals(ui.getPws())){
			mav.addObject("ui", ui);
			mav.setViewName("../../index");
		}else{
			mav.addObject("msg", "用户名或者密码错误");
			mav.setViewName("../../log");
		}
		return mav;
	}
}
