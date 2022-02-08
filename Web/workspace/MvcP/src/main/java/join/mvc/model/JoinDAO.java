package join.mvc.model;

import static join.mvc.model.JoinSQL.INSERT;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import mvc.domain.Member;

class JoinDAO {
	private DataSource ds;
	JoinDAO(){
		try{
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne){}
	}
	boolean insert(Join dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT);
			pstmt.setString(1, getName);
			pstmt.setString(2, getEmail);
			pstmt.setString(3, getPwd);
			pstmt.setString(4, getPhone);
			int i = pstmt.executeUpdate();
			if(1>0) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException se) {
			System.out.println("#Join insert() se"+se);
			return false;
		}finally {
			if(pstmt !=null) pstmt.close();
			if(con != null) con.close();
		}catch(SQLException se) {}
	}
}
