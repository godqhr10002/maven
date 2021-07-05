package chap04;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberListService {
	@Autowired
	private MemberDao memberDao;
	
//	public MemberListService(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}
	
	public  Map<String, Member> selectList() {
		return memberDao.selectList();	
	}
}
