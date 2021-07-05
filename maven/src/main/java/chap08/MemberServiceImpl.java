package chap08;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao dao;
	
	@Override
	public List<MemberVo> selectList() {
		
		return dao.selectList();
	}

	@Override
	public MemberVo login(MemberVo vo) {
		return dao.login(vo);
	}
	
//	@Override
//	public MemberVo mypage(int mno) {
//		return dao.selectOne(mno);
//	}

	@Override
	public String mypage(HttpSession sess, Model model) {
		MemberVo vo = (MemberVo) sess.getAttribute("memberInfo");
		if (vo != null) {
			MemberVo m = dao.selectOne(vo.getMno());
			model.addAttribute("vo", m);
			return "member/mypage";
		} else {
			model.addAttribute("msg", " 로그인 후 가져오가");
			model.addAttribute("url", "index.do");
			return "include/alert";
		}
		
	}

	@Override
	public int update(MemberVo vo) {
		
		return dao.update(vo);
	}
	

	

}	
