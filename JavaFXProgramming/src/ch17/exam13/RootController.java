package ch17.exam13;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class RootController implements Initializable {

    @FXML
    private Button btn1;    // root에서 버튼객체를 가져온것임.   
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;

    @Override
    public void initialize(URL location, ResourceBundle resources) {    //자동으로 객체가 생겼으니 실행된다.

        //how1   익명개체
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("버튼1이 클릭됨");
            }
        });

        //how2   람다식
        btn2.setOnAction(event -> {
            System.out.println("버튼2가 클릭됨");
        });

    }

    //how3
    public void btn3Handle(ActionEvent event) {
        System.out.println("버튼3이 클릭됨");
    }

    //이와 같은 컨트롤 설정이 이벤트처리에서 가장 좋다. 모든 이벤트처리에 쓰임
}
    
   
    

