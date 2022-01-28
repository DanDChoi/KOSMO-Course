package addr.mvc.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
				String name = rs.getString(2);
				String email = rs.getString(3);
				String subject = rs.getString(4);
				String content = rs.getString(5);
				Date rdate = rs.getDate(6);
				list.add(new Board(seq, name, email, subject, content, rdate));
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
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
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
	ArrayList<Board> contents (int seq) {
		ArrayList<Board> lists = new ArrayList<Board>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		String sql = BoardSQL.CONTENT;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
		    pstmt.setInt(1, seq);
		    rs = pstmt.executeQuery();
		    while(rs.next()){
		        String name = rs.getString(2);
		        String email = rs.getString(3);
		        String subject = rs.getString(4);
		        String content = rs.getString(5);
		        Date rdate = rs.getDate(6); 
		        lists.add(new Board(seq, name, email, subject, content, rdate));
		    }
		    return lists;
		}catch(SQLException se){
		}finally{
		    try{
		        if(rs != null) rs.close();
		        if(con != null) con.close();
		        if(con != null) stmt.close();
		        if(con != null) pstmt.close();
		    }catch(SQLException se){}
		}return null;
	}
}
