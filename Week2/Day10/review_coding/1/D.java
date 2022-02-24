class D{
    int sum(int i, int j){
        return i+j;
    }
}

class DUser{
    public static void main(String[] args){
        int result = new D().sum(10,20);
        System.out.println("result: "+result);
    }
}