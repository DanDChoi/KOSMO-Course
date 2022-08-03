import java.sql.*;

class B{
	String url = "jdbc:oracle:thin:@localhost:1521:JAVA";
	Connection con;
	Statement stmt;
    B(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, "scott", "tiger");
            stmt = con.createStatement();
        }catch(ClassNotFoundException cnfe){
            pln("드라이버로딩실패(클래스를못찾음)");
        }catch(SQLException se){
            pln("Oracle과 연결실패");
        }
    }
    String tname = "JDBCT";
    void createT(){
        String sql = "create table "+tname+"(NO number(2) primary key, Name varchar(10), RDATE date)";
        try{
            stmt.execute(sql);
            pln(tname+"테이블생성성공");
        }catch(SQLException se){
            pln(tname+"테이블생성실패"+se);
        }
    }
    void createTnoExist(){
        String sql = "select TABLE_NAME from user_tables where TABLE_NAME='"+tname+"'";
        ResultSet re =  null;
        try{
            rs = stmt.executeQuery(sql);
            if(!rs.next()) createT();
        }catch(SQLException se){
        }finally{
            try{
                rs.close();
            }catch(SQLException se){}
        }
    }
    void dropT(){
        String sql = "drop table"+tname;
        String purge = "purge recyclebin";
        try{
            stmt.execute(sql);
            stmt.execute(purge);
            pln(tname+"테이블 드랍 성공");
        }catch(SQLException se){
            pln(tname+"테이블 드랍실패: "+se);
        }
    }

    void insertD(int no, String name){
        String sql = "insert into"+tname+"values("+no+", '"+name+"', SYSDATE)";
        try{
            int i = stmt.executeUpdate(sql);
            if(i>0){
                pln(i+"개의 row입력성공");
            }else{
                pln("입력되지 않음");
            }
        }catch(SQLException se){
            pln("입력실패: "+se);
        }
    }
    void updateD(int no, String name){
        String sql = "update"+name+" set name='"+name+"' where NO="+no;
        try{
            int i = stmt.executeUpdate(sql);
            if(i>0){
                pln(i+"개의 row 수정성공");
            }else{
                pln("수정되지 않음");
            }
        }catch(SQLException se){
            pln("수정 실패: "+ se);
        }
    }
    void deleteD(int no){
        String sql = "delete from "+tname+" where NO="+no;
        try{
            int i = stmt.executeUpdate(sql);
            if(i>0){
                pln(i+"개의 row 삭제 성공");
            }else{
                pln("삭제되지 않음");
            }
        }catch(SQLException se){
            pln("삭제 실패: "+se);
        }
    }
    void selectD(){
        String sql = "select * from "+tname+" order by RDATE desc";
        ResultSet rs = null;
        try{
            rs = stmt.executeQuery(sql);
            int cnt = 0;
            pln("NO\tName\tRDATE");
            pln("------------------------");
            while(rs.next()){
                int no = rs.getInt("NO");
                String name = rs.getString("NAME");
                DATE rdate = rs.getDate("RDATE");
                pln(no+"\t"+name+"\t"+rdate);

                cnt++;
            }
            pln("------------------------");
            pln("총 "+cnt+"개 데이터 검색됨");
        }catch(SQLException se){
            pln("selectD() 예외: "+se);
        }finally{
            try{
                rs.close();
            }catch(SQLException se){}
        }

    }
    void closeALL(){
        try{
            stmt.close();
            con.close();
        }catch(SQLException se){
        }
    }
    void pln(String str){
        System.out.println(str);
    }
    public static void main(String[] args){
        B b = new B();
    }

}