package soo.dbcp;

import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.Context;
import javax.naming.NamingException;

public class DbcpBean {

    private DataSource ds;
    public DbcpBean(){
        try{
        Context initContext = new InitialContext();
        Context envContext  = (Context)initContext.lookup("java:/comp/env");
        ds = (DataSource)envContext.lookup("jdbc/myoracle");
        }catch(NamingException ne){
            System.out.println("#can't find object(jdbc/myoracle) made by tomcat");
        }
        //Connection conn = ds.getConnection();

    }
    public DataSource getDs(){
        return ds;
    }
}