package com.githrd.boa.controller.d;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.githrd.boa.controller.BoaInter;
import com.githrd.boa.dao.d.MailDao;
import com.githrd.boa.sql.d.*;

public class MailConfirm implements BoaInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isredirect", true);
		String view="/member/join.boa";//인증실패 시 join페이지로 리다이렉트
		
		String mailCode = req.getParameter("code");//인증메일의 code파라미터값추출
		String mailId = req.getParameter("id");//인증메일의 id파라미터값추출
		String dbcode, dbid="";

		MailSQL mSQL = new MailSQL();
		MailDao mDao = new MailDao();
		String idcode = mDao.getLastCert();//하나의 String에 DB의 신규가입자id와 6자리 code 불러오기
		dbid = idcode.substring(0, idcode.indexOf('&'));//String 쪼개기
		dbcode = idcode.substring(idcode.indexOf('&')+1);//String 쪼개기
		
		if(mailCode.equals(dbcode)&&mailId.equals(dbid)) {//db와 mail의 id와 code가 같은지 확인
			int code = Integer.parseInt(dbcode);
			int ccnt = mDao.certAfter(dbid, code);//cert table의 인증여부 'Y'변경
			int pcnt = mDao.newMemWelcome();//인증완료
			int icnt = mDao.newMemIsshow(dbid);//멤버 글쓰기 권한주기
			
			if(ccnt==1&&pcnt==1&&icnt==1) {//모든인증절차 완료
				req.getSession().setAttribute("SID", dbid);//세션에 아이디입력
				req.setAttribute("isredirect", false);
				view = "/main";//메인페이지로 포워드
			}else {
				System.out.println("verify failed");
			}
		}
		
		
		
		
		return view;
	}

}
