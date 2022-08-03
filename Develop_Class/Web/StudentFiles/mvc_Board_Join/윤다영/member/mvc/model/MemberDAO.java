package member.mvc.model;

import mvc.domain.Member;
import static member.mvc.model.MemberSQL.SIGNUPINSERT;
import static member.mvc.model.MemberSQL.CHECKEXISTID;
import static member.mvc.model.MemberSQL.CHECKPWD;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


class MemberDAO {
	private DataSource ds;
	
	MemberDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		} catch(NamingException ne) {
		}
	}
	
	// 회원가입
	boolean signUpInsert(Member dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SIGNUPINSERT);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getNickname());
			//System.out.println("실행 전");
			
			int i = pstmt.executeUpdate();
			//System.out.println("확인"+i);
			if(i>0) {
				return true;
			} else {
				return false;
			}
		} catch(SQLException se) {
			System.out.println("signUpInsert() exception: "+se);
			return false;
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {}
		}
	}
	
	// DB에 id가 있는지 확인 (회원가입된 id가 맞는 지 확인)
	boolean checkExistId(Member dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(CHECKEXISTID);
			pstmt.setString(1, dto.getId());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				//System.out.println("idid: "+rs.getString(2));
				return true;
			}
			return false;
		} catch(SQLException se) {
			System.out.println("checkExistId() 예외: "+se);
			return false;
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch(SQLException se) {
			}
		}
	}
	
	// DB에 id가 있다면, id의 pwd가 입력한 pwd와 일치하는지 확인
	boolean checkPwd(Member dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(CHECKPWD);
			pstmt.setString(1, dto.getId());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String pwdStr = rs.getString(1);
				if(dto.getPwd().equalsIgnoreCase(pwdStr)) {
					return true;
				}
			}
			return false;
		} catch(SQLException se) {
			System.out.println("checkPwd() 예외: "+se);
			return false;
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch(SQLException se) {
			}
		}
	}
	
	// signIn
	Member getUser(String idS) {
		Member user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(CHECKEXISTID);
			pstmt.setString(1, idS);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Long seq = rs.getLong(1);
				String id = rs.getString(2);
				String email = rs.getString(4);
				String nickname = rs.getString(5);
				Date rdate = rs.getDate(6);
				
				//System.out.println("nickname: "+rs.getString(5));
				user = new Member(seq, id, null, email, nickname, rdate);
			}
			return user;
		}  catch(SQLException se) {
			System.out.println("getUser() 예외: " + se);
			return user;
		}
	}
	
} // end of class
