package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import entity.fruit;

@Controller
public class AjaxController {
	@RequestMapping("/dologin")
	@ResponseBody
	public String dologin(String username,String pws){
		String r="用户名或密码错误";
		if("hsx".equals(username)&&"123".equals(pws)){
			r="ok";
		}
		return r;
	}
	@RequestMapping("/getedit")
	@ResponseBody
	public String getData(){
		//对象
		fruit f=new fruit();
		//set值
		f.setName("fruit orange");
		f.setPrice(50);
		//new Gson
		Gson g=new Gson();
		//转关成gson
		String str=g.toJson(f);
		//return  gson返回对象
		System.out.println("转换成功后"+str);
		return str;
	}
	@RequestMapping("/getedit2")
	@ResponseBody
	public String getData2(){
		//对象
		fruit f=new fruit();
		//set值
		f.setName("fruit orange1");
		f.setPrice(20);
		fruit f1=new fruit();
		//set值
		f.setName("fruit orange2");
		f.setPrice(30);
		fruit f2=new fruit();
		//set值
		f.setName("fruit orange3");
		f.setPrice(50);
		System.out.println("进入方法");
		List<fruit> list=new ArrayList<fruit>();
		list.add(f);
		list.add(f1);
		list.add(f2);
		//new Gson
		Gson g=new Gson();
		//转关成gson
		String str=g.toJson(list);
		//return  gson返回对象
		
		return str;
	}
}
