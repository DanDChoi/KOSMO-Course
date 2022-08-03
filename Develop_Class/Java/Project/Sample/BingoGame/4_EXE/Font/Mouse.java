import java.awt.*;
import javax.swing.*;
public class DefinedCursor extends JFrame {
    Cursor cursor;
    Image img;
   
    public DefinedCursor(){
        super("User Defined Cursor");
       
        Toolkit tk = Toolkit.getDefaultToolkit();
        img = tk.getImage("image\\pikachu.png");
        Point point = new Point(0,0);
        cursor = tk.createCustomCursor(img,point,"pikachu");
        setCursor(cursor);
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,300);
        setVisible(true);
    }
    public static void main(String args[]){
        new DefinedCursor();
    }
}