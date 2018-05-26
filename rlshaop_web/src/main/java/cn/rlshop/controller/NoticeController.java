package cn.rlshop.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.rlshop.model.Notice;
import cn.rlshop.service.NoticeService;


@Controller
public class NoticeController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("/tonotice")
	public String toNotice(Model model){
		List<Notice> noticeList = noticeService.findNoticeList();
		model.addAttribute("noticeList",noticeList);
		return "notice";
	}
	@RequestMapping("/noticeInfo")
	public String noticeInfo(String noticeId,Model model){
		Notice notice = noticeService.findNoticeById(noticeId);
		model.addAttribute("notice",notice);
		return "noticeInfo";
	}
}
