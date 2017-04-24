
package ch17.exam42;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

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
	
			StackPane rootPane = (StackPane)btnMain.getScene().getRoot();  //parent타입이나 사실은 stackpane으로 받아야하니 타입변환.
			
			login.setOpacity(1);   //이코드로 투명하게 할수있다.

			login.setTranslateX(0);  //x좌표 350만큼 이동시킴. 보더페인 width가 350이므로 이동시키면 프래임밖으로 사라진꼴.   //초기값 0
			
			//KeyValue keyValue = new KeyValue(login.translateXProperty(), 350);   // translateX값을 0초기값에서 350종료값으로 바꿈.   
			KeyValue keyValue = new KeyValue(login.opacityProperty(), 0);
			KeyFrame keyFrame = new KeyFrame(Duration.millis(1000),(event)->{rootPane.getChildren().remove(login);} , keyValue);  // 애니메이션 진행시간 0.1     
			// remove를 시켜줄때 끝나는 시점을 알수없으므로 이벤트처리를 통해해줌. {  ,여기서이벤트처리,  }  //에니메이션이 종료할때 무언갈 하겠다 할때 이렇게 설정하면됨.
			Timeline timeline = new Timeline();
			timeline.getKeyFrames().add(keyFrame);
			timeline.play();
	}
}
