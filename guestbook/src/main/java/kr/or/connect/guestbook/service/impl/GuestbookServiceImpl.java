package kr.or.connect.guestbook.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.guestbook.dao.GuestBookDao;
import kr.or.connect.guestbook.dao.LogDao;
import kr.or.connect.guestbook.dto.GuestBook;
import kr.or.connect.guestbook.dto.Log;
import kr.or.connect.guestbook.service.GuestbokService;

@Service
public class GuestbookServiceImpl implements GuestbokService{

	@Autowired
	GuestBookDao guestbookDao;
	
	@Autowired
	LogDao logDao;

	@Override
	@Transactional
	public List<GuestBook> getGuestbooks(Integer start) {
		List<GuestBook> list=guestbookDao.selectAll(start,GuestbokService.LIMIT);
		
		return list;
	}

	@Override
	@Transactional(readOnly=false)
	public int deleteGuestbook(Long id, String ip) {
		int deleteCount=guestbookDao.deleteById(id);
		Log log=new Log();
		log.setIp(ip);
		log.setMethod("delete");
		log.setRegdate(new Date());
		logDao.insert(log);
		return deleteCount;
	}

	@Override
	@Transactional(readOnly=false)
	public GuestBook addGuestbook(GuestBook guestbook, String ip) {
		guestbook.setRegdate(new Date());
		Long id=guestbookDao.insert(guestbook);
		guestbook.setId(id);
		
		Log log=new Log();
		log.setIp(ip);
		log.setMethod("insert");
		log.setRegdate(new Date());
		logDao.insert(log);
		
		return guestbook;
	}

	@Override
	public int getCount() {
		
		//return guestbookDao.selectCount() ;
		return 10;
	}
	
	
}
