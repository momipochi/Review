import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class MainFrame extends Thread{
    private JLabel jl;
    private int count;
    private int ind;
    private boolean stopped;
    private JButton jb;
    MainFrame(JButton jb, int ind){
        count = 0;
        jl = new JLabel(count+"");
        this.jb=jb;
        this.ind=ind;
        stopped=false;
        this.start();
    }
    public JButton getJb(){return this.jb;}
    public JLabel getJl(){return this.jl;}
    synchronized void zawarudo(){this.stopped=true; this.jb.setText("Thread "+ind+" resume");}
    synchronized void nozawarudo(){this.stopped=false; this.jb.setText("Thread "+ind+" suspend"); notify();}

    @Override
    public void run() {
        while(true){
            try{
                while(stopped){
                    synchronized (this){
                        wait();
                    }
                }
                SwingUtilities.invokeLater(()->jl.setText(count+""));
                count++;
                Thread.sleep((int)(Math.random()*1000)+10);
            }catch(InterruptedException e){
                return;
            }
        }
    }
    void check(){
        if(!this.stopped){
            zawarudo();
        }else{
            nozawarudo();
        }
    }
}
public class Main extends JFrame implements ActionListener{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->new Main(4));
    }

    List<MainFrame> lmf;
    public Main(int bb){
        lmf = new ArrayList<>();
        for(int i = 0;i<bb;i++){
            lmf.add(new MainFrame(new JButton("Thread "+(i+1)+" suspend"),i));
            lmf.get(i).getJb().addActionListener(this);
        }
        System.out.println(lmf.get(0).getJl().getText());
        setLayout(new GridLayout(2,bb));
        for(int i = 0;i<bb;i++){
            add(lmf.get(i).getJl());
        }
        for(int i = 0;i<bb;i++){
            add(lmf.get(i).getJb());
        }

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jbn = (JButton)e.getSource();
        for(MainFrame mf:lmf){
            if(jbn == mf.getJb()){
                mf.check();
            }
        }
    }
}
