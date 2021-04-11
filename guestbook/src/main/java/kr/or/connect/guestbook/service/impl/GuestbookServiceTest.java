package kr.or.connect.guestbook.service.impl;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.guestbook.config.ApplicationConfig;
import kr.or.connect.guestbook.dto.GuestBook;
import kr.or.connect.guestbook.service.GuestbokService;

public class GuestbookServiceTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class); 
		GuestbokService guestbokService = ac.getBean(GuestbokService.class);
		
		GuestBook guestbook = new GuestBook();
		guestbook.setName("hyunk0928");
		guestbook.setContent("반갑습니다. 여러분. 여러분이 재미있게 공부하고 계셨음 정말 좋겠네요^^22");
		guestbook.setRegdate(new Date());
		GuestBook result = guestbokService.addGuestbook(guestbook, "127.0.0.1");
		System.out.println(result);
		
	}
}
