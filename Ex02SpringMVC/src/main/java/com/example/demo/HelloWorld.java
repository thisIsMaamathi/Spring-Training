package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller

@RequestMapping("/hello")
public class HelloWorld {
	
	@RequestMapping(method=RequestMethod.GET)
	public void sayHello() {
		System.out.println("Success....!!");
		
	}
	
	@RequestMapping(value="hello2",method=RequestMethod.GET)
	public String sayHello2() {
		System.out.println("Success......second method!!");
		return "sample";
		
	}
	
	@RequestMapping(value="hello3" ,method=RequestMethod.GET)
	public ResponseEntity<String> sayHello3() {
		return ResponseEntity.ok("Using Response entity");
		
	}
	
	@RequestMapping(value="hello4",method=RequestMethod.GET)
	public ModelAndView sayHello4() {
		ModelAndView m=new ModelAndView();
		m.addObject("mykey", "Using Model and view tag.....");
		m.setViewName("ModelandView");
		return m;
		
	}
	
	@RequestMapping(value="hello5",method=RequestMethod.GET)
	public ModelAndView sayHello4(ModelAndView m) {
		m.addObject("mykey", "Using Model and view tag.as parameter....");
		m.setViewName("ModelandView");
		return m;
		
	}
	
	@RequestMapping(value="hello6",method=RequestMethod.GET)
	public ModelAndView sayHello6(ModelAndView m,HttpServletRequest req) {
		m.addObject("mykey", "Using Model and view tag.as parameter.6th...");
		m.setViewName("ModelandView");
		HttpSession s=req.getSession();
		req.setAttribute("hello","hello world 6");
		s.setAttribute("hellosess","hello world  session");
		
		return m;
	}	
		
	
	@RequestMapping(value="hello7/{name}",method=RequestMethod.GET)
	public ModelAndView sayHello6(@PathVariable String name,ModelAndView m,HttpServletRequest req) {
		m.addObject("mykey", name);
		m.setViewName("ModelandView");
		HttpSession s=req.getSession();
		req.setAttribute("hello","hello world 6");
		s.setAttribute("hellosess","hello world  session");
		
		return m;
		
	
		
	}
	
	
	@RequestMapping(value="hello8",method=RequestMethod.GET)
	public ModelAndView sayHello8(@RequestParam("uname") String name,ModelAndView m,HttpServletRequest req) {
		m.addObject("mykey", name);
		m.setViewName("ModelandView");
		HttpSession s=req.getSession();
		req.setAttribute("hello","hello world 6");
		s.setAttribute("hellosess","hello world  session");
		
		return m;
	}
		
		

	@RequestMapping(value="matrix",method=RequestMethod.GET)
	public ModelAndView sayHello9(@MatrixVariable(name="uname",defaultValue="Maamathi") String name,ModelAndView m,HttpServletRequest req) {
		m.addObject("mykey", name);
		m.setViewName("ModelandView");
		
		req.setAttribute("hello","hello world 6");

		
		return m;
	}
		
		@RequestMapping(value="hello10",method=RequestMethod.GET)
		public ResponseEntity<User> sayHello10(){
			User user=new User();
			user.setId(100);
			user.setName("Maamathi");
			return ResponseEntity.ok(user);
			
			
		}
		
		@RequestMapping(value="hello11",method=RequestMethod.POST)
		public ResponseEntity<User> sayHello11(@RequestBody User user){
//			User user=new User();
			user.setId(100+user.getId());
			user.setName("Maamathi"+user.getName());
			return ResponseEntity.ok(user);
			
			
		}
		
		@RequestMapping(value="hello12",method=RequestMethod.POST)
		public User sayHello12(@RequestBody User user){
//			User user=new User();
			user.setId(10000);
			user.setName("Maamathi Krishnan");
			return user;
		
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


