
package ch17.exam27;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class RootController implements Initializable {

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("새로만들기 클릭됨.");
    }    

    @FXML
    private void menuItemNew(ActionEvent event) {
        System.out.println("새로만들기 클릭됨.");
    }
    
}
