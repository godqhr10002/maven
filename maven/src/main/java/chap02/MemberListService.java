package chap02;

import java.time.LocalDateTime;
import java.util.Map;

public class MemberListService {
	private MemberDao memberDao;
	
	public MemberListService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public  Map<String, Member> selectList() {
		return memberDao.selectList();	
	}
}
