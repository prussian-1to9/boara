package com.githrd.boa.controller.j;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.boa.controller.*;
import com.githrd.boa.dao.j.*;
import com.githrd.boa.vo.j.*;

/**
 * 이 클래스는 회원 관련 데이터베이스 작업을 전담해서 처리하는 클래스
 * @author	정준영
 * @since	2022.05.25
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.25	-	클래스제작
 * 									담당자 ] 정준영
 * 
 *				2022.05.29	-	디버깅용 명령 추가(프로필 사진 있는지)
 *									담당자 ] 최이지
 */

public class Myinfo implements BoaInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String sid = (String) req.getSession().getAttribute("SID");
		String view = "/member/myinfo";
		if(sid == null) {
			req.setAttribute("isRirect", true);
			return view = "/member/login.boa";
		}
		MemberDao mDao = new MemberDao();
		MemberVO mVO = mDao.getMemberInfo(sid);
		
		// 프로필 사진 있는지 검사
		/*
		 * int cnt = mDao.ifHasFiles(sid); if(cnt != 0) { String avt =
		 * mDao.getFiles(sid); mVO.setAvt(avt); }
		 */
		int mno = mVO.getMno();
		mVO.setPoint(mDao.getMyPoint(mno));
		int bcnt = mDao.getBoardCnt(mno);
		int rcnt = mDao.getReplyCnt(mno);
		mVO.setBcnt(bcnt);
		mVO.setRcnt(rcnt);
		
		req.setAttribute("DATA", mVO);
		return view; 
	}

}
