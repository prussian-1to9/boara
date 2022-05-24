package com.githrd.boa.controller;
/**
 * 	boara의 메인페이지 뷰를 불러오는 클래스입니다.
 * 
 * 	@author 최이지
 * 	@since 2022.05.23
 * 	@version v.1.0
 * 			작업이력
 * 				2022.05.23	-	담담자 : 최이지
 * 									클래스 제작
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainForm implements BoaInter {
	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/main";
		return view;
	}
}
