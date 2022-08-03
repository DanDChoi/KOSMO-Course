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

	public BoardDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/myoracle");
		} catch (NamingException ne) {

		}
	}
	public ArrayList<Board> list() { //����Ʈȭ��
		ArrayList<Board> list = new ArrayList<Board>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = BoardSQL.LIST;
		try{
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				int seq = rs.getInt(1);
				String writer = rs.getString(2);
				String email = rs.getString(3);
				String title = rs.getString(4);
				Date rdate = rs.getDate(6);
				list.add(new Board(seq, writer, email, title, null, rdate));
			}
			return list;
		}catch(SQLException se){
			return null;
		}finally
		{
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				System.out.println("Board list() se : " + se);
			}
		}
	}
	public void del(int seq) { //����
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = BoardSQL.DELELTE;
		if(seq != -1){
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
	}
	public boolean insert(Board dto) { //�߰�
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = BoardSQL.INSERT;

		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			int i = pstmt.executeUpdate();
		if(i>0){
			System.out.println("alert('�Է¼���')"); //�˸�â���
			return true;
		}else{
			System.out.println("alert('�Է½���')");
			return false;
		}
		}catch(SQLException se){
			System.out.println("�Է½���: "+ se);
			System.out.println("alert('�Է½���')");
			return false;
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){
				return false;
			}
		}
	}
	public Board content(int seq) { // �۳���
		Board board = null;
		String writer = null;
		String email = null;
		String title = null;
		String content = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = BoardSQL.CONTENT;
		ResultSet rs = null;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();//������ ����
			while(rs.next()){
				seq = rs.getInt(1);
				writer = rs.getString(2);
				email = rs.getString(3);
				title = rs.getString(4);
				content = rs.getString(5);
			}
			board = new Board(seq, writer, email, title, content, null);
			return board;
		}catch(SQLException se){
			return null;
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
	}
	public Board update(int seq) { //����ȭ��
		Board board = null;
		String wirter = null;
		String email = null;
		String title = null;
		String content = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = BoardSQL.UPDATE;
		ResultSet rs = null;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();//������ ����
			while(rs.next()){
				wirter = rs.getString(2);
				email = rs.getString(3);
				title = rs.getString(4);
				content = rs.getString(5);
			}
			board = new Board(seq, wirter, email, title, content, null);
			return board;
		}catch(SQLException se){
			return null;
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
	}
	public boolean updateDo(Board dto) { //��������
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = BoardSQL.UPDATEDO;

		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());//sql���� ���� ���� ����
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			pstmt.setInt(5, dto.getSeq());
			int i = pstmt.executeUpdate();
		if(i>0){
			System.out.println("alert('��������')"); //�˸�â���
			return true;
		}else{
			System.out.println("alert('��������')");
			return false;
		}
		}catch(SQLException se){
			System.out.println("��������: "+ se);
			System.out.println("alert('��������')");
			return false;
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
	}
}
