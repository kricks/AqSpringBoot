package mvc.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class Hello {
	@GetMapping(value = "/hello")
	@ResponseBody
	public String sayHello() {
		return "Hello World!";
	}
}
