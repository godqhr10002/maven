package chap09;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public interface MemberService {
	List<MemberVo> selectList();
	MemberVo login(MemberVo vo);
	//MemberVo mypage(int mno);
	String mypage(HttpSession sess, Model model);
//	String update(HttpSession sess, Model model);
	int update(MemberVo vo);
	int insert(MemberVo vo, HttpServletRequest req);
}
