package cn.rlshop.mapper;

import java.util.List;

import cn.rlshop.model.Notice;


public interface NoticeMapper {
	/**
	 * 查询公告集合
	 * @return
	 */
	public List<Notice> findNoticeList();
	/**
	 * 根据id查询notice
	 * @return
	 */
	public Notice findNoticeById(String noticeId);
	
	
	public void saveNotice(Notice notice);
	
	public void updateNotice(Notice notice);
	
	public void delNoticeById(String noticeId);
}
