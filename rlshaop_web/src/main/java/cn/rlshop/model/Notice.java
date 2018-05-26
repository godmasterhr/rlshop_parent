package cn.rlshop.model;

public class Notice {
	private String noticeId;
	private String noticeTitle;
	private String noticeContent;
	
	
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", noticeContent=" + noticeContent + "]";
	}
	
}
