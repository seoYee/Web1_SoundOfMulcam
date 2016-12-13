package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import vo.CommentVO;
import vo.FileVO;

public class FileDao {
	private static FileDao instance = new FileDao();

	public static FileDao getInstance() {
		return instance;
	}

	private FileDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("mysql 드라이버 로딩 오류");
			e.printStackTrace();
		}
	}
////////////////////////////////////////////////////////
	public List<FileVO> selectFileList() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<FileVO> fileList = new ArrayList<>();

		try {
			con = DBHelper.makeConnection();
			String sql = "select * from music";
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				FileVO file = new FileVO();
				file.setFileNum(rs.getInt(1));
				file.setTitle(rs.getString(2));
				file.setAlbum(rs.getString(3));
				file.setSinger(rs.getString(4));
				file.setSavedImgPath(rs.getString(5));
				file.setSavedPath(rs.getString(6));
				file.setFileName(rs.getString(10));

				fileList.add(file);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(stmt);
			DBHelper.close(con);
		}
		return fileList;
	}
	
	
	public List<FileVO> selectTopList() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<FileVO> fileList = new ArrayList<>();

		try {
			con = DBHelper.makeConnection();
			String sql = "select music_num,title,album,singer,image,filename,mp3name from music ORDER BY play DESC limit 10";
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				FileVO file = new FileVO();
				
				file.setFileNum(rs.getInt(1));
				file.setTitle(rs.getString(2));
				file.setAlbum(rs.getString(3));
				file.setSinger(rs.getString(4));
				file.setSavedImgPath(rs.getString(5));
				file.setFileName(rs.getString(6));
				file.setMp3Name(rs.getString(7));

				fileList.add(file);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(stmt);
			DBHelper.close(con);
		}
		return fileList;
	}

	public List<FileVO> selectChartList() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<FileVO> fileList = new ArrayList<>();

		try {
			con = DBHelper.makeConnection();
			String sql = "select music_num,title,album,singer,image,filename,mp3name from music ORDER BY play DESC limit 50";
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				FileVO file = new FileVO();
				
				file.setFileNum(rs.getInt(1));
				file.setTitle(rs.getString(2));
				file.setAlbum(rs.getString(3));
				file.setSinger(rs.getString(4));
				file.setSavedImgPath(rs.getString(5));
				file.setFileName(rs.getString(6));
				file.setMp3Name(rs.getString(7));

				fileList.add(file);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(stmt);
			DBHelper.close(con);
		}
		return fileList;
	}

	
	
	public List<FileVO> selectNewList() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<FileVO> fileList = new ArrayList<>();

		try {
			con = DBHelper.makeConnection();
			String sql = "select music_num,image,title,singer,album,filename from music ORDER BY music_num DESC limit 10";
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				FileVO file = new FileVO();
				
				file.setFileNum(rs.getInt(1));
				file.setSavedImgPath(rs.getString(2));
				file.setTitle(rs.getString(3));
				file.setSinger(rs.getString(4));
				file.setAlbum(rs.getString(5));
				file.setFileName(rs.getString(6));

				fileList.add(file);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(stmt);
			DBHelper.close(con);
		}
		return fileList;
	}

	
	
	public int insert(FileVO fileVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			con = DBHelper.makeConnection();
			String sql = "INSERT INTO music " + 
				"(title,mp3Name,album,singer,image,mp3,filename)" + 
				"VALUES(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, fileVO.getTitle());
			pstmt.setString(2, fileVO.getMp3Name());
			pstmt.setString(3, fileVO.getAlbum());
			pstmt.setString(4, fileVO.getSinger());
			pstmt.setString(5, fileVO.getSavedImgPath());
			pstmt.setString(6, fileVO.getSavedPath());
			pstmt.setString(7, fileVO.getFileName());
			
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("dao insert 에러");
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}

	public FileVO selectFile(int fileNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FileVO result = null;

		try {
			con = DBHelper.makeConnection();
			String sql = 
				"SELECT music_num,filename,title,singer,album,mp3name FROM music WHERE music_num=?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, fileNum);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new FileVO();
				result.setFileNum(rs.getInt(1));
				result.setFileName(rs.getString(2));
				result.setTitle(rs.getString(3));
				result.setSinger(rs.getString(4));
				result.setAlbum(rs.getString(5));
				result.setMp3Name(rs.getString(6));
			}
		} catch (SQLException e) {
			System.out.println("dao select file error");
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}
	
	public List<CommentVO> selectCommentList(int musicNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CommentVO> commentList = new ArrayList<>();

		System.out.println("제발?"+musicNum);
		
		try {
			con = DBHelper.makeConnection();
			String sql = "SELECT * FROM COMMENT WHERE MUSIC_NUM=? ORDER BY GRP DESC, SEQUENCE ASC";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, musicNum);
//			pstmt.setInt(2, startRow);
//			pstmt.setInt(3, endRow - startRow); // limit의 두번째는 개수
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CommentVO comment = new CommentVO();
				comment.setCommentNum(rs.getInt(1));
				comment.setMusicNum(rs.getInt(2));
				comment.setNickname(rs.getString(3));
				comment.setProfileImg(rs.getString(4));
				comment.setWriteDate(rs.getTimestamp(5));
				comment.setgrp(rs.getInt(6));
				comment.setseq(rs.getInt(7));
				comment.setContent(rs.getString(8));
				commentList.add(comment);
			}
		} catch (SQLException e) {
			System.out.println("selectCommentList 에러");
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return commentList;
	}
	
//	public int updateDownCount(int fileNum){
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		int result = 0;
//		try {
//			con = DBHelper.makeConnection();
//			String sql = "UPDATE FILE_BOARD SET "+
//				"DOWN_COUNT=DOWN_COUNT+1 WHERE FILE_NUM=?";
//			
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, fileNum);
//			
//			result = pstmt.executeUpdate(); // 쿼리 실행
//		} catch (SQLException e) {
//			System.out.println("dao update downcount 에러");
//			e.printStackTrace();
//		} finally {
//			DBHelper.close(pstmt);
//			DBHelper.close(con);
//		}
//		return result;
//	}
	
	public int selectCommentCount(int musicNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int commentCount = 0;

		try {
			con = DBHelper.makeConnection();
			String sql = "SELECT COUNT(*) FROM COMMENT WHERE MUSIC_NUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, musicNum);
			rs = pstmt.executeQuery();

			rs.next();
			commentCount = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commentCount;
	}

	public int insert(CommentVO comment) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			con = DBHelper.makeConnection();
			String sql = "INSERT INTO COMMENT(MUSIC_NUM,NICKNAME,PROFILE_IMG,WRITE_DATE,GRP,SEQUENCE,CONTENT) "
					+ "VALUES(?,?,?,now(),1,1,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, comment.getMusicNum());
			pstmt.setString(2, comment.getNickname());
			pstmt.setString(3, comment.getProfileImg());
			pstmt.setString(4, comment.getContent());

			result = pstmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("insert에러!!");
			ex.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}

	public int selectMaxInsertNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			con = DBHelper.makeConnection();
			String sql = "SELECT MAX(COMMENT_NUM) FROM COMMENT";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}
	
	public int selectMaxSeq(int parentCommentNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			con = DBHelper.makeConnection();
			String sql = "SELECT MAX(SEQUENCE) FROM COMMENT WHERE grp=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, selectComment(parentCommentNum).getgrp());
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		
		return result;
	}
	// 코멘트 처음 쓸때 그룹번호를  comment_num 과 맞춰줌
	public int updateInitgrp(int commentNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			con = DBHelper.makeConnection();
			String sql = "UPDATE COMMENT SET grp=? WHERE COMMENT_NUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, commentNum);
			pstmt.setInt(2, commentNum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("updateInitgrp 에러");
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}


	public int insertReplyComment(CommentVO reply, int parentCommentNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			con = DBHelper.makeConnection();
			String sql = "INSERT INTO COMMENT(MUSIC_NUM,NICKNAME,PROFILE_IMG,WRITE_DATE,grp,SEQUENCE,CONTENT) "
					+ "VALUES(?,?,?,now(),?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reply.getMusicNum());
			pstmt.setString(2, reply.getNickname());
			pstmt.setString(3, reply.getProfileImg());
			pstmt.setInt(4, selectComment(parentCommentNum).getgrp());
			pstmt.setInt(5, selectMaxSeq(parentCommentNum) + 1);
			pstmt.setString(6, reply.getContent());

			result = pstmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("ReplyCommentInsert에러!!");
			ex.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;

	}

	public CommentVO selectComment(int commentNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CommentVO comment = null;

		try {
			con = DBHelper.makeConnection();
			String sql = "SELECT * FROM COMMENT WHERE COMMENT_NUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, commentNum);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				comment = new CommentVO();
				comment.setCommentNum(rs.getInt(1));
				comment.setMusicNum(rs.getInt(2));
				comment.setNickname(rs.getString(3));
				comment.setProfileImg(rs.getString(4));
				comment.setWriteDate(rs.getTimestamp(5));
				comment.setgrp(rs.getInt(6));
				comment.setseq(rs.getInt(7));
				comment.setContent(rs.getString(8));

			}
		} catch (SQLException e) {
			System.out.println("selectcomment 에러");
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return comment;
	}

	public int update(CommentVO comment) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			con = DBHelper.makeConnection();
			String sql = "UPDATE COMMENT " + "SET CONTENT=? " + "WHERE COMMENT_NUM=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, comment.getContent());
			pstmt.setInt(2, comment.getCommentNum());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("update 에러");
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}

	public int delete(int commentNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			con = DBHelper.makeConnection();
			String sql = "DELETE FROM COMMENT " + "WHERE COMMENT_NUM=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, commentNum);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("update 에러");
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		return result;
	}	
	
}
