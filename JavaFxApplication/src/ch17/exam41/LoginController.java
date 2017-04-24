
package ch17.exam41;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class LoginController implements Initializable {

	@FXML
	private BorderPane login;
	@FXML
	private Button btnMain;
	 
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		btnMain.setOnAction(e->handleBtnMain(e));
		
	}	
	private void handleBtnMain(ActionEvent e) {   //위에쌓여있는 '로그인.fxml' 인덱스를 제거하여 메인이 보이게 해줌
		//how1
		//RootController.rootPane.getChildren().remove(1);
		
		//how2
		StackPane rootPane = (StackPane)btnMain.getScene().getRoot();  //parent타입이나 사실은 stackpane으로 받아야하니 타입변환.
		rootPane.getChildren().remove(login);  
// 인덱스번호로 찝어서 지워줄수 있으나, 이러면 많이 쌓은 경우에는 콕찝어서 해줘야하는데 인덱스는 정해진것이 아니니 객체를 지정하여 제거해줘야한다. 위에서 @FXML에서 지정되어있으니 login을 찝어서 지워줄수있다.
	}
}
