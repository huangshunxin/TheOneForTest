package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import entity.fruit;

@Controller
public class ReSendController {
	@RequestMapping("/fruit")//设置访问路径
	public ModelAndView getFruit(){
		System.out.println("进入这个方法");
		ModelAndView mav=new ModelAndView();
		
		List<fruit> list=ReSendController.getDate();
		mav.addObject("list",list);
		mav.setViewName("../../fruit");//设置跳转页面
		
		return mav;
	}
	@RequestMapping("fruit2")//设置访问路径
	public ModelAndView getFruit2(){
		System.out.println("进入这个方法");
		List<fruit> list=ReSendController.getDate();
		return new ModelAndView("../../fruit2", "list", list);//设置跳转页面和存放值
	}
	@RequestMapping("fruit3")//此处必须是视图文件夹下对应的jsp文件名
	public Map getFruit3(){
		Map map=new HashMap();
		List<fruit> list=this.getDate();
		map.put("list", list);
		return map;
	}
	@RequestMapping("/req")
	public String userRequest(HttpServletRequest request){
		String num=request.getParameter("num");
		request.setAttribute("req", "absdfgda"+num);
		return "req";
		
	}
	@RequestMapping("/ses")
	public String userSession(HttpServletRequest request){
		HttpSession session=request.getSession();
		session.setAttribute("user", "这里存放session的信息");
		
		return "../../session";
	}
	@RequestMapping("/encode")
	public void userResponse(HttpServletResponse response){
		System.out.println("进入这个方法2");
		List<fruit> list=this.getDate();
		Gson g=new Gson();
		String str=g.toJson(list);
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().print(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static List<fruit> getDate(){
		List<fruit> list=new ArrayList<fruit>();
		fruit f=new fruit();
		f.setName("苹果");
		f.setPrice(30);
		fruit f1=new fruit();
		f1.setName("香蕉");
		f1.setPrice(40);
		fruit f2=new fruit();
		f2.setName("orange");
		f2.setPrice(10);
		list.add(f);
		list.add(f1);
		list.add(f2);
		return list;
	}
}
