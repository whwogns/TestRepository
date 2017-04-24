
package ch17.exam42;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;


public class RootController implements Initializable {

	@FXML
	private Button btnLogin;
	@FXML
	private StackPane stackpane;
	
	public static StackPane rootPane;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		btnLogin.setOnAction(e->handleBtnLogin(e));
		rootPane=stackpane;
			
		
	}	

	private void handleBtnLogin(ActionEvent e) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("login.fxml"));
			stackpane.getChildren().add(parent);
			
			//애니메이션
			
			parent.setTranslateX(350);  //x좌표 350만큼 이동시킴. 보더페인 width가 350이므로 이동시키면 프래임밖으로 사라진꼴.   //초기값 350
			
			KeyValue keyValue = new KeyValue(parent.translateXProperty(), 0);   // translateX값을 350초기값에서 0종료값으로 바꿈.   
			KeyFrame keyFrame = new KeyFrame(Duration.millis(100), keyValue);  // 애니메이션 진행시간 0.1
			Timeline timeline = new Timeline();
			timeline.getKeyFrames().add(keyFrame);
			timeline.play();
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
	
}
