package ch17.exam13;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
       
        Parent parent = FXMLLoader.load(AppMain.class.getResource("root.fxml")); 
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("AppMain");//창제목.
        
        primaryStage.setOnCloseRequest(event -> {  // 종료버튼x 누르면 이벤트가 나오게끔 처리하려면 stage에서 해야하므로 여기서 코드 작성.
            System.out.println("close...");
        });
       
        
        primaryStage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);  //start가 자동으로 실행됨
    }
    

}
