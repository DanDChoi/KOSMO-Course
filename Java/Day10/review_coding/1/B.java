class Figure {
    void draw(){
        System.out.println("도형을 그리다");
    }
}
class Circle extends Figure{
    void draw(){
        System.out.println("원형을 그리다");
    }
}
class Square extends Figure{
    void draw(){
        System.out.println("사각형을 그리다");
    }
}
class Tri extends Figure{
    void draw(){
        System.out.println("삼각형을 그리다"); 
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