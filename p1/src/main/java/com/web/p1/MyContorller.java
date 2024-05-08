package com.web.p1;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller 
// 1.public class... 윗줄에 @controller가 잇어야 소스가 컨트롤러 역할을함
// 2. 컨트롤러 소스 안에는 메소드들이 많음, 메소드 순서는 상관 x
// 3. 이번학기에 쓰는 컨트롤러의 메소드에는 @GetMapping("/주소") 혹은 @PostMapping("/주소")가 붙는다.
// 4. 자바에서 @로 시작하는 것을 어노테이샨이라고 부름, 우리는 현재까지 3가지 어노테이션을 사용 (위에있는것들)
// 5. GetMapping PostMapping에 들어가는 주소는 http://localhost:8080는 생략하고 슬래쉬/부터 시작함 /하나만 있으면 http://localhost:8080 의미
// 6. 앞에서 보낸 데이터를 받으려면 메소드 괄호안에 String mid 이런식으로만 적어도 name 속성이 mid인 데이터를 잘 받음, 다만 앞에서 보낸 데이터임을 못박기 위
//    해서 @RequestParam(name="mid")를 적음
// 7. 자바에서 html에게 변수를 넘겨줄려면 Model(가방)에 담아서 줘야함
public class MyContorller{

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/ex01")
	public String ex01() {
		return "ex01"; 
	}
	
	@PostMapping("/ex01/answer")
	public String ex01Answer(@RequestParam(name="mid") String mid, @RequestParam(name="pass") String pass, Model mo) {
		mo.addAttribute("mid", mid);
		mo.addAttribute("pass", pass);
		return "ex01Answer";
	} 
	
	@GetMapping("/ex02")
	public String ex02() {
	 return "ex02";
	}
	
	@PostMapping("/ex02/answer")
	public String ex02Answer(@RequestParam("mname") String mname, 
	@RequestParam("po") String po, Model mo) {
	 mo.addAttribute("mname", mname);
	 mo.addAttribute("po", po);
	 int salary = 0;
	 switch(po){
	 case "사원" -> salary = 3500; /* Java switch문 */
	 case "대리" -> salary = 5000; 
	 case "팀장" -> salary = 7000; 
	 case "임원" -> salary = 9900; 
	}
	 mo.addAttribute("salary", salary);
	 return "ex02Answer";
	}
	
	@GetMapping("/ex03")
	public String ex03() {
	 return "ex03";
	}
	
	@PostMapping("/ex03/answer")
	public String ex03Answer(@RequestParam("mname") String mname, 
	@RequestParam("color") String color, Model mo) {
	 mo.addAttribute("mname", mname);
	 mo.addAttribute("color", color);
	 return "ex03Answer";
	}
	
	@GetMapping("/wise")
	public String wise() {
	 return "wise";
	}
	
	@PostMapping("/wise/answer")
	public String wiseanswer(@RequestParam("fname") String fname, 
	@RequestParam("mal") String mal, Model mo) {
	 mo.addAttribute("fname", fname);
	 mo.addAttribute("mal", mal);
	 return "wiseanswer";
	}
	
	@GetMapping("/bread")
	public String bread() {
	 return "bread";
	}
	
	@PostMapping("/bread/answer")
	public String breadanswer(@RequestParam("bread") String bread, 
	@RequestParam("price") Integer price, @RequestParam("num") String num, Model mo) {
	 mo.addAttribute("bread", bread);
	 mo.addAttribute("price", price);
	 mo.addAttribute("num", num);
	 return "breadanswer";
	}
	
	@GetMapping("/q06")
	public String q06() {
	 return "q06";
	}
	
	@GetMapping("/q06/a")
	public String q06a() {
	 return "q06a";
	}
	@PostMapping("/q06/aa")
	public String q06aa(@RequestParam("first") String first, 
	@RequestParam("second") String second,  Model mo) {
	 mo.addAttribute("first", first);
	 mo.addAttribute("second", second);
	 return "q06aa";
	}
	
	@GetMapping("/q06/b")
	public String q06b() {
	 return "q06b";
	}
	@PostMapping("/q06/bb")
	public String q06bb(@RequestParam("jobs") String jobs, 
	 Model mo) {
	 mo.addAttribute("jobs", jobs);
	 return "q06bb";
	}
	
	/* 자동import 하면 import java.util.ArrayList; 가 생깁니다. */
	@GetMapping("/ex04")
	public String ex04(Model mo) {
	 var arr = new ArrayList<String>();
	 arr.add("고흐"); 
	 arr.add("james");
	 arr.add("dooli");
	 arr.add("bread"); 
	 /* 지금은 회원정보 하드코딩. 나중에는 database에서 가져옴 */
	 mo.addAttribute("arr",arr);
	 return "ex04";
	}
	
	@GetMapping("/ex05")
	public String ex05(Model mo) {
	 var arr1 = new ArrayList<Integer>();
	 arr1.add(10); 
	 arr1.add(20);
	 arr1.add(30);
	 arr1.add(40);
	 arr1.add(50);
	 var arr2 = new ArrayList<String>();
	 arr2.add("종강"); 
	 arr2.add("하고");
	 arr2.add("싶다");
	 arr2.add("시험");
	 arr2.add("치기");
	 arr2.add("싫다");
	 arr2.add("제발");
	 /* 지금은 회원정보 하드코딩. 나중에는 database에서 가져옴 */
	 mo.addAttribute("arr1",arr1);
	 mo.addAttribute("arr2",arr2);
	 return "ex05";
	}
	
	@GetMapping("/popuptest")
	public String popuptest() {
	 return "popuptest";
	}
	
	@GetMapping("/practice")
	public String practice() {
		return "practice"; 
	}
	@GetMapping("/pex1")
	public String pex1() {
		return "pex1"; 
	}
	@PostMapping("/pex1/answer")
	public String pex1answer(@RequestParam(name="mid") String mid, @RequestParam(name="pwd") String pwd,Model mo) {
		mo.addAttribute("mid", mid);
		mo.addAttribute("pwd", pwd);
		return "pex1answer";
	}
	@GetMapping("/pex2")
	public String pex2() {
		return "pex2";
	}
	@PostMapping("/pex2/answer")
	public String pex2answer(@RequestParam(name="name") String name, @RequestParam(name="grade") String grade, Model mo) {
		mo.addAttribute("name", name);
		mo.addAttribute("grade", grade);
		int salary = 0;
		switch(grade) {
		case "팀장" -> salary = 3500;
		case "부장" -> salary = 5000;
		case "인턴" -> salary = 2500;
		}
		mo.addAttribute("salary", salary);
		return "pex2answer";
	}
	@GetMapping("/pex3")
	public String pex3() {
		return "pex3";
	}
	@PostMapping("/pex3/answer")
	public String pex3answer(@RequestParam(name="color") String color, @RequestParam(name="name") String name, Model mo) {
		mo.addAttribute("name", name);
		mo.addAttribute("color", color);
		return "pex3answer";
	}
	@GetMapping("/pex4")
	public String pex4(Model mo) {
		var arr = new ArrayList<String>();
		arr.add("고흐");
		arr.add("시우");
		arr.add("은주");
		mo.addAttribute("arr", arr);
		return "pex4";
	}
	@GetMapping("/pwise")
	public String pwise(){
	return "pwise";
	}
	@PostMapping("/pwise/answer")
	public String pwiseanswer(@RequestParam("ppl") String ppl , @RequestParam("famous") String famous, Model mo){
	mo.addAttribute("ppl", ppl);
	mo.addAttribute("famous", famous);
	return "pwiseanswer";
	}
	@GetMapping("/pbread")
	public String pbread() {
		return "pbread";
	}
	@PostMapping("/pbread/answer")
	public String pbreadanswer(@RequestParam("bread") String bread, @RequestParam("price") Integer price, @RequestParam("num") Integer num, Model mo) {
		mo.addAttribute("bread", bread);
		mo.addAttribute("price", num*price);
		mo.addAttribute("num", num);
		return "pbreadanswer";
	}
	@GetMapping("/pq06")
	public String pq06() {
		return "pq06";
	}
	@GetMapping("/pq06/a")
	public String pq06a() {
		return "pq06a";
	}
	@PostMapping("/pq06/aa")
	public String pq06aa(@RequestParam("first") String first, @RequestParam("second") String second, Model mo) {
		mo.addAttribute("first", first);
		mo.addAttribute("second", second);
		return "pq06aa";
	}
	@GetMapping("/pq06/b")
	public String pq06b() {
		return "pq06b";
	}
	@PostMapping("/pq06/bb")
	public String pq06bb(@RequestParam("job") String job, Model mo) {
		mo.addAttribute("job", job);
		return "pq06bb";
	}

}//class