package vo;

import java.util.List;

public class CommentPageVO {
	private List<CommentVO> commentList;
	private int startPage;
	private int endPage;
	private int currentPage;
	private int totalPage;
////////////////////////////////////////////////////////////////
	public CommentPageVO(){}
	public CommentPageVO(List<CommentVO> commentList, 
			int startPage, int endPage, int currentPage, int totalPage) {
		this.commentList = commentList;
		this.startPage = startPage;
		this.endPage = endPage;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
	}
	
	public CommentPageVO(List<CommentVO> commentList){
		this.commentList = commentList;
	}
	
///////////////////////////////////////////////////////////////////
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<CommentVO> getCommentList() {
		return commentList;
	}
	public void setArticleList(List<CommentVO> commentList) {
		this.commentList = commentList;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
}
