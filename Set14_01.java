import javax.swing.*;
import java.awt.*;

public class SnowMan extends JPanel{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->createGUI());
    }
    private static void createGUI(){
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        SnowMan sm = new SnowMan();

        jf.add(sm, BorderLayout.CENTER);
        jf.setSize(600,600);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.blue);
        g.setColor(Color.white);
        int w = getWidth();
        int h = getHeight();

        g.fillOval(w/2-h/12,0,h/6,h/6);
        g.fillOval(w/2-h/6,h/6,h/3,h/3);
        g.fillOval(w/2-h/4,h/2,h/2,h/2);
    }
}
