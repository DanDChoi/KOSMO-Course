class Figure {
    void draw(){
        System.out.println("������ �׸���");
    }
}
class Circle extends Figure{
    void draw(){
        System.out.println("������ �׸���");
    }
}
class Square extends Figure{
    void draw(){
        System.out.println("�簢���� �׸���");
    }
}
class Tri extends Figure{
    void draw(){
        System.out.println("�ﰢ���� �׸���"); 
    }
}

class B{
    public static void main(String[] args){
        Figure f1 = new Figure();
        f1.draw();
        Figure f2 = new Circle();
        f2.draw();
        Figure f3 = new Square();
        f3.draw();
        Figure f4 = new Tri();
        f4.draw();
    }
}