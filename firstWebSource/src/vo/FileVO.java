package vo;

import java.awt.List;

public class FileVO {
	 private int fileNum;
	    private String fileName;
	    private String savedPath;
	    private String savedImgPath;
	    private int downCount;
	    private int fileSize;
	    private String title;
		private String singer;
		private String album;
		private String mp3Name;
		private List musicList;


		/////////////////////////////////////////////////////////////
	    public FileVO(){}
	     
	    public FileVO(String fileName, String savedPath, int downCount, int fileSize) {
	        this.fileName = fileName;
	        this.savedPath = savedPath;
	        this.downCount = downCount;
	        this.fileSize = fileSize;
	    }
	public FileVO(int fileNum, String fileName, String savedPath, int downCount, int fileSize, String title,
				String singer, String album) {
			this.fileNum = fileNum;
			this.fileName = fileName;
			this.savedPath = savedPath;
			this.downCount = downCount;
			this.fileSize = fileSize;
			this.title = title;
			this.singer = singer;
			this.album = album;
		}

	public FileVO(int fileNum, String fileName, String savedPath, String savedImgPath, int downCount, int fileSize,
			String title, String singer, String album) {
		this.fileNum = fileNum;
		this.fileName = fileName;
		this.savedPath = savedPath;
		this.savedImgPath = savedImgPath;
		this.downCount = downCount;
		this.fileSize = fileSize;
		this.title = title;
		this.singer = singer;
		this.album = album;
	}

	public FileVO(int fileNum, String fileName, String savedPath, String savedImgPath, int downCount, int fileSize,
			String title, String singer, String album, String mp3Name) {
		super();
		this.fileNum = fileNum;
		this.fileName = fileName;
		this.savedPath = savedPath;
		this.savedImgPath = savedImgPath;
		this.downCount = downCount;
		this.fileSize = fileSize;
		this.title = title;
		this.singer = singer;
		this.album = album;
		this.mp3Name = mp3Name;
	}

		
		public FileVO(int fileNum, String fileName, String savedPath, String savedImgPath, String title, String singer,
			String album) {
		super();
		this.fileNum = fileNum;
		this.fileName = fileName;
		this.savedPath = savedPath;
		this.savedImgPath = savedImgPath;
		this.title = title;
		this.singer = singer;
		this.album = album;
	}

		public FileVO(int fileNum, String fileName, String savedPath, String savedImgPath, int downCount, int fileSize,
				String title, String singer, String album, String mp3Name, List musicList) {
			super();
			this.fileNum = fileNum;
			this.fileName = fileName;
			this.savedPath = savedPath;
			this.savedImgPath = savedImgPath;
			this.downCount = downCount;
			this.fileSize = fileSize;
			this.title = title;
			this.singer = singer;
			this.album = album;
			this.mp3Name = mp3Name;
			this.musicList = musicList;
		}

		////////////////////////////////////////////////////////////    
	    public int getFileNum() {
	        return fileNum;
	    }
	    public void setFileNum(int fileNum) {
	        this.fileNum = fileNum;
	    }
	    public String getFileName() {
	        return fileName;
	    }
	    public void setFileName(String fileName) {
	        this.fileName = fileName;
	    }
	    public String getSavedPath() {
	        return savedPath;
	    }
	    public void setSavedPath(String savedPath) {
	        this.savedPath = savedPath;
	    }
	    public int getDownCount() {
	        return downCount;
	    }
	    public void setDownCount(int downCount) {
	        this.downCount = downCount;
	    }
	    public int getFileSize() {
	        return fileSize;
	    }
	    public void setFileSize(int fileSize) {
	        this.fileSize = fileSize;
	    }
	public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getSinger() {
			return singer;
		}

		public void setSinger(String singer) {
			this.singer = singer;
		}

		public String getAlbum() {
			return album;
		}

		public void setAlbum(String album) {
			this.album = album;
		}

		public String getSavedImgPath() {
			return savedImgPath;
		}

		public void setSavedImgPath(String savedImgPath) {
			this.savedImgPath = savedImgPath;
		}	
		public String getMp3Name() {
			return mp3Name;
		}

		public void setMp3Name(String mp3Name) {
			this.mp3Name = mp3Name;
		}

		public List getMusicList() {
			return musicList;
		}

		public void setMusicList(List musicList) {
			this.musicList = musicList;
		}

		/////////////////////////////////////////////////////////////
	    @Override
	    public String toString() {
	        return "FileVO [fileNum=" + fileNum + ", fileName=" + fileName + ", savedPath=" + savedPath + ", downCount="
	                + downCount + ", fileSize=" + fileSize + "]";
	    }   
}
