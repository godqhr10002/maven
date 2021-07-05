package chap09;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

	@Override
	@Transactional(timeout = -1)
	public int insert(MemberVo vo, HttpServletRequest req) {
		int r = 0;
		try {
		dao.insert(vo);
		//vo객체에 mno가 set이 되어있는 상태
		String[] school = req.getParameterValues("school");
		String[] year = req.getParameterValues("year");
		Map map = new HashMap();
		map.put("members_mno", vo.getMno());
		for (int i =0; i<school.length; i++) {
			if(!"".equals(school[i]) || !"".equals(year[i])) {
			map.put("school", school[i]);
			map.put("year", year[i]);
			dao.insertSchool(map);
			}
		}
		r = 1;
	} catch (Exception e) {
		r = 0;
	}
		return r;
	}
}	
