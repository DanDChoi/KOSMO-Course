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
import mvc.domain.Address;
import static addr.mvc.model.AddrSQL.LIST; //해당형식으로 임포트시 LIST로만 적어주면됨 (패키지 + 클래스.상수)

class AddrDAO {
	private DataSource ds;
	AddrDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/myoracle");
		} catch (NamingException ne) {

		}
	}

	 ArrayList<Address> list() {
		ArrayList<Address> list = new ArrayList<Address>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = LIST;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int seq = rs.getInt(1); // 1번째 컬럼
				String name = rs.getString(2);
				String addr = rs.getString(3);
				Date rdate = rs.getDate(4);
				list.add(new Address(seq, name, addr, rdate));
			}
			return list;
		} catch (SQLException se) {
			System.out.println("AddrDAO list() se : " + se);
			return null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
	}
	 boolean insert(Address dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = AddrSQL.INSERT;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			int i = pstmt.executeUpdate();
			if(i>0){
				System.out.println("alert('입력성공 with Dbcp')");
				return true;
			}else{
				System.out.println("alert('입력실패 with Dbcp')");
				return false;
			}
		}catch(SQLException se){
			System.out.println("alert('입력실패 with Dbcp')");
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
	 void del(int seq) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = AddrSQL.DELETE;
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
}
