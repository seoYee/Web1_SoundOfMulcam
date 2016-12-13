package service;

import dao.MemberDAO;
import vo.MemberVo;

public class MemberService {
	private MemberService() {
	}

	private static MemberService instance = new MemberService();

	public static MemberService getInstance() { // static을 안붙이면 왜 다른 클래스에서 호출할 수
												// 없는지 모르겠음
		return instance;
	}

	private MemberDAO dao = MemberDAO.getInstance();

	// 네이버 아이디인지 아닌지 체크한 후 가입되어 있는 아이디인지 아닌지 체크
	// String savedMember = "blet357@naver.com";
	// int nv = savedMember.indexOf("@");
	// String checkNv = savedMember.substring(nv);
	//
	// if(checkNv.equals("@naver.com")){
	// System.out.println(checkNv);
	// }else{
	// System.out.println("ffff");
	// }
	// }

	public String joinCheck(String id) {
		String anotherJoin = "@naver.com";
		MemberVo savedMember = dao.select(id);
		int nv = id.indexOf("@");
		String checkNv = id.substring(nv);

		if (savedMember != null) {
			return "alreadyJoin";
		} else {
			if (checkNv.equals(anotherJoin)) {
				return "joinToNaver";
			} else {
				return "joinPossible";
			}
		}
	}

	public boolean join(MemberVo member) {
		MemberVo savedMember = dao.select(member.getId());
		if (savedMember != null) {
			return false;
		} else {
			int result = dao.insertMember(member);
			if (result == 1) {
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean login(String id, String password) {
		MemberVo savedMember = dao.select(id);
		if (savedMember != null && savedMember.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}

	}
	
	public MemberVo loginUserInfo(String id, String password){
		MemberVo loginUserObject = dao.select(id); 
		return loginUserObject;
	}
}
