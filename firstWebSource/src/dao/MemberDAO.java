package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.MemberVo;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();

	private MemberDAO() {
	}

	public static MemberDAO getInstance() {
		return instance;
	}

	public int insertMember(MemberVo member) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			con = DBHelper.makeConnection();
			String sql = "INSERT INTO MEMBER (ID,PASSWORD,NICKNAME,PROFILE_IMG,POINT,NAVER_JOIN) VALUES (?,?,?,?,?,?)";//愿꾪샇 �엳�뼱�빞 �븿
			//
			System.out.println(member.getPassword());
			System.out.println(member.getId());
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getNickname());
			pstmt.setString(4, member.getprofileImgPath());
			pstmt.setInt(5, member.getPoint());
			pstmt.setInt(6, member.getNaverJoin());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insertMember �뿉�윭");
			e.printStackTrace();
		}
		return result;
	}
	
	public MemberVo select(String id){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo result = null;
		
		try {
			con = DBHelper.makeConnection();
		String sql = "SELECT ID,PASSWORD,NICKNAME,PROFILE_IMG,NAVER_JOIN,POINT,DATE FROM MEMBER WHERE ID=?"; //愿꾪샇 �엳�쑝硫� �븞�맖
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = new MemberVo();
				
				result.setId(rs.getString(1));
				result.setPassword(rs.getString(2));
				result.setNickname(rs.getString(3));
				result.setprofileImgPath(rs.getString(4));
				result.setNaverJoin(rs.getInt(5));
				result.setPoint(rs.getInt(6));
				result.setDate(rs.getDate(7));
				
			}
		} catch (SQLException e) {
			System.out.println("select member �뿉�윭");
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(pstmt);
			DBHelper.close(con);
			return result;
		}
	}
}
