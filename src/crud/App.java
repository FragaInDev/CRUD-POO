package crud;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application{

    @Override
    public void start(Stage stage) throws Exception {

        GridPane tp = new GridPane();
        Button btnTest = new Button("CRUD Especialidade");
        tp.add(btnTest, 0, 0);


        
        stage.setScene(new Scene(tp, 800,600));
        stage.show();
    }

    public static void main(String[] args) throws Exception {
        Application.launch(App.class, args);
    }
}
