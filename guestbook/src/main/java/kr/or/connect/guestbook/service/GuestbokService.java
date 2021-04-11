package kr.or.connect.guestbook.service;
import java.util.List;

import kr.or.connect.guestbook.dto.GuestBook;



public interface GuestbokService {
	public static final Integer LIMIT = 5;
	public List<GuestBook> getGuestbooks(Integer start);
	public int deleteGuestbook(Long id, String ip);
	public GuestBook addGuestbook(GuestBook guestbook, String ip);
	public int getCount();
}