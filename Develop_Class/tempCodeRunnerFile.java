Connection conn = null; 


Class.forName("oracle.jdbc.driver.OracleDriver");


conn = DriverManager.getConnection("jdbc:oracle:thin:@db01_high?TNS_ADMIN=/Users/Dan/Desktop/Develop/Develop_Class/Oracle/Wallet_DB01","admin","Dandatabase01");



conn.close();
