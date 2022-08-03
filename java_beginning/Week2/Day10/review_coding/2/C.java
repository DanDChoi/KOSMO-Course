class Account {
    private String ssn = "123456-1234567";
    private long balance = 10000L;
     
    void setSsn(String ssn){ 
        this.ssn = ssn;
    }
    String getSsn(){ 
        return ssn;
    }
    void setBalance(long balance){ 
        this.balance = balance;
    }
    long getBalance(){ 
        return balance;
    }
 }
 
 class Banker {
     public static void main(String[] args){
         Account a = new Account();
         System.out.println("1)╟Хабаж: "+ a.getSsn());
         System.out.println("1)юэ╬в: "+ a.getBalance());
     
         a.setSsn("123456-2234567");
         a.setBalance(20000L);
         System.out.println("2)╟Хабаж: "+a.getSsn());
         System.out.println("2)юэ╬в :"+a.getBalance());
     }
 }