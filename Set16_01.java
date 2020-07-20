import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

enum Size{XS,S,M,L,XL}
class Person{
    String name;
    int h,w;
    Size s;
    Person(String n,int h, int w, Size s){
        this.name = n;
        this.h=h;
        this.w=w;
        this.s=s;
    }
    public JLabel getLb(){
        JLabel jb = new JLabel();
        jb.setText(name+" (h="+h+",w="+w+",size="+s);
        jb.setOpaque(true);
        if(s == Size.XS){
            jb.setBackground(Color.green);
        }
        if(s == Size.XL){
            jb.setBackground(Color.red);
        }
        return jb;
    }

}
class MainFrame extends JFrame implements ActionListener{
    JList<Person> jl;
    JSlider hSlider,wSlider;
    JLabel nameLabel,sizeLabel;
    JTextField enterName;
    JComboBox<Size> sizeComboBox;
    JButton addButton,exitButton;
    JScrollPane jsp;
    DefaultListModel<Person> jModel;
    MainFrame(){
        jModel = new DefaultListModel<>();
        jl = new JList<>(jModel);
        jl.setCellRenderer(new ListCellRenderer<Person>() {
            @Override
            public Component getListCellRendererComponent(JList<? extends Person> list, Person value, int index, boolean isSelected, boolean cellHasFocus) {
                return value.getLb();
            }
        });

        jsp = new JScrollPane(jl);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        hSlider = new JSlider(100,200,160);
        hSlider.setMajorTickSpacing(10);
        hSlider.setPaintTicks(true);
        hSlider.setPaintLabels(true);
        hSlider.setBorder(BorderFactory.createTitledBorder("Height[cm]"));

        wSlider = new JSlider(40,120,55);
        wSlider.setMajorTickSpacing(10);
        wSlider.setPaintTicks(true);
        wSlider.setPaintLabels(true);
        wSlider.setBorder(BorderFactory.createTitledBorder("Weight[kg]"));

        nameLabel = new JLabel("name:");
        sizeLabel = new JLabel("size:");

        enterName = new JTextField();
        enterName.setPreferredSize(new Dimension(100,20));

        sizeComboBox = new JComboBox<>(Size.values());

        addButton = new JButton("Add person");
        addButton.addActionListener(this);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);


        JPanel personPanel = new JPanel();
        personPanel.add(nameLabel);
        personPanel.add(enterName);
        personPanel.add(sizeLabel);
        personPanel.add(sizeComboBox);
        personPanel.add(Box.createHorizontalStrut(10));
        personPanel.add(addButton);
        personPanel.add(Box.createHorizontalStrut(30));
        personPanel.add(exitButton);

        JPanel attributeComp = new JPanel();
        attributeComp.setLayout(new GridLayout(3,1));
        attributeComp.add(hSlider);
        attributeComp.add(wSlider);
        attributeComp.add(personPanel);

        add(jsp);
        add(attributeComp,BorderLayout.SOUTH);

        pack();
        setPreferredSize(new Dimension(600,600));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jb = (JButton)e.getSource();
        if(addButton == jb){
            String name = enterName.getText();
            int h = hSlider.getValue();
            int w = wSlider.getValue();
            Size s = (Size)sizeComboBox.getSelectedItem();
            jModel.addElement(new Person(name,h,w,s));
        }else{
            System.exit(0);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
