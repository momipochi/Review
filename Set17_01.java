import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;

class Person{
    private String name;
    private int count;
    private Label l;
    Person(String n, Label l){
        name=n;
        count=0;
        this.l=l;
    }
    int getScore(){return this.count;}
    void increaseScore(){ this.count++; }
    void decreaseScore(){ this.count--; }
}

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button addBea = new Button("+");
        Button minBea = new Button("-");
        Label beaLabel = new Label("Beatrice");
        beaLabel.setRotate(90);

        Button addAli = new Button("+");
        Button minAli = new Button("-");
        Label aliLabel = new Label("Alice");
        aliLabel.setRotate(90);

        Button addAll = new Button("+1 all");
        Button minAll = new Button("-1 all");
        Label ave = new Label("Ave->");
        Label tot = new Label("Tot->");
        ave.setRotate(90);
        tot.setRotate(90);

        Label aliBot = new Label("Alice: 0");
        Label beaBot = new Label("Beatrice: 0");

        GridPane root = new GridPane();
        root.add(addAli,1,0,1,1);
        root.add(minAli,1,4,1,1);
        root.add(aliLabel,1,2);

        root.add(addBea,2,0,1,1);
        root.add(minBea,2,4,1,1);
        root.add(beaLabel,2,2);

        root.add(addAll,3,0,2,1);
        root.add(minAll,3,4,2,1);
        root.add(tot,3,2);
        root.add(ave,4,2);

        root.add(beaBot,3,5,2,1);
        root.add(aliBot,1,5,2,1);

        root.setPadding(new Insets(4));
        root.setHgap(10);
        root.setVgap(10);

        GridPane.setHalignment(addAli,HPos.CENTER);
        GridPane.setHalignment(minAli,HPos.CENTER);

        GridPane.setHalignment(addBea,HPos.CENTER);
        GridPane.setHalignment(minBea,HPos.CENTER);

        GridPane.setHalignment(addAll,HPos.CENTER);
        GridPane.setHalignment(minAll,HPos.CENTER);

        Person alice = new Person("Alice", aliLabel);
        Person beatrice = new Person("Beatrice",beaLabel);
        EventHandler<MouseEvent> handler = e->{
            if(e.getSource() == addAli){
                alice.increaseScore();
                aliBot.setText("Alice:"+alice.getScore()+";");
                double sum = alice.getScore()+beatrice.getScore();
                tot.setText("Tot->"+sum);
                ave.setText("Ave->"+sum/2);
            }
            if(e.getSource() == minAli){
                alice.decreaseScore();
                aliBot.setText("Alice:"+alice.getScore()+";");
                double sum = alice.getScore()+beatrice.getScore();
                tot.setText("Tot->"+sum);
                ave.setText("Ave->"+sum/2);
            }
            if(e.getSource() == addBea){
                beatrice.increaseScore();
                beaBot.setText("Beatrice:"+beatrice.getScore()+";");
                double sum = alice.getScore()+beatrice.getScore();
                tot.setText("Tot->"+sum);
                ave.setText("Ave->"+sum/2);
            }
            if(e.getSource() == minBea){
                beatrice.decreaseScore();
                beaBot.setText("Beatrice:"+beatrice.getScore()+";");
                double sum = alice.getScore()+beatrice.getScore();
                tot.setText("Tot->"+sum);
                ave.setText("Ave->"+sum/2);
            }
            if(e.getSource() == addAll){
                alice.increaseScore();
                beatrice.increaseScore();
                aliBot.setText("Alice:"+alice.getScore()+";");
                beaBot.setText("Beatrice:"+beatrice.getScore()+";");
                double sum = alice.getScore()+beatrice.getScore();
                tot.setText("Tot->"+sum);
                ave.setText("Ave->"+sum/2);
            }
            if(e.getSource() == minAll){
                alice.decreaseScore();
                beatrice.decreaseScore();
                aliBot.setText("Alice:"+alice.getScore()+";");
                beaBot.setText("Beatrice:"+beatrice.getScore()+";");
                double sum = alice.getScore()+beatrice.getScore();
                tot.setText("Tot->"+sum);
                ave.setText("Ave->"+sum/2);
            }
        };

        addAli.addEventHandler(MouseEvent.MOUSE_PRESSED,handler);
        minAli.addEventHandler(MouseEvent.MOUSE_PRESSED,handler);
        addBea.addEventHandler(MouseEvent.MOUSE_PRESSED,handler);
        minBea.addEventHandler(MouseEvent.MOUSE_PRESSED,handler);
        addAll.addEventHandler(MouseEvent.MOUSE_PRESSED,handler);
        minAll.addEventHandler(MouseEvent.MOUSE_PRESSED,handler);

        Scene scene = new Scene(root,450,200);
        stage.setTitle("Counter");
        stage.setScene(scene);
        stage.show();
    }
}
