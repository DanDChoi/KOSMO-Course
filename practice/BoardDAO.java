package board.mvc.model;

import java.sql.*;
import java.util.ArrayList;
import javax.naming.*;
import javax.sql.DataSource;
import mvc.domain.Board;
import static board.mvc.model.BoardSQL.LIST;
import static board.mvc.model.BoardSQL.SELECT;

public class BoardDAO{
    private DataSource ds;
    BaordDAO(){
        try {
            Context initContext = new initContext();
            Context envContext = (Context)initContext.lookup("java:/comp/env");
            ds = (DataSource)envContext.lookup("jdbc/myoracle");
        } catch (NamingException ne) {
        }
    }
    ArryaList<Board> list(){
        ArrayList<Board> list = new ArrayList<Board>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(LIST);
            while(rs.next()){
                long seq = rs.getLong(1);
                String writer = rs.getString(2);
                String email = rs.getString(3);
                String subject = rs.getString(4);
                String content = rs.getString(5);
                Date rdate = rs.getDate(6);

                Board board = new Board(seq, writer, email, subject, content, rdate);
                list.add(board);
            }
            return list;
        } catch (SQLException se) {
            return null;
        } finally {
            try{
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(con != null) con.close();
            }catch(SQLException se){}
        }
    }
    void insert(Board board){
       
    }
    Board content(long seq){
        Connection con = null;
        PreparedStatement = pstmt = null;
        Result rs = null;
        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(CONTENT);
            pstmt.setLong(1, seq);
            rs = pstmt.executeQuery();
            if(rs.next()){
                String writer = rs.getString(2);
                String email = rs.getString(3);
                String subject = rs.getString(4);
                String content = rs.getString(5);
                Date rdate = rs.getDate(6);

                Baord board = new Board(seq, writer, email, subject, content, rdate);
                return board;
            }else{
                return null;
            }
        } catch (SQLException se) {
            return null;
        }finally{
            try{
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();
            }catch(SQLException se){}
        }
    }
    void update(Board board){

    }
    void delete(long seq){

    }
