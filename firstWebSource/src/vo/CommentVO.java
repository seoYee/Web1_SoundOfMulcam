package vo;

import java.awt.List;
import java.sql.Timestamp;

public class CommentVO {
	private int commentNum; // 댓글번호
	private int musicNum; // 뮤직번호
	private String nickname; // 닉네임
	private String profileImg; // 프로필 이미지 주소
	private Timestamp writeDate; // 작성일시
	private int grp;
	private int seq;
	private String content;
	private List aaa;
	
	public CommentVO(){}
	

	public CommentVO(int commentNum, int musicNum, String nickname, String profileImg, Timestamp writeDate, int grp,
			int seq, String content, List aaa) {
		super();
		this.commentNum = commentNum;
		this.musicNum = musicNum;
		this.nickname = nickname;
		this.profileImg = profileImg;
		this.writeDate = writeDate;
		this.grp = grp;
		this.seq = seq;
		this.content = content;
		this.aaa = aaa;
	}


	public CommentVO(int commentNum, int musicNum, String nickname, String profileImg, Timestamp writeDate, int grp,
			int seq, String content) {
		this.commentNum = commentNum;
		this.musicNum = musicNum;
		this.nickname = nickname;
		this.profileImg = profileImg;
		this.writeDate = writeDate;
		this.grp = grp;
		this.seq = seq;
		this.content = content;
	}
	
	public CommentVO(int musicNum, String nickname, String profileImg, String content){
		this.musicNum = musicNum;
		this.nickname = nickname;
		this.profileImg = profileImg;
		this.content = content;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public int getMusicNum() {
		return musicNum;
	}

	public void setMusicNum(int musicNum) {
		this.musicNum = musicNum;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public Timestamp getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}

	public int getgrp() {
		return grp;
	}

	public void setgrp(int grp) {
		this.grp = grp;
	}

	public int getseq() {
		return seq;
	}

	public void setseq(int seq) {
		this.seq = seq;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public int getGrp() {
		return grp;
	}


	public void setGrp(int grp) {
		this.grp = grp;
	}


	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}


	public List getAaa() {
		return aaa;
	}


	public void setAaa(List aaa) {
		this.aaa = aaa;
	}
	
}