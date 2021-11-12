class Account {
   private String ssn = "123456-1234567";
   private long balance = 10000L;
    /*
   void setSsn(String ssn){ //setter 메소드
       this.ssn = ssn;
   }*/
   String getSsn(){ //getter 메소드
       return ssn;
   }
   void setBalance(long balance){ //setter 메소드
       this.balance = balance;
   }
   long getBalance(){ //getter 메소드
       return balance;
   }
}

class Banker {
    public static void main(String[] args){
        Account a = new Account();
        System.out.println("1)계좌주: "+ a.getSsn());
        System.out.println("1)잔액: "+ a.getBalance());
    
        //a.setSsn("123456-2234567");//불가능!
        a.setBalance(20000L);
        System.out.println("2)계좌주: "+a.getSsn());
        System.out.println("2)잔액 :"+a.getBalance());
    }
}