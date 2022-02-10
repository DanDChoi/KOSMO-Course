package team1.togather.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.*;
import javax.sql.DataSource;

import team1.togather.domain.GroupTab;

import static team1.togather.model.GroupTabSQL.GROUP_LIST;

class GroupTabDAO {
	private DataSource ds;
	GroupTabDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
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
					System.out.println("gSeq(DAO): " + gSeq);
				
				GroupTab grouptab = new GroupTab(gSeq, gName, gIntro, mNum, gAddr, time, interest, limit, price, rdate);
				groupList.add(grouptab);
			}
			return groupList;
		}catch(SQLException se) {
			System.out.println("#service() se: " + se);
			return null;
		}finally{
			try {
				if(con != null) con.close();
				if(stmt != null) stmt.close();
				if(rs != null) rs.close();
		}catch(SQLException se) {}
		}
	}
		
}


