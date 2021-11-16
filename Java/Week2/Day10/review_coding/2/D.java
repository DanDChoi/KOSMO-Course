class D{
    int sum(int i, int j){
        return i+j;
    }
}

class DUser {
    public static void main(String[] args){
        int result = new D().sum(100,200);
        System.out.println("result: "+result);
    }
}