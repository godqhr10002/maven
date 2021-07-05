package chap03;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {
	@Bean 
	public MemberDao memberDao1() {
		return new MemberDao();
	}
	
	@Bean
	@Qualifier("dao")
	public MemberDao memberDao2() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService regSvc() {
		return new MemberRegisterService();
	}
	
	@Bean 
	public ChangePasswordService pwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		//pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
	
	@Bean 
	public MemberListService listSvc() {
		return new MemberListService();
	}
	
	@Bean 
	public MemberInfoService infoSvc() {
		return new MemberInfoService();
	}
}
