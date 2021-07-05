package chap02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("명령어를 입력해 주세요.");
			String cmd = reader.readLine();
			if (cmd.equals("exit")) {
				System.out.println("종료합니다.");
				break;
			} else if (cmd.startsWith("new")) {
				processNewCommand(cmd.split(" "));
			} else if (cmd.startsWith("change")) {
				processChangeCommand(cmd.split(" "));
			} else if (cmd.equals("list")) {
				//processListCommand(cmd.split(" "));
				// hong@gmail.com 홍길동 비밀번호 날짜	
				Map<String, Member> map = assembler.getListSvc().selectList();
				for (String key : map.keySet()) {
					Member m = map.get(key);
					System.out.println(m.getId()+"\t"+m.getEmail()+"\t"+m.getName()+"\t"+m.getPassword()+"\t"+m.getRegisterDateTime());
				}
			}
			// cmd.startWirh("info")
			//info 이메일
			//id: 1  email:hong@gmail.com name:홍길동, date2021..
			//없으면 -> 등록 않은 이메일입니다
			else if (cmd.startsWith("info")) {
				if(cmd.split(" ").length != 2) {
					return ;
				}
				Member member = assembler.getInfoSvc().selectOne(cmd.split(" ")[1]);
				if (member == null) {
					System.out.println("등록되자 않은 이메일입니다.");
				} else {
					System.out.println("id" + member.getEmail()+"id" + member.getId()+"email" + member.getEmail()+"name" + member.getName()+"date" + member.getRegisterDateTime());
				}
			}
		}
	} //new hong@gmail.com 홍길동 1234 1234
	private static Assembler assembler = new Assembler();
	private static void processNewCommand(String[] arg) {
		if (arg.length != 5) {
			return;
		}
		MemberRegisterService regSvc = assembler.getRegSvc();
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		
		if (!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}
		try {
		regSvc.regist(req);
		System.out.println("등록 완료");
		} catch (DuplicateMemberException e) {
			System.out.println("이메일 중복");
		}
		
	}

	private static void processChangeCommand(String[] arg) {
		if (arg.length != 4) {
			return;
		}
		ChangePasswordService pwdSvc = assembler.getPwdSvc();
		try {
			pwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("비밀번호 변경");
		} catch (MemberNotFoundException e) {
			System.out.println("회원이 존재하지 않습니다.");
		} catch (WrongIdPasswordException e) {
			System.out.println("이메일과 비밀번호가 일치하지 않습니다.");
		}
	}
	
//	private static void processListCommand(String[] arg) {
	
//		return;
//	}
}
