import javax.swing.*;
import java.awt.*;

class MainPanel extends JPanel{
    JSlider js;
    MainPanel(JSlider js){
        this.js=js;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();

        int val = js.getValue();
        int side = (int)(Math.min(w,h)*val/100.0);

        g.fillRect((w-side)/2,(h-side)/2,side,side);
        this.repaint();
    }
}

public class Main extends JFrame{
    JSlider js;
    Main(){
        js = new JSlider(JSlider.HORIZONTAL,0,100,80);
        MainPanel mp = new MainPanel(js);
        js.setPaintLabels(true);
        js.setPaintTicks(true);
        js.setMajorTickSpacing(20);

        js.setBorder(BorderFactory.createTitledBorder("size of square"));
        add(mp,BorderLayout.CENTER);
        add(js,BorderLayout.SOUTH);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600,600));
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
