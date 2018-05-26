package cn.rlshop.service;

import java.util.List;

import cn.rlshop.model.Notice;



public interface NoticeService {
	/**
	 * 查询所有的公告
	 * @return
	 */
	public List<Notice> findNoticeList();
	/**
	 * 根据公告id查询公告
	 * @return
	 */
	public Notice findNoticeById(String noticeId);
	
	
	public void saveNotice(Notice notice);
	
	public void updateNotice(Notice notice);
	
	public void delNoticeById(String noticeId);
}
