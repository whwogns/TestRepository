
package ch17.exam39;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Service;
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
	private Label lblWorkDone;
	@FXML
	private Label lblResult;
	@FXML
	private Button btnStart;
	@FXML
	private Button btnStop;
	
	private TimeService timeService;

	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		btnStart.setOnAction(e->handleBtnStart(e));
		btnStop.setOnAction(e->handleBtnStop(e));
	}	

	private void handleBtnStart(ActionEvent e) {
		if(timeService == null){
			timeService = new TimeService();
			timeService.start(); //타임서비스는 내부적으로 스래드가 이미 있기때문에 바로 스타트하면됨.    //이 스래드는 javafx application 스래드임.
		}else{
			timeService.restart(); // 새로 작업만들어줄필요없이 바로 재시작가능
		}
	}

	private void handleBtnStop(ActionEvent e) {
		timeService.cancel();
	}
	
	class TimeService extends Service<Integer>{

		@Override
		protected Task<Integer> createTask() {
			Task<Integer> task = new Task<Integer>(){
				@Override
				protected Integer call() throws Exception {//TASK 재정의    //task가 실행되면 알아서 call이 실행되는 것이고 이는 "작업스래드"가 작업함.
					int sum = 0;
									for(int i=1; i<=100; i++){
										sum+=i;
										if(isCancelled()){break;}   // if문 없으면 작업 1~100까지 진행할동안 빠져나올수없음.
										try{ Thread.sleep(100);}catch(Exception e){}
										int value = i;
										Platform.runLater(()->{
											progressBar.setProgress(value/100.0);     //익명개체안에 로컬변수면 파이널 특성이므로 재정의 안에 다시 value를 지정해줌      // 100.0 해야함. 더블값이므로.
											lblWorkDone.setText(String.valueOf(value));
										});
										
									}
									return sum;
				}
				
			}; 
			return task;
		}

		@Override
		protected void succeeded() {   //작업완료되면 succeeded가 실행됨. javafx application스래드가 실행함.
			lblResult.setText(String.valueOf(getValue()));
		}
		
	
	  
	}
}
