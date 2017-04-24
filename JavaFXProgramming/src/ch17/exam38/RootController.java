
package ch17.exam38;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;


public class RootController implements Initializable {

	@FXML
	private ProgressBar progressBar;
	@FXML
	private Label label;
	@FXML
	private Label lblWorkDone;
	@FXML
	private Button btnStart;
	@FXML
	private Button btnStop;

	@FXML
	private Label lblResult;
	

	
	private Task<Integer> task;
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		btnStart.setOnAction(e->handleBtnStart(e));
		btnStop.setOnAction(e->handleBtnStop(e));
	}	

	private void handleBtnStart(ActionEvent e) {
		task = new Task<Integer>(){
			@Override
			protected Integer call() throws Exception {      ///call에서는 ui변경코드 작성할 수 없다.
				int result = 0;
				for(int i=0;i<=100;i++){
					result+=i;
					
					//how1
					//updateProgress(i, 100);    /// 업데이트프로그레스는 태스크에 있는 메소드 / 프로그레스바 수정 설정  (수정할값, 맥스값)
					//updateMessage(String.valueOf(i)); // 현재값을 변경하겠다는것                       //1. 작업스래드가 작업실행중에는 이와같은 메소드를 주고 속성바인딩을 통해 ui변경가능.  딱 두메소드밖에없다.   2. 혹은 platform.runLater를 사용
					
					//how2
					double value = i;  //i가 final이므로.
					Platform.runLater(()->{
						progressBar.setProgress(value/100);     //value를 100으로 나눠주는 이유는  setProgress의 범위가 0~1이므로.
						lblWorkDone.setText(String.valueOf(value));
					});
						
					if(isCancelled()){ break;}
					try{Thread.sleep(100);}catch(Exception e){
						break;
					}
				}
				return result;
			}// 위의 작업은 작업스래드가 실시함.
		

			@Override
			protected void succeeded() {
				int result = getValue();
				lblResult.setText(String.valueOf(result));     //여기선 자바fx application스래드가 실행하기 때문에 ui변경(라벨텍스트 변경) 할수있다.   //succeeded cancelled failed모두 javafx application스래드 므로 유아이변경가능
			}

			@Override
			protected void cancelled() {
				lblResult.setText("자바취소");
			}

			

			@Override
			protected void failed() {
			
			}
			
		};   
		
		//how2
		//progressBar.progressProperty().bind(task.progressProperty());    //단방향 속성바인딩. 태스크의 속성이 변하면 프로그레스 속성이 변한다.       // 이와 같은 ui 변경은 javafx application thread 가 돌림
		//lblWorkDone.textProperty().bind(task.messageProperty());
		
		Thread thread = new Thread(task);
		thread.setDaemon(true);
		thread.start();
	}

	private void handleBtnStop(ActionEvent e) {
		task.cancel();
	}
	
}
