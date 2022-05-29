package com.githrd.boa.sql;
/*
 * @author	박소연
 * @since	2022/05/23
 * @version	v.1.0
 * 		
 * 			작업 이력
 * 				2022/05/23	-	클래스제작
 * 									담당자 : 박소연
 * 
 * 				2022/05/30	-	최종 디버깅 :	상수, sql문 수정(SEL_ALL_COLLECTION)
 * 												상수, sql문 추가(SEL_THUMBS)
 */
public class MainSQL {
	
	public final int SEL_ALL_COLLECTION	= 1001; //전체 컬렉션 조회
	public final int SEL_TOTAL_CNT		= 1002; //전체 컬렉션 갯수
	public final int SEL_THUMBS			= 1003; // 전체 컬렉션 썸네일 조회
	
	public String getSQL(int code) {
		
		StringBuffer buff = new StringBuffer();

		switch(code) {
		case SEL_ALL_COLLECTION:
			buff.append("SELECT ");
			buff.append("    rowno, cno, cname ");
			buff.append("FROM ");
			buff.append("    ( ");
			buff.append("        SELECT ");
			buff.append("            ROWNUM rowno, c.cno, c.cname ");
			buff.append("        FROM ");
			buff.append("            collection c ");
			buff.append("        WHERE ");
			buff.append("            c.isshow = 'Y' ");
			buff.append("        ORDER BY ");
			buff.append("            cno DESC ");
			buff.append("    ) ");
			buff.append("WHERE ");
			buff.append("    rowno BETWEEN ? AND ? ");
			break;
		case SEL_TOTAL_CNT:
			buff.append("SELECT ");
			buff.append("    COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("    collection ");
			buff.append("WHERE ");
			buff.append("    isshow = 'Y' ");
		    break;
		    
		case SEL_THUMBS:
			buff.append("SELECT ");
			buff.append("    bno, savename ");
			buff.append("FROM ");
			buff.append("    imgfile ");
			buff.append("WHERE ");
			buff.append("    isshow = 'C' ");
			buff.append("    AND whereis = 'C' ");
			break;
		}
		
		return buff.toString();
	}
}
