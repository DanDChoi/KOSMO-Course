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

import team1.togather.domain.Gathering;
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
				String gLoc = rs.getString(2);
				String gName = rs.getString(3);
				String gIntro = rs.getString(4);
				String interest = rs.getString(5);
				int limit = rs.getInt(6);
				Date rdate = rs.getDate(7);
				long mNum = rs.getLong(8);				
				groupList.add(new GroupTab(gSeq, gLoc, gName, gIntro, interest, limit, rdate, mNum));
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
			pstmt = con.prepareStatement(GROUP_SELECT);
			pstmt.setLong(1, gSeq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String gLoc = rs.getString(2);
				String gName = rs.getString(3);
				String gIntro = rs.getString(4);
				String interest = rs.getString(5);
				int limit = rs.getInt(6);
				Date rdate = rs.getDate(7);
				long mNum = rs.getLong(8);				
				groupInfo.add(new GroupTab(gSeq, gLoc, gName, gIntro, interest, limit, rdate, mNum));
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
	boolean groupInsert(GroupTab dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GROUP_INSERT);
			//"insert into GROUPTAB values(GROUP_SEQ.nextval, ?, ?, ?, ?, ?, SYSDATE, ?)"
			pstmt.setString(1, dto.getgLoc());
			pstmt.setString(2, dto.getgName());
			pstmt.setString(3, dto.getgIntro());
			pstmt.setString(4, dto.getInterest());
			pstmt.setInt(5, dto.getLimit());
			pstmt.setLong(6, 1); //mNum session
			int i = pstmt.executeUpdate();
			if(i>0) {
				return true;
			}else {
				return false;
			}		
		}catch(SQLException se) {
			System.out.println("#GroupInsert() se: " + se);
			return false;
		}finally {
			try {
				if(con != null) con.close();
				if(pstmt !=null) pstmt.close();
			}catch(SQLException se) {}
		}
	}
	ArrayList<GroupTab> groupGetUpdate(long gSeq){
		ArrayList<GroupTab> list = new ArrayList<GroupTab>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GROUP_SELECT);
			pstmt.setLong(1, gSeq);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String gLoc = rs.getString(2);
				String gName = rs.getString(3);
				String gIntro = rs.getString(4);
				String interest = rs.getString(5);
				int limit = rs.getInt(6);
				Date rdate = rs.getDate(7);
				int mNum = rs.getInt(8);
				 System.out.println("gLoc(DAO) groupGetUpdate: " + gLoc);
				list.add(new GroupTab(gSeq, gLoc, gName, gIntro, interest, limit, rdate, mNum));
			}
			return list;
		}catch(SQLException se) {
			System.out.println("#GroupTabDAO groupGetUpdate() se: "+ se);
			return null;
		}finally {
			try {				
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	void groupUpdate(GroupTab dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GROUP_UPDATE);
			//update GROUPTAB set GLOC=?, GNAME=?, GINTRO=?, LIMIT=? WHERE GSEQ=?
			pstmt.setLong(5, dto.getgSeq());
			pstmt.setString(1, dto.getgLoc());
			pstmt.setString(2, dto.getgName());
			pstmt.setString(3, dto.getgIntro());
			pstmt.setInt(4, dto.getLimit());
				System.out.println("gLoc(DAO) : "+ dto.getgLoc() + dto.getgSeq() + dto.getgName() + dto.getgIntro() + dto.getLimit());
			pstmt.executeUpdate();

		}catch(SQLException se) {
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	boolean gatheringInsert(Gathering dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GATHERING_INSERT);
			//insert into GATHERING values(GATHERING_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?)
			pstmt.setString(1, dto.getGt_name());
			pstmt.setString(2, dto.getGt_date());
			pstmt.setString(3, dto.getTime());
			pstmt.setString(4, dto.getGt_place());
			pstmt.setString(5, dto.getPrice());
			pstmt.setInt(6, dto.getGt_limit());
			pstmt.setLong(7, dto.getgSeq()); //모임의 GSEQ를 가져와야함
			int i = pstmt.executeUpdate();
			if(i>0) {
				return true;
			}else {
				return false;
			}		
		}catch(SQLException se) {
			System.out.println("#gatheringInsert() se: " + se);
			return false;
		}finally {
			try {
				if(con != null) con.close();
				if(pstmt !=null) pstmt.close();
			}catch(SQLException se) {}
		}
	}
	ArrayList<Gathering> gatheringList(long gSeq){
		ArrayList<Gathering> gatheringList = new ArrayList<Gathering>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GATHERING_LIST);
			pstmt.setLong(1, gSeq);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				long gt_seq = rs.getLong(1);
				String gt_name = rs.getString(2);
				String gt_date = rs.getString(3);
				String time = rs.getString(4);
				String gt_place = rs.getString(5);
				String price = rs.getString(6);
				int gt_limit = rs.getInt(7);
				gatheringList.add(new Gathering(gt_seq, gt_name, gt_date, time, gt_place, price, gt_limit, gSeq));
				System.out.println("gatheringList의 gSeq: " + gSeq);
			}
			return gatheringList;
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
}
