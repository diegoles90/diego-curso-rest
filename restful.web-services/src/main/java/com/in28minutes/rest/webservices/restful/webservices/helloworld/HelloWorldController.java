package com.in28minutes.rest.webservices.restful.webservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {
	
//	@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	// /hello-world
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Holaa Gaspar, PAPÁ, ÁMBAR, TAÍNA, MAMÁ";
	}
	
	// /hello-world-bean
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		//throw new RuntimeException("Some errors has happened!");
		return new HelloWorldBean("Hello World");
	}
	
	// /hello-world/path-variable/name
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {		
		return new HelloWorldBean(String.format("Hello World , %s", name));
	}

}
