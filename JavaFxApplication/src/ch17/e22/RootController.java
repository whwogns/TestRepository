package ch17.e22;

import java.net.URL;
import java.util.ResourceBundle;
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
  
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        
        mediaView.setMediaPlayer(mediaPlayer);
 
        mediaPlayer.setOnReady(()->{
            btnPlay.setDisable(false);
            btnPause.setDisable(true);
            btnStop.setDisable(true);
            labelTime.setText(0+"/"+(int)mediaPlayer.getTotalDuration().toSeconds()+"sec");
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
            endOfMedia = true;
            btnPlay.setDisable(false);
            btnPause.setDisable(true);
            btnStop.setDisable(true);
            progressBar.setProgress(1.0);
            progressIndicator.setProgress(1.0);
        });
        
        btnPlay.setOnAction(e-> {
      
            if(endOfMedia){
                mediaPlayer.stop();
                mediaPlayer.seek(mediaPlayer.getStartTime());
            }
            mediaPlayer.play();
            endOfMedia = false; 
         });
        btnPause.setOnAction(e->mediaPlayer.pause());
        btnStop.setOnAction(e->mediaPlayer.stop());
        
        
      
        sliderVolume.valueProperty().addListener(new ChangeListener<Number> () {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                mediaPlayer.setVolume(newValue.doubleValue()/100.0);
             }
         });
        sliderVolume.setValue(50);
        
        mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                double progress = newValue.toSeconds() / mediaPlayer.getTotalDuration().toSeconds();
                progressBar.setProgress(progress);
                progressIndicator.setProgress(progress);
                labelTime.setText((int)newValue.toSeconds()+"/"+(int)mediaPlayer.getTotalDuration().toSeconds()+"sec");
                sliderPlay.setValue(newValue.toSeconds()/mediaPlayer.getTotalDuration().toSeconds()*100);
            }
        });
        
        
        
        
        
        
        
        sliderPlay.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    Duration d = Duration.seconds(mediaPlayer.getTotalDuration().toSeconds()/100*newValue.doubleValue());
                    if(sliderPlay.isValueChanging()){
                        mediaPlayer.seek(d);
                    }else{
                        if(Math.abs(oldValue.doubleValue() - newValue.doubleValue())>0.5){
                            mediaPlayer.seek(d);
                        }
                    }
            }
        });
       
    }    
    
}
