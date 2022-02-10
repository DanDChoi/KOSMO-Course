package team1.togather.model;

import static team1.togather.model.GroupTabSQL.*;

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

import team1.togather.domain.GroupTab;

class GroupTabDAO {
	private DataSource ds;
	GroupTabDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {
		}
	}
	ArrayList<GroupTab> groupList(){
		ArrayList<GroupTab> groupList = new ArrayList<GroupTab>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(GROUP_LIST);
			while(rs.next()) {
				long gSeq = rs.getLong(1);
				String gName = rs.getString(2);
				String gIntro = rs.getString(3);
				long mNum = rs.getLong(4);
				String gAddr = rs.getString(5);
				String time = rs.getString(6);
				String interest = rs.getString(7);
				int limit = rs.getInt(8);
				int price = rs.getInt(9);
				Date rdate = rs.getDate(10);
				groupList.add(new GroupTab(gSeq, gName, gIntro, mNum, gAddr, time, interest, limit, price, rdate));
			}
			return groupList;
		}catch(SQLException se) {
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	ArrayList<GroupTab> groupInfo(long gSeq) {
		ArrayList<GroupTab> groupInfo = new ArrayList<GroupTab>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GROUP_INFO);
			pstmt.setLong(1, gSeq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String gName = rs.getString(2);
				String gIntro = rs.getString(3);
				long mNum = rs.getLong(4);
				String gAddr = rs.getString(5);
				String time = rs.getString(6);
				String interest = rs.getString(7);
				int limit = rs.getInt(8);
				int price = rs.getInt(9);
				Date rdate = rs.getDate(10);
				groupInfo.add(new GroupTab(gSeq, gName, gIntro, mNum, gAddr, time, interest, limit, price, rdate));
				//System.out.println("gSeq: " + gSeq);
			}
			return groupInfo;
		}catch(SQLException se) {
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	boolean groupCreate(GroupTab dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GROUP_CREATE);
			//insert into GROUPTAB values(GROUP_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)
			pstmt.setString(1, dto.getgName());
			pstmt.setString(2, dto.getgIntro());
			pstmt.setLong(3, 1);
			pstmt.setString(4, dto.getgAddr());
			pstmt.setString(5, dto.getTime());
			pstmt.setString(6, dto.getInterest());
			pstmt.setInt(7, dto.getLimit());
			pstmt.setInt(8, dto.getPrice());
			int i = pstmt.executeUpdate();
			if(i>0) {
				return true;
			}else {
				return false;
			}		
		}catch(SQLException se) {
			System.out.println("#GroupCreate() se: " + se);
			return false;
		}finally {
			try {
				if(con != null) con.close();
				if(pstmt !=null) pstmt.close();
			}catch(SQLException se) {}
		}
	}
}
