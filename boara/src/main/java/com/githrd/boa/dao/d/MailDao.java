package com.githrd.boa.dao.d;

import java.sql.*;

import com.githrd.boa.db.*;
import com.githrd.boa.sql.d.*;

/**
 * 이 클래스는   
 * 	
 * @author	양동수
 * @since	2022.05.24
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.27	-	클래스제작
 * 									담당자 ] 양동수
 * 
 * 				2022.05.28	-	main branch 백업 : 미사용 import 제거 (com.githrd.vo.d)
 * 									담당자 ] 최이지
 * 
 * 								디버깅 중 함수 추가(newMemWelcome, newMemIsshow)
 * 									담당자 ] 양동수
 */
public class MailDao {
	
	private BoaDBCP db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private MailSQL mSQL;
	
	public MailDao() {
		db = new BoaDBCP();
		mSQL = new MailSQL();
	}

	//신규 회원가입 인증하기위한 cert테이블 입력
	public int insertCert(String id, int code) {
		int cnt = 0;
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.INSERT_NEW_CERT);
		pstmt = db.getPstmt(con, sql);
		
		try {
			pstmt.setString(1, id);
			pstmt.setInt(2, code);
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	//DB에서 가장 마지막에 cert신청한 유져의 id가져오기 전담처리함수
	public String getLastCert() {
		String id, idcode = "";
		int code;
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.GET_LAST_CERT);
		stmt = db.getStmt(con);
		try {
			rs = stmt.executeQuery(sql);
			rs.next();
			id = rs.getString("id");
			code = rs.getInt("code");
			idcode = id+'&'+code;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return idcode;
	}
	
	//이메일링크를 클릭하여 인증된 id의 cert isverify 변경 전담 처리함수
	public int certAfter(String id, int code) {
		int cnt = 0;
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.UP_CERT_AFTER);
		pstmt = db.getPstmt(con, sql);
		try {
			pstmt.setString(1, id);
			pstmt.setInt(2, code);
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	//신규가입자에게 point table row 추가, 100point 선물, 전담처리함수
	public int newMemWelcome() {
		int pcnt = 0;
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.NEW_MEM_WELCOME);
		stmt = db.getStmt(con);
		try {
			pcnt = stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(stmt);
			db.close(con);
		}
		return pcnt;
	}
	
	//신규가입자의 member테이블의 isshow 변경하여 권한주기 전담처리함수
	public int newMemIsshow(String dbid) {
		int cnt = 0;
		
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.NEW_MEM_ISSHOW);
		pstmt = db.getPstmt(con, sql);
		try {
			pstmt.setString(1, dbid);
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
}