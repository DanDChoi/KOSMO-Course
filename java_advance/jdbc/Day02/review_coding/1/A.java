import java.sql.*;

class A{
    String ulr = "jdbc:oracle:thin:@localhost:1521:JAVA";
    Connection con;
    Statement stmt;
    String sql = "select * from JDBCT order by NO";

    A(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, "scott", "tiger");
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);     
        }catch(ClassNotFoundException cnfe){
            pln("1 execp:"+cnfe);
        }catch(SQLException se){
            pln("2 excep" +se);
        }
    }
        void createRs(){
            Result rs = null;
            try{
                rs = stmt.executeQuery(sql);
                forward(rs);
                backword(rs);
                rs.afterLast();
                backwrod(rs);

                forward(rs);
                rs.beforeFirst();
                forward(rs);
            }catch(SQLException se){
                pln("3 execp:"+ se);
            }
        }
        void forward(ResultSet rs){
            try{
                pln("순방향");
                while(rs.next()){
                    int no = rs.getInt(1);
                    String name = rs.getString(2);
                    String rdate = rs.getString(3);
                    pln(no+"\t"+name+"\t"+rdate);
                }
            }catch(SQLException se){}
        }
        void backward(ResultSet rs){
            try{
                pln("역방향");
                while(rs.previous()){
                    int no = rs.getInt(1);
                    String name = rs.getString(2);
                    String rdate = rs.getString(3);
                    pln(no+"\t"+name+"\t"+rdate);
                }
            }catch(SQLException se){
                pln("backward() se:"+se);
            }
        }
            void p(String str){
                System.out.print(str);
            }
            void pln(String str){
                System.out.println(str);
            }
            public static void main(String[] args){
                A a = new A();
                a.createRs();
            }
 }
    
