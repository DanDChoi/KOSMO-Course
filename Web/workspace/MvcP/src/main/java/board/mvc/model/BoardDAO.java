package board.mvc.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.*;
import javax.sql.DataSource;

import mvc.domain.Board;

class BoardDAO {
	private DataSource ds;
	BoardDAO(){
		try{
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne){
		}
	}
	ArrayList<Board> list(){
		ArrayList<Board> list = new ArrayList<Board>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = BoardSQL.LIST;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int seq = rs.getInt(1);
				String writer = rs.getString(2);
				String email = rs.getString(3);
				String subject = rs.getString(4);
				String content = rs.getString(5);
				Date rdate = rs.getDate(6);
				String fname = rs.getString(7);
				String ofname = rs.getString(8);
				
				Board board = new Board(seq, writer, email, subject, content, rdate, fname, ofname);
				list.add(board);
			}
			return list;
		} catch (SQLException se) {
			System.out.println("#service() se: " + se);
			return null;
		} finally {
			try {
				if (rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			} catch (SQLException se){}
			}
		}
	
	boolean insert(Board dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = BoardSQL.INSERT;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			System.out.println("writer:"+ dto.getWriter());
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5, dto.getFname());
			pstmt.setString(6, dto.getOfname());ㅏ
			int i = pstmt.executeUpdate();
			if(i>0){
				return true;
			}else{
				return false;
			}
		}catch(SQLException se){
			System.out.println("#Board insert() se: "+ se);
			return false;
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
	}
	ArrayList<Board> contentlist(int seq) {
		ArrayList<Board> list = new ArrayList<Board>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = BoardSQL.CONTENT;
			try{
				con = ds.getConnection();
				//System.out.println("con: "+con);
				pstmt = con.prepareStatement(sql);
				//System.out.println("seq: "+seq);
				pstmt.setInt(1, seq);
				//System.out.println("sql: "+sql);
			    rs = pstmt.executeQuery();
			    while(rs.next()){
			        String writer = rs.getString(2);
			        String email = rs.getString(3);
			        String subject = rs.getString(4);
			        String content = rs.getString(5);
			        Date rdate = rs.getDate(6);
			        String fname = rs.getString(7);
			        String ofname = rs.getString(8);
			        list.add(new Board(seq, writer, email, subject, content, rdate, fname, ofname));
			    }
		    	return list;
		}catch(SQLException se){
			return null;
		}finally{
		    try{
		        if(rs != null) rs.close();
		        if(con != null) con.close();
		        if(pstmt != null) pstmt.close();
		    }catch(SQLException se){}
		}
	}
	void delete(int seq) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = BoardSQL.DELETE;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
		}catch(SQLException se){
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
	}
	ArrayList<Board> getupdate(int seq) {
		ArrayList<Board> list = new ArrayList<Board>();
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = BoardSQL.GETUPDATE;
		ResultSet rs = null;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String writer = rs.getString(2);
				String email = rs.getString(3);
				String subject = rs.getString(4);
				String content = rs.getString(5);
				Date rdate = rs.getDate(6);
				String fname = rs.getString(7);
				String ofname = rs.getString(8);
					System.out.println("fname(DAO.getupdate): "+fname);
				list.add(new Board(seq, writer, email, subject, content, rdate, fname, ofname));
			}
			return list;
		}catch(SQLException se){
			System.out.println("#BoardDAO list() se: " + se);
	        return null;
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
	}		
	void update(Board dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = BoardSQL.UPDATE;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(6, dto.getSeq());
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
				System.out.println("content(DAO.update): "+ dto.getContent());
			pstmt.setString(4, dto.getFname());
				System.out.println("fname(DAO.update): "+ dto.getFname());
			pstmt.setString(5, dto.getOfname());
			pstmt.executeUpdate();
		}catch(SQLException se){
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}	
	}
	ArrayList<Board> delfile(int seq) {
		ArrayList<Board> list = new ArrayList<Board>();
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = BoardSQL.GETUPDATE;
		ResultSet rs = null;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
				System.out.println("seq: " + seq);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String writer = rs.getString(2);
				String email = rs.getString(3);
				String subject = rs.getString(4);
					System.out.println("writer: "+ writer);
				String content = rs.getString(5);
				Date rdate = rs.getDate(6);
				//String fname = rs.getString(7);
				//String ofname = rs.getString(8);
				list.add(new Board(seq, writer, email, subject, content, rdate, null, null));
			}
			return list;
		}catch(SQLException se){
			System.out.println("#BoardDAO list() se: " + se);
	        return null;
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
	}		
}
