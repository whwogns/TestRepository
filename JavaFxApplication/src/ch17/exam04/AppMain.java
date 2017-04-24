package ch17.exam04;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
       
        Parent parent = FXMLLoader.load(AppMain.class.getResource("root.fxml"));   //   getClass() = AppMain.class
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);  //start가 자동으로 실행됨
    }
    

}
