package board.mvc.model;

import java.sql.*;
import java.util.ArrayList;
import javax.naming.*;
import javax.sql.DataSource;
import mvc.domain.Board;
import static board.mvc.model.BoardSQL.LIST;
import static board.mvc.model.BoardSQL.SELECT;

class BoardDAO{
    private DataSource ds;
    BoardDAO(){
        try{
        Context initContext = new InitialContext();
        Context envContext = (Context)initContext.lookup("java:/comp/env");
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
            try{
                con = ds.getConnection();
                stmt = con.createStatement();
                rs = stmt.executeQuery(sql);
                while(rs.next()){
                    int seq = rs.getInt(1);
                    String writer = rs.getString(2);
                    String email = rs.getString(3);
                    String subject = rs.getString(4);
                    String content = rs.getString(5);
                    Date rdate = rs.getDate(6);

                    Board board = new Board(seq, writer, email, subject, content, rdate);
                    list.add(board);
                }
                return list;
            }catch(SQLException se){
                return null;
            }finally{
                try{
                    if(con != null) con.close();
                    if(stmt != null) stmt.close();
                    if(rs != null) rs.close();
                }catch(SQLException se){}
            }
    }
    void delete(int seq){
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
                if(con != null) con.close();
                if(pstmt != null) pstmt.close();
            }catch(SQLException se){}
        }

    }
    ArrayList<Board> getupdate(int seq){
        ArrayList<Board> list = new ArrayList<Board>();
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = BaordSQL.GETUPDATE;
        ResultSet rs = null;
        try{
            con = ds.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, seq);
            rs = pstmt.executeQuery();
            while(rs.next()){
                String writer = rs.getString(2);
                String email = rs.getString(3);
                String subject = rs.getString(4);
                String content = rs.getString(5);
                Date rdate = rs.getDate(6);
                list.add(new Board(seq, writer, email, subject, content, rdate));
            }
            return list;
        }catch(SQLException se){
            System.out.println("BoardDAO list() se: " + se);
            return null;
        }finally{
            try{
                if(con != null) con.close();
                if(pstmtm != null) pstmt.close();
                if(rs != null) rs.close();
            }catch(SQLException se){}
       }
    }
    void update(Board dto){
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = BoardSQL.UPDATE;
        try{
            con = ds.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(4, dto.getSeq());
            pstmt.setString(1, dto.getEmail());
            pstmt.setString(2, dto.getSubject());
            pstmt.setString(3, dto.getContent());
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
