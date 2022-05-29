package com.githrd.boa.controller.k;
/**
 * 회원 프로필사진 변경 작업을 수행하는 클래스
 * @author	김소연
 * @since	2022.05.28
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.28	-	클래스제작
 * 									담당자 ] 김소연
 *
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.boa.controller.BoaInter;
import com.githrd.boa.dao.k.MemberDao;
import com.githrd.boa.util.FileUtil;
import com.oreilly.servlet.MultipartRequest;

public class EditImgProc implements BoaInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", true);
		String view = "/boara/member/editInfo.boa";
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			return "/boara/member/login.boa";
		}
		
		FileUtil fUtil = new FileUtil(req, "/resources/upload");
		MultipartRequest multi = fUtil.getMulti();
		
		String sno = multi.getParameter("tfno");
		
		int ino = 0;
		if(sno != null) {
			ino = Integer.parseInt(sno);
		}
		
		MemberDao mDao = new MemberDao();
		int cnt = mDao.editImg(ino);
		
		
		return view;
	}

}
