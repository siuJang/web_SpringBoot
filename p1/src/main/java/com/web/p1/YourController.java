package com.web.p1;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
public class YourController {
	@GetMapping("/login")
	public String login() {
	 return "login";
	}
	@GetMapping("/login/check")
	public String logincheck(HttpSession se, @RequestParam("mid") String mid, RedirectAttributes re) {
	var arr = new ArrayList<String>();
	 arr.add("고흐");
	 arr.add("james");
	 arr.add("dooli");
	 arr.add("iu");
	 if( arr.contains(mid) ) 
	 { 
	se.setAttribute("mid", mid);
	return "redirect:/menu"; 
	 }
	 else 
	 {
	re.addAttribute("msg", mid
	 + "는 미등록 아이디입니다. 확인 후 로그인 부탁드립니다.");
	return "redirect:/popup"; 
	}
	}
	@GetMapping("/popup")
	public String popup(@RequestParam("msg") String msg, Model mo) {
	 /* msg는 사용자 입력 데이터 아니고 redirect parameter */
	 mo.addAttribute("msg", msg); 
	 return "popup";
	}
	@GetMapping("/menu")
	public String menu(HttpSession se, Model mo) {
	 mo.addAttribute("mid", se.getAttribute("mid"));
	 return "menu";
	}
	@GetMapping("/coffee")
	public String coffee(HttpSession se, Model mo) {
	 mo.addAttribute("mid", se.getAttribute("mid"));
	 return "coffee";
	}
	@GetMapping("/logout")
	public String logout(HttpSession se, Model mo) {
	 mo.addAttribute("mid", se.getAttribute("mid"));
	 se.invalidate(); 
	 return "logout";
	}
	@GetMapping("/plogin")
	public String plogin() {
		return "plogin";
	}
	@GetMapping("/plogin/check")
	public String plogincheck(HttpSession se, @RequestParam("mid") String mid, RedirectAttributes re) {
		var arr = new ArrayList<String>();
		arr.add("고흐");
		arr.add("dooli");
		if(arr.contains(mid)) {
			se.setAttribute("mid", mid);
			return "redirect:/pmenu";
		}
		else {
			re.addAttribute("msg", mid + "미등록 아이디 입니다.");
			return "redirect:/ppopup";
		}
	}
	@GetMapping("/ppopup")
	public String ppopup(@RequestParam("msg") String msg, Model mo) {
		mo.addAttribute("msg", msg);
		return "ppopup";
	}
	@GetMapping("/pmenu")
	public String pmenu(HttpSession se, Model mo) {
		mo.addAttribute("mid",se.getAttribute("mid"));
		return "pmenu";
	}
	@GetMapping("/pcoffee")
	public String pcoffee(HttpSession se, Model mo) {
		mo.addAttribute("mid", se.getAttribute("mid"));
		return "pcoffee";
	}
	@GetMapping("/plogout")
	public String plogout(HttpSession se, Model mo) {
		mo.addAttribute("mid", se.getAttribute("mid"));
		se.invalidate();
		return "plogout";
	}
}//class
