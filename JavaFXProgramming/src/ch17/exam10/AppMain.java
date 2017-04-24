package ch17.exam10;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
       
        Parent parent = FXMLLoader.load(AppMain.class.getResource("root.fxml"));   //   AnchorPane객체가 생성되어 이것으로 scene생성
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("AppMain");//창제목.
        primaryStage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);  //start가 자동으로 실행됨
    }
    

}
