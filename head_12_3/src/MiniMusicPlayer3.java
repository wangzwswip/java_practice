import javax.sound.midi.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class MiniMusicPlayer3 {
    static JFrame f = new JFrame("My First Music Video");
    static MyDrawPanel ml;

    public static void main(String[] args) {
        MiniMusicPlayer3 mini = new MiniMusicPlayer3();
        mini.go;
    }//关闭方法

    public void setUpGui() {
        ml = new MyDrawPanel();
    }

    class MyDrawPanel extends JPanel implements ControllerEventListener{
        boolean msg = false;

        public void controlChange(ShortMessage event) {
            msg = true;
            repaint();
        }
        public void paintComponent(Graphics g) {
            if (msg) {
                Graphics2D g2 = (Graphics2D) g;
                int r = (int) (Math.random()*250);
                int gr = (int) (Math.random()*250);
                int b = (int) (Math.random()*250);

                g.setColor(new Color(r,gr,b));

                int ht = (int) ((Math.random()*120)+10);
                int width = (int) ((Math.random()*120)+10);

                int x = (int) ((Math.random()*40)+10);
                int y = (int) ((Math.random()*40)+10);

                g.fillRect(x,y,ht,width);
                msg = false;
            }//close if
        }//close method
    }//close inside class
}// close class
