package bitcinema.mvc.model;

import java.sql.*;
import java.util.*;
import javax.sql.*;
import javax.naming.*;
import javax.servlet.http.HttpServletRequest;

import bitcinema.mvc.model.DTO;
import bitcinema.mvc.model.SQL;

public class DAO 
{
	DataSource ds;
	
	DAO(){
		try{
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException n){}
	}

	ArrayList<DTO> result(String param0, String param1, String param2, String param3){
		ArrayList<DTO> result = new ArrayList<DTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		
		try{
			conn = ds.getConnection();
			
			if(param0.equals("genre")) {
				pstmt = conn.prepareStatement(SQL.SELECT_GENRE);
			}else if(param0.equals("director")) {
				pstmt = conn.prepareStatement(SQL.SELECT_DIRECTOR);
			}else if(param0.equals("actor")) {
				pstmt = conn.prepareStatement(SQL.SELECT_ACTOR);
				pstmt.setString(4, param1);
				pstmt.setString(5, param2);
				pstmt.setString(6, param3);
				pstmt.setString(7, param1);
				pstmt.setString(8, param2);
				pstmt.setString(9, param3);
			}else if(param0.equals("materials")) {
				pstmt = conn.prepareStatement(SQL.SELECT_MATERIALS);
			}
			pstmt.setString(1, param1);
			pstmt.setString(2, param2);
			pstmt.setString(3, param3);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				int film_id = rs.getInt("FILM_ID");
				String film_title = rs.getString("FILM_TITLE");
				String film_title_eng = rs.getString("FILM_TITLE_ENG");
				String film_content = rs.getString("FILM_CONTENT");
				String genre_name = rs.getString("GENRE_NAME");
				String material_name = rs.getString("MATERIAL_NAME");
				String director_name = rs.getString("DIRECTOR_NAME");
				String actor_name1 = rs.getString("ACTOR_NAME1");
				String actor_name2 = rs.getString("ACTOR_NAME2");
				String actor_name3 = rs.getString("ACTOR_NAME3");
				String film_poster = rs.getString("FILM_POSTER");
				float film_grade_naver = rs.getFloat("FILM_GRADE_NAVER");
				
				// AVG Grade
				pstmt = conn.prepareStatement(SQL.AVG_GRADE_BIT);
				pstmt.setInt(1, film_id);
				rs2 = pstmt.executeQuery();
				rs2.next();
				float film_grade_bit = rs2.getFloat("FILM_GRADE_BIT");
				int running_time = rs.getInt("RUNNING_TIME");
				
				DTO dto = new DTO(film_id, film_title, film_title_eng, film_content, genre_name, material_name, director_name, actor_name1,
						actor_name2, actor_name3, film_poster, film_grade_naver, film_grade_bit, running_time);
				result.add(dto);
			}
			return result;
		}catch(SQLException s){
			System.out.println(s);
			return null;
		}finally{
			try{
				if(rs2 != null) rs.close();
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException s){}
		}
	}
	
	ArrayList<DTO> film_detail(HttpServletRequest request){
		ArrayList<DTO> film_detail = new ArrayList<DTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		
		int film_id = 1;
		try{
			film_id = Integer.parseInt(request.getParameter("code"));
		}catch(NumberFormatException nfe){}
		
		try{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(SQL.FILM_DETAIL);
			pstmt.setInt(1, film_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				String film_title = rs.getString("FILM_TITLE");
				String film_title_eng = rs.getString("FILM_TITLE_ENG");
				String film_content = rs.getString("FILM_CONTENT");
				String genre_name = rs.getString("GENRE_NAME");
				String material_name = rs.getString("MATERIAL_NAME");
				int director_id = rs.getInt("DIRECTOR_ID");
				String director_name = rs.getString("DIRECTOR_NAME");
				int actor_id1 = rs.getInt("ACTOR_ID1");
				int actor_id2 = rs.getInt("ACTOR_ID2");
				int actor_id3 = rs.getInt("ACTOR_ID3");
				String actor_name1 = rs.getString("ACTOR_NAME1");
				String actor_name2 = rs.getString("ACTOR_NAME2");
				String actor_name3 = rs.getString("ACTOR_NAME3");
				String film_poster = rs.getString("FILM_POSTER");
				float film_grade_naver = rs.getFloat("FILM_GRADE_NAVER");
				
				// AVG Grade
				pstmt = conn.prepareStatement(SQL.AVG_GRADE_BIT);
				pstmt.setInt(1, film_id);
				rs2 = pstmt.executeQuery(); rs2.next();
				float film_grade_bit = rs2.getFloat("FILM_GRADE_BIT");
				int running_time = rs.getInt("RUNNING_TIME");

				DTO dto = new DTO(film_id, film_title, film_title_eng, film_content, genre_name, material_name, director_id, director_name,
						actor_id1, actor_id2, actor_id3, actor_name1, actor_name2, actor_name3, film_poster, film_grade_naver, film_grade_bit,
						running_time);
				film_detail.add(dto);
			}
			return film_detail;
		}catch(SQLException s){
			System.out.println(s);
			return null;
		}finally{
			try{
				if(rs2 != null) rs2.close();
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException s){}
		}
	}
	
	ArrayList<DTO> reviewList(HttpServletRequest request) {
		ArrayList<DTO> reviewList = new ArrayList<DTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int film_id = 1;
		try{
			film_id = Integer.parseInt(request.getParameter("code"));
		}catch(NumberFormatException e){}
	
		try{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(SQL.REVIEW_LIST);
			pstmt.setInt(1, film_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				String review_writer = rs.getString("REVIEW_WRITER");
				String review_content = rs.getString("REVIEW_CONTENT").replace(" ", "&nbsp;");
				String review_writedate = rs.getString("WRITEDATE");
				float review_grade = rs.getFloat("REVIEW_GRADE");
				
				DTO dto = new DTO(film_id, review_writer, review_content, review_writedate, review_grade);
				reviewList.add(dto);
			}
			return reviewList;
		}catch(SQLException s){
			System.out.println(s);
			return null;
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			    if(conn != null) conn.close();
			}catch(SQLException s){}
		}
	}
	
	boolean reviewInsert(HttpServletRequest request){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(SQL.REVIEW_INSERT);
			pstmt.setString(1, request.getParameter("film_id"));
			pstmt.setString(2, request.getParameter("review_writer"));
			pstmt.setString(3, request.getParameter("review_content"));
			pstmt.setString(4, request.getParameter("review_grade"));
			pstmt.executeUpdate();
			return true;
		}catch(SQLException s){
			System.out.println(s);
			return false;
		}finally{
			try{
			    if(pstmt != null) pstmt.close();
			    if(conn != null) conn.close();
			}catch(SQLException s){}
		}
	}
	
	boolean reviewDelete(HttpServletRequest request){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(SQL.REVIEW_DELETE);
			pstmt.setString(1, request.getParameter("film_id"));
			pstmt.setString(2, request.getParameter("review_writer"));
			pstmt.executeUpdate();
			return true;
		}catch(SQLException s){
			System.out.println(s);
			return false;
		}finally{
			try{
			    if(pstmt != null) pstmt.close();
			    if(conn != null) conn.close();
			}catch(SQLException s){}
		}
	}
	
	ArrayList<DTO> search(HttpServletRequest request) {
		ArrayList<DTO> search = new ArrayList<DTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(SQL.SEARCH_FILM_TITLE);
			pstmt.setString(1, "%" + request.getParameter("keyword") + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				String film_title = rs.getString("FILM_TITLE");

				DTO dto = new DTO(film_title);
				search.add(dto);
			}
			return search;
		}catch(SQLException s){
			System.out.println(s);
			return null;
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			    if(conn != null) conn.close();
			}catch(SQLException s){}
		}
	}
	
	int search_convert(String param) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int film_id = 1;
		try{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(SQL.SEARCH_CONVERT);
			pstmt.setString(1, param);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				film_id = rs.getInt("FILM_ID");
			}
			return film_id;
		}catch(SQLException s){
			System.out.println(s);
			return 1;
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			    if(conn != null) conn.close();
			}catch(SQLException s){}
		}
	}
	
	ArrayList<DTO> curating_board(){
		ArrayList<DTO> curating_board = new ArrayList<DTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
				
		try{
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.CURATING_BOARD);
			
			while(rs.next()){
				int curating_no = rs.getInt("NO");
				String curating_subject = rs.getString("SUBJECT");
				String curating_content = rs.getString("CONTENT").replace(" ", "&nbsp;").replace("&nbsp;", "\n");
				String curating_writedate = rs.getString("WRITEDATE");
				String youtubeurl = rs.getString("YOUTUBEURL");

				DTO dto = new DTO(curating_no, curating_subject, curating_content, curating_writedate, youtubeurl);
				curating_board.add(dto);
			}
			return curating_board;
		}catch(SQLException s){
			System.out.println(s);
			return null;
		}finally{
			try{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(SQLException s){}
		}
	}
}