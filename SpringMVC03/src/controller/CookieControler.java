package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieControler {
	//添加cookei
		@RequestMapping("/wCk")
		public String writeCookie(HttpServletResponse response){
			//ck1
			Cookie ck =new Cookie("ck1","my cookie oooo");
			response.addCookie(ck);
			return "redirect:/readCk";
		}
		//读取cookie
		@RequestMapping("/readCk")
		public String readCookie(@CookieValue(value="ck1",required=false) String ck1){
			System.out.println(ck1);
			return "readCk";
		}
}
