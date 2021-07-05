package chap06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	
	
	//리턴이 없으면 매핑된 url과 동일한 경로 jsp로 포워딩
	@RequestMapping("/test.do")
	public void test(HttpServletResponse res) throws IOException {
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print("<script>alert('정상적으로 저장되었습니다.');</script>");
	}
	
	@RequestMapping("/")
	public String index() {
		return "redirect:index.do";
	}

//	@RequestMapping("/index.do")
//	public String index() {
//		return "index";
//	}
	@RequestMapping("/form.do")
	public String form() {
		return "form";
	}
	
	@RequestMapping("/send.do")
	public String send(Model model,
						HttpServletRequest req,
						@RequestParam(value="name", required = false) String name2,
						@RequestParam(value="email", required = false) String email2,
						@RequestParam(value="no", required = false, defaultValue = "0") int no,
						MemberVo vo) {
		//파라미터를 받는 방법
		// 1.HttpServletRequest
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		// 2.@RequestParam
		//  @RequestParam("파라미터명") : 매개변수에 지정
		//3. 커맨드객체
		
//		System.out.println(vo.getHobby().length);
//		for (int v : vo.getHobby()) {
//			System.out.println(v);
//		}
		
		model.addAttribute("name1", name);
		model.addAttribute("email1", email);
		model.addAttribute("name2", name2);
		model.addAttribute("email2", email2);
		model.addAttribute("no", no);
		model.addAttribute("vo", vo);
		
		// req.setAttribute("id", "hong");
		if(email == null || "".equals(email)) {
			return "form";
		}
		return "send";
	}
	@RequestMapping("/main.do")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "홍길동");
		mav.setViewName("main");
		return mav;
	}
	
}
