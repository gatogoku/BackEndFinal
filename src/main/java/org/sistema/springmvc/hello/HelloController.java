package org.sistema.springmvc.hello;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller class form default action
 * 
 * @author Eugenia Pérez Martínez
 */
@Controller
public class HelloController {

	/**
	 * default constructor
	 */
	public HelloController() {
		System.out.println("BEAN instantiated");
	}

	/**
	 * handles default / or /hello request
	 * 
	 * @param model
	 * @return the name of the view to show RequestMapping({"/hello"})
	 */
	@RequestMapping("/hello")
	public String sayHelloPage(Map<String, Object> model) {
		System.out.println("say hello");
		model.put("greet", "Hello World, welcome to my app");
		// We return view name
		return "hello";
	}
}