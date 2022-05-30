package com.githrd.boa.controller.j;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.boa.controller.*;
import com.githrd.boa.dao.j.*;
import com.githrd.boa.vo.j.*;
import com.githrd.boa.util.*;
/**
 * @author	정준영
 * @since	2022.05.25
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.25	-	클래스제작
 * 									담당자 ] 정준영
 *
 */

public class MyPointHistory implements BoaInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String sid = (String) req.getSession().getAttribute("SID");
		String view = "/member/mypointhistory";

	
		if(sid == null) {
			req.setAttribute("isRirect", true);
			return view = "/member/login.boa";
		}
	
		int nowPage = 1;
		String spage = req.getParameter("nowPage");
		if(spage != null) {
			nowPage = Integer.parseInt(spage);
		}
		MemberDao mDao = new MemberDao();
		MemberVO mVO = mDao.getMemberInfo(sid);
		int mno = mVO.getMno();
		int bcnt = mDao.getBoardCnt(mno);
		int pcnt = mDao.getPointHistoryCnt(mno);
		PageUtil page = new PageUtil(nowPage, pcnt);
		ArrayList<MemberVO> list = mDao.getPointHistory(page, mno);
		mVO.setPoint(mDao.getMyPoint(mno));
		int rcnt = mDao.getReplyCnt(mno);
		mVO.setBcnt(bcnt);
		mVO.setRcnt(rcnt);
		
		
		
		req.setAttribute("DATA", mVO);
		req.setAttribute("LIST", list);
		req.setAttribute("PAGE", page);
		
		return view; 
	}

}
