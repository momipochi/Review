import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    Main(){
        JPanel[] jp = new JPanel[3];
        for(int i = 0;i<jp.length;i++){
            jp[i]=new JPanel();
        }
        jp[0].setLayout(new GridLayout(0,4));
        jp[1].setLayout(new GridLayout(0,2));
        jp[2].setLayout(new GridLayout(0,4));

        for(int i = 1;i<=4;i++){
            jp[0].add(new JButton("0"+i));
        }

        jp[1].add(new JTextArea("jtextarea1"));

        JPanel jtfpanel = new JPanel();
        jtfpanel.setLayout(new GridLayout(3,0));
        for(int i = 1;i<=3;i++){
            jtfpanel.add(new JTextField("jtextfield"+i));
        }
        jp[1].add(jtfpanel);

        for(int i = 5;i<=8;i++){
            jp[2].add(new JButton("0"+i));
        }

        setLayout(new GridLayout(3,0));
        for(JPanel j : jp){
            add(j);
        }


        setSize(600,600);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);

    }
}
