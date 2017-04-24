
package ch17.exam25;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;


public class RootController implements Initializable {

    @FXML
    private MediaView mediaView;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnPause;
    @FXML
    private Button btnStop;
    @FXML
    private Slider sliderVolume;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private ProgressIndicator progressIndicator;
    @FXML
    private Label labelTime;

    private boolean endOfMedia;
    @FXML
    private Slider sliderPlay;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
       
        Media media = new Media(getClass().getResource("media/video.m4v").toString());
       // Media media = new Media(getClass().getResource("media/audio.wav").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);//음악파일이라면 이 코드는 필요없다. 근데 있어도 상관 없다.
        
        mediaPlayer.setOnReady(()->{
            btnPlay.setDisable(false);
            btnPause.setDisable(true);
            btnStop.setDisable(true);
            labelTime.setText( "0 /"+ (int)mediaPlayer.getTotalDuration().toSeconds() +"초");   // 음악파일이 준비상태가 되었을때 0으로 디폴트 시켜주는것임.
        });
        
        mediaPlayer.setOnPlaying(()->{
            btnPlay.setDisable(true);
            btnPause.setDisable(false);
            btnStop.setDisable(false);
        });
        
        mediaPlayer.setOnPaused(()->{
            btnPlay.setDisable(false); 
            btnPause.setDisable(true); 
            btnStop.setDisable(false);
        });
        
         mediaPlayer.setOnStopped(()->{  
            btnPlay.setDisable(false); 
            btnPause.setDisable(true); 
            btnStop.setDisable(true);
        });
         
          mediaPlayer.setOnEndOfMedia(()->{ 
              //stop과 차이 있음 스탑은 재생버튼 누르면 다시 처음부터 재생되지만 엔드오브 미디어상태에서 재생해도 다시 첨부터 안됨. 그래서 if문을 넣어주어 별도로 설정해서 재생 완료후 처음부터 재생되도록 설정해주어야 한다.
            endOfMedia=true;  //
            btnPlay.setDisable(false); 
            btnPause.setDisable(true); 
            btnStop.setDisable(true);
            progressBar.setProgress(1.0);    //
            progressIndicator.setProgress(1.0);  // 이 두 코드가 들어가야 endofmedia상태에서 프로그레스인디케이터에 완료메세지가 뜬다.   
        });
         
          
          
        
        btnPlay.setOnAction(event->{      ///  1. 플레이버튼설정
             if(endOfMedia){
                 mediaPlayer.stop();
                 mediaPlayer.seek(mediaPlayer.getStartTime());
             }   
                
                mediaPlayer.play();
                endOfMedia=false; 
    });
         
        btnPause.setOnAction(event->mediaPlayer.pause());   /// 2. 일시정지버튼 설정
        btnStop.setOnAction(event->mediaPlayer.stop());        //// 3. 중단버튼 설정
        
        
         sliderPlay.valueProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                 mediaPlayer.seek(Duration.seconds(newValue.doubleValue()));
                 
            }
         
         });
                 
      // sliderPlay.valueProperty().bind(mediaView.mediaPlayerProperty());
      // Bindings.bindBidirectional(sliderPlay.valueProperty(),mediaView.mediaPlayerProperty());
       
                
        
        sliderVolume.valueProperty().addListener(new ChangeListener<Number>(){        /// 슬라이더 바에 따라 볼륨설정 해주도록 함.
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
               
                mediaPlayer.setVolume(newValue.doubleValue()/100.0);  // 뉴밸류값은 1~100이고 셋볼륨의 값은 0~1이므로 100나눠즘.
            }
        
        });
        sliderVolume.setValue(50);   //볼륨값 디폴트 50으로 맞춰줌.
        
        
        
        mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>(){     // 현재시간에 따라 프로그레스바와 프로그래스 인디케이터 변화하도록 속성감시시켜줌.
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                //System.out.println(newValue.toSeconds());
                double progress = newValue.toSeconds() / mediaPlayer.getTotalDuration().toSeconds();
                
                progressBar.setProgress(progress);
                progressIndicator.setProgress(progress);
                labelTime.setText((int) newValue.toSeconds()+"/"+ (int)mediaPlayer.getTotalDuration().toSeconds() +"초");
              
            }
        });
    }    
    
}
