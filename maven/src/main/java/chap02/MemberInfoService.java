package chap02;

import java.time.LocalDateTime;
import java.util.Map;

public class MemberInfoService {
	private MemberDao memberDao;
	
	public MemberInfoService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public  Member selectOne(String email) {
		return memberDao.selectByEmail(email);	
	}
}
