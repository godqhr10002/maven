package chap06;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	
	
	@RequestMapping(value="/hello.do" , method=RequestMethod.GET)
	public String hello(Model model) {
		model.addAttribute("name","홍길동");
		return "hello";
	}
	@GetMapping("/hello2.do")
	public String hello2(Model model) {
		model.addAttribute("name","홍길동");
		return "hello";
	}
	@GetMapping("/board/write.do")
	public String write(Model model) {
		model.addAttribute("name","홍길동");
		return "hello";
	}
	@PostMapping("/board/write.do")
	public String write2(Model model) {
		model.addAttribute("name","홍길동");
		return "hello";
	}
}
	