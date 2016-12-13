package vo;

import java.util.Date;

public class MemberVo {
	private int memberNum;
	private String id;
	private String password;
	private String nickname;
	private String profileImgPath;
	private int naverJoin;
	private int point;
	private Date date;
	
	
	public MemberVo(){}
	
	
	
	public MemberVo(int memberNum, String id, String password, String nickname, String profileImgPath, int naverJoin,
			int point, Date date) {
		super();
		this.memberNum = memberNum;
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.profileImgPath = profileImgPath;
		this.naverJoin = naverJoin;
		this.point = point;
		this.date = date;
	}



	public MemberVo(int memberNum, String id, String password, String nickname, String profileImgPath, int naverJoin) {
		super();
		this.memberNum = memberNum;
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.profileImgPath = profileImgPath;
		this.naverJoin = naverJoin;
	}

	public MemberVo(String id, String password, String nickname, String profileImgPath, int naverJoin) {
		super();
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.profileImgPath = profileImgPath;
		this.naverJoin = naverJoin;
	}

	public MemberVo(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	
	public MemberVo(String id) {
		super();
		this.id = id;
	}

	
	
	
	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getprofileImgPath() {
		return profileImgPath;
	}

	public void setprofileImgPath(String profileImgPath) {
		this.profileImgPath = profileImgPath;
	}

	public int getNaverJoin() {
		return naverJoin;
	}

	public void setNaverJoin(int naverJoin) {
		this.naverJoin = naverJoin;
	}



	public int getPoint() {
		return point;
	}



	public void setPoint(int point) {
		this.point = point;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
