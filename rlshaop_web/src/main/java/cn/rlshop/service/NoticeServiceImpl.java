package cn.rlshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.rlshop.mapper.NoticeMapper;
import cn.rlshop.model.Notice;



@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	/**
	 * 将数据库中的公告查询出来
	 */
	public List<Notice> findNoticeList() {
		return noticeMapper.findNoticeList();
	}

	@Override
	public Notice findNoticeById(String noticeId) {
		return noticeMapper.findNoticeById(noticeId);
	}

	@Override
	public void saveNotice(Notice notice) {
		 noticeMapper.saveNotice(notice);
	}

	@Override
	public void updateNotice(Notice notice) {
		 noticeMapper.updateNotice(notice);
		
	}

	@Override
	public void delNoticeById(String noticeId) {
		noticeMapper.delNoticeById(noticeId);
	}

}
