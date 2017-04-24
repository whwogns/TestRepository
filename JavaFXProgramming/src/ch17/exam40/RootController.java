
package ch17.exam40;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class RootController implements Initializable {

	@FXML
	private Button btnLogin;
	@FXML
	private StackPane stackpane;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		btnLogin.setOnAction(e->handleBtnLogin(e));
		
	}	

	private void handleBtnLogin(ActionEvent e) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("login.fxml"));
			stackpane.getChildren().add(parent);    //스택패인을 fxid로불러와서 login.fxml을 로딩한 스택패인(보더패인을 포함한)을 하나더 그위에 쌓을 수 있다.
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
	
}
