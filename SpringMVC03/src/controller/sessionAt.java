package controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import entity.fruit;

@Controller
@SessionAttributes(value={"list"})
public class sessionAt {
	@RequestMapping("/ses2")
	public ModelAndView getSes(){
		ModelAndView mav=new ModelAndView();
		fruit f=new fruit();
		f.setName("orange");
		f.setPrice(40);
		List<fruit> list=new ArrayList<fruit>();
		list.add(f);
		mav.addObject("list",list);
		mav.setViewName("../../session2");
		return mav;
		
	}
}
