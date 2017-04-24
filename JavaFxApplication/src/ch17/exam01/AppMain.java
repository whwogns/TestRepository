package ch17.exam01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class AppMain extends Application {
    public AppMain(){
            System.out.println("Constructor");
    }
    
    
   
    @Override
    public void start(Stage stage) throws Exception {
        
        VBox vBox = new VBox();    //vBox의 역할은 컨트롤들을 배치시키는 것으로 컨테이너 중 하나임.
        vBox.setPrefSize(400,300);
       
        
        Label label = new Label();
        label.setText("Hello,javaFX");
        vBox.getChildren().add(label);  // getChildren 은 list 므로 
        
        Button botton = new Button();
        botton.setText("확인");
        vBox.getChildren().add(botton);
        
       Scene scene = new Scene(vBox);
       stage.setScene(scene);
       stage.show();
    }
    

    public static void main(String[] args) {
        launch(args);
       
    }

     
}
