package com.oracle.jdbctest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.ucp.jdbc.PoolDataSourceFactory;
import oracle.ucp.jdbc.PoolDataSource;

/*
 * The sample demonstrates connecting to Autonomous Database using 
 * Oracle JDBC driver and UCP as a client side connection pool.
 */
public class ADBQuickStart {  
 
  public static void main(String args[]) throws Exception {
    // Make sure to have Oracle JDBC driver 18c or above 
    // to pass TNS_ADMIN as part of a connection URL.
    // TNS_ADMIN - Should be the path where the client credentials zip (wallet_dbname.zip) file is downloaded. 
    // dbname_medium - It is the TNS alias present in tnsnames.ora.
    final String DB_URL="jdbc:oracle:thin:@01_medium?TNS_ADMIN=/Users/Dan/Desktop/Develop/Develop_Class/Oracle/";
    // Update the Database Username and Password to point to your Autonomous Database
    final String DB_USER = "ADMIN";
    String DB_PASSWORD = "Dandatabase01" ;
    final String CONN_FACTORY_CLASS_NAME="oracle.jdbc.pool.OracleDataSource";
    
    // For security purposes, you must enter the password through the console 
    try {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter the password for Autonomous Database: ");
      DB_PASSWORD = scanner.nextLine();
    }
    catch (Exception e) {    
       System.out.println("ADBQuickStart - Exception occurred : " + e.getMessage());
       System.exit(1);
    } 
    // Get the PoolDataSource for UCP
    PoolDataSource pds = PoolDataSourceFactory.getPoolDataSource();

    // Set the connection factory first before all other properties
    pds.setConnectionFactoryClassName(CONN_FACTORY_CLASS_NAME);
    pds.setURL(DB_URL);
    pds.setUser(DB_USER);
    pds.setPassword(DB_PASSWORD);
    pds.setConnectionPoolName("JDBC_UCP_POOL");

    // Default is 0. Set the initial number of connections to be created
    // when UCP is started.
    pds.setInitialPoolSize(5);

    // Default is 0. Set the minimum number of connections
    // that is maintained by UCP at runtime.
    pds.setMinPoolSize(5);

    // Default is Integer.MAX_VALUE (2147483647). Set the maximum number of
    // connections allowed on the connection pool.
    pds.setMaxPoolSize(20);


    // Get the database connection from UCP.
    try (Connection conn = pds.getConnection()) {
      System.out.println("Available connections after checkout: "
          + pds.getAvailableConnectionsCount());
      System.out.println("Borrowed connections after checkout: "
          + pds.getBorrowedConnectionsCount());       
      // Perform a database operation
      doSQLWork(conn);
    } catch (SQLException e) {
        System.out.println("ADBQuickStart - "
          + "doSQLWork()- SQLException occurred : " + e.getMessage());
    } 
    
    System.out.println("Available connections after checkin: "
        + pds.getAvailableConnectionsCount());
    System.out.println("Borrowed connections after checkin: "
        + pds.getBorrowedConnectionsCount());
  }
 /*
 * Selects 20 rows from the SH (Sales History) Schema that is the accessible to all 
 * the database users of autonomous database. 
 */
 private static void doSQLWork(Connection conn) throws SQLException {
    String queryStatement = "SELECT CUST_ID, CUST_FIRST_NAME, CUST_LAST_NAME, CUST_CITY," 
      + "CUST_CREDIT_LIMIT FROM SH.CUSTOMERS WHERE ROWNUM < 20 order by CUST_ID";
      
    System.out.println("\n Query is " + queryStatement);
    
    conn.setAutoCommit(false);
    // Prepare a statement to execute the SQL Queries.
    try (Statement statement = conn.createStatement(); 
      // Select 20 rows from the CUSTOMERS table from SH schema. 
      ResultSet resultSet = statement.executeQuery(queryStatement)) {
        System.out.println(String.join(" ", "\nCUST_ID", "CUST_FIRST_NAME", 
             "CUST_LAST_NAME", "CUST_CITY", "CUST_CREDIT_LIMIT"));
        System.out.println("-----------------------------------------------------------");
        while (resultSet.next()) {
          System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " +
           resultSet.getString(3)+ " " + resultSet.getString(4) + " " +
           resultSet.getInt(5));
        }
      System.out.println("\nCongratulations! You have successfully used Oracle Autonomous Database\n");
      } 
  } // End of doSQLWork
  
} // End of ADBQuickStart