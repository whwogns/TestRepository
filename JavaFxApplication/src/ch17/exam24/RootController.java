
package ch17.exam24;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


public class RootController implements Initializable {

    @FXML
    private MediaView mediaView;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnPause;
    @FXML
    private Button btnStop;
    
    
    private boolean endOfMedia;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        Media media = new Media(getClass().getResource("media/video.m4v").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);//음악파일이라면 이 코드는 필요없다.
        
        mediaPlayer.setOnReady(()->{
            btnPlay.setDisable(false);
            btnPause.setDisable(true);
            btnStop.setDisable(true);
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
        });
         
        
        btnPlay.setOnAction(event->{
             if(endOfMedia){
                 mediaPlayer.stop();
                 mediaPlayer.seek(mediaPlayer.getStartTime());
             }   
                
                mediaPlayer.play();
                endOfMedia=false; 
    });
        btnPause.setOnAction(event->mediaPlayer.pause());
        btnStop.setOnAction(event->mediaPlayer.stop());
    }    
    
}
