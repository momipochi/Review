import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        HBox mainBox = new HBox();

        TextArea txtJul = new TextArea();
        TextArea txtRom = new TextArea();

        TextField chatJul = new TextField();
        TextField chatRom = new TextField();

        ScrollPane spJul = new ScrollPane();
        ScrollPane spRom = new ScrollPane();

        spJul.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        spJul.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        spRom.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        spRom.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        spJul.setContent(txtJul);
        spJul.setFitToHeight(true);
        spJul.setFitToWidth(true);
        spRom.setContent(txtRom);
        spRom.setFitToWidth(true);
        spRom.setFitToHeight(true);

        Button rombtn = new Button("Send");
        Button julbtn = new Button("Send");

        BorderPane romPane = new BorderPane();
        BorderPane julPane = new BorderPane();

        BorderPane botRom = new BorderPane();
        BorderPane botJul = new BorderPane();
        botRom.setCenter(chatRom);
        botRom.setRight(rombtn);
        botJul.setCenter(chatJul);
        botJul.setRight(julbtn);

        romPane.setCenter(spRom);
        romPane.setBottom(botRom);
        julPane.setCenter(spJul);
        julPane.setBottom(botJul);

        EventHandler<MouseEvent> handler = e->{
            if(e.getSource() == rombtn){
                txtJul.appendText("Romeo: "+chatRom.getText()+"\n");
                txtRom.appendText("Romeo: "+chatRom.getText()+"\n");
            }
            if(e.getSource() == julbtn){
                txtJul.appendText("Juliet: "+chatJul.getText()+"\n");
                txtRom.appendText("Juliet: "+chatJul.getText()+"\n");

            }
        };
        rombtn.addEventHandler(MouseEvent.MOUSE_PRESSED,handler);
        julbtn.addEventHandler(MouseEvent.MOUSE_PRESSED,handler);

        mainBox.getChildren().addAll(romPane,julPane);

        Scene scene = new Scene(mainBox,1200,600);
        stage.setTitle("chat");
        stage.setScene(scene);
        stage.show();
    }
}
