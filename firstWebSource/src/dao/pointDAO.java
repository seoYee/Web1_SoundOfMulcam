package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.pointVO;

public class pointDAO {
	private static pointDAO instance = new pointDAO();

	public static pointDAO getintance() {
		return instance;
	}

	private pointDAO() {

	}

	public pointVO select(int memberNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		pointVO point = null;

		try {
			con = DBHelper.makeConnection();
			String sql = "SELECT * FROM MEMBER WHERE MEMBER_NUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, memberNum);

			rs = pstmt.executeQuery(); // SQL실행
			if (rs.next()) {
				point = new pointVO();
				point.setPoint(rs.getInt(7));

			}

		} catch (SQLException e) {
			System.out.println("select point 에러");
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(pstmt); // close 역순으로 작성
			DBHelper.close(con);
		}
		return point;
	}

	public int insert(int point, int memberNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			con = DBHelper.makeConnection();
			String sql = "update member set point=? where member_num=?;";

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, point);
			pstmt.setInt(2, memberNum);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}

	public int delete(int memberNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			con = DBHelper.makeConnection();
			String sql = "update member set point=point-3000 where member_num=?";

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, memberNum);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}

//	2592000000
	public double addDays(int memberNum, double addDays) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			con = DBHelper.makeConnection();
			String sql = "update member set date=date+? where member_num=?";

			pstmt = con.prepareStatement(sql);

			pstmt.setDouble(1, addDays);
			pstmt.setInt(2, memberNum);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("addDate 오류!");
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}
	
	public double setDate(int memberNum, double Date) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			con = DBHelper.makeConnection();
			String sql = "update member set date=? where member_num=?";

			pstmt = con.prepareStatement(sql);

			pstmt.setDouble(1, Date);
			pstmt.setInt(2, memberNum);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("setDate 오류!");
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}
	
	
	public double resetDate(int memberNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		double result = 0;

		try {
			con = DBHelper.makeConnection();
			String sql = "update member set date=0 where member_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, memberNum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("resetDate 오류!");
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}
	
	
	
	public double selectDate(int memberNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		double date = 0;
		try {
			con = DBHelper.makeConnection();
			String sql = "SELECT DATE FROM MEMBER WHERE MEMBER_NUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, memberNum);

			rs = pstmt.executeQuery(); // SQL실행

			rs.next();
			date = rs.getDouble(1);
		} catch (SQLException e) {
			System.out.println("selectDate 에러");
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(pstmt); // close 역순으로 작성
			DBHelper.close(con);
		}
		return date;
	}
	
	
}