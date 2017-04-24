package ch17.exam13.exam;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class RootController implements Initializable{
    
    @FXML private Button btn4;
    @FXML private Button btn5;
    @FXML private Button btn6;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btn4.setOnAction((event) -> {
            System.out.println("버튼 4가 클릭됨.");
        });
        
        
        
    }

    
    
    
}
