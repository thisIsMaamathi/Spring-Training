package com.example.demo2;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/hello")
public class HelloWorld {
	
	@Autowired
	StudentService service;
	

	@RequestMapping(method = RequestMethod.GET)
	public void sayHello() {
		System.out.println("Success....!!");

	}

	@RequestMapping(value = "hello2", method = RequestMethod.GET)
	public String sayHello2() {
		System.out.println("Success......second method!!");
		return "sample";

	}

	@RequestMapping(value = "hello3", method = RequestMethod.GET)
	public ResponseEntity<String> sayHello3() {
		return ResponseEntity.ok("Using Response entity");

	}

	@RequestMapping(value = "hello4", method = RequestMethod.GET)
	public ModelAndView sayHello4() {
		ModelAndView model = new ModelAndView();
		model.addObject("mykey", "Using Model and view tag.....");
		model.setViewName("ModelandView");
		return model;

	}

	@RequestMapping(value = "hello6", method = RequestMethod.GET)
	public ModelAndView sayHello6(ModelAndView model, HttpServletRequest request) {
		model.addObject("mykey", "Using Model/ and view tag.as parameter.6th...");
		model.setViewName("ModelandView");
		HttpSession httpsession = request.getSession();
		request.setAttribute("hello", "hello world 6");
		httpsession.setAttribute("hellosess", "hello world  session");

		return model;
	}

	@RequestMapping(value = "hello7/{name}", method = RequestMethod.GET)
	public ModelAndView sayHello6(@PathVariable String name, ModelAndView model, HttpServletRequest request) {
		model.addObject("mykey", name);
		model.setViewName("ModelandView");
		HttpSession httpsession = request.getSession();
		request.setAttribute("hello", "hello world 6");
		httpsession.setAttribute("hellosess", "hello world  session");

		return model;

	}

	@RequestMapping(value = "hello8", method = RequestMethod.GET)
	public ModelAndView sayHello8(@RequestParam("uname") String name, ModelAndView model, HttpServletRequest request) {
		model.addObject("mykey", name);
		model.setViewName("ModelandView");
		HttpSession httpsession = request.getSession();
		request.setAttribute("hello", "hello world 6");
		httpsession.setAttribute("hellosess", "hello world  session");

		return model;
	}

	@RequestMapping(value = "hello10", method = RequestMethod.GET)
	public ResponseEntity<User> sayHello10() {
		User user = new User();
		user.setId(100);
		user.setName("Maamathi");
		return ResponseEntity.ok(user);

	}

	@RequestMapping(value = "hello11", method = RequestMethod.POST)
	public ResponseEntity<User> sayHello11(@RequestBody User user) {
//			User user=new User();
		user.setId(user.getId());
		user.setName(user.getName());
		return ResponseEntity.ok(user);

	}

	@RequestMapping(value = "form", method = RequestMethod.GET)
	public ModelAndView displayForm(ModelAndView model, StudentDTO student) {
		model.addObject("forms", student);
		model.setViewName("forms");
	
		return model;

	}
	
	@RequestMapping(value = "form", method = RequestMethod.POST)
	public ModelAndView createUser(ModelAndView model, StudentDTO student) {
		model.setViewName("successpage");
		service.createStudent(student.getStudentId(),student.getStudentName(),student.getStudentAge());
		return model;
	}

}
