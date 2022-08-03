package board.mvc.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(BoardSQL.LIST);
			while(rs.next()) {
				long bseq = rs.getLong(1);
				String writer = rs.getString(2);
				String email = rs.getString(3);
				String subject = rs.getString(4);
				String content = rs.getString(5);
				Date rdate = rs.getDate(6);
				
				Board board = new Board(bseq, writer, email, subject, content, rdate);
				list.add(board);
				
			}return list;
			
		}catch(SQLException se) {
			System.out.println("se"+ se);
			return null;
		}finally {
			try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
			}catch(SQLException se) {
			}
		}
	}
}

