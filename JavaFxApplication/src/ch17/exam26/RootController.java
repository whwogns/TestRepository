
package ch17.exam26;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.media.MediaView;

public class RootController implements Initializable {

    @FXML
    private MediaView mediaView;
    @FXML
    private Slider sliderPlay;
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

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<PieChart.Data> data1 = FXCollections.observableArrayList();
        data1.add(new PieChart.Data("AWT", 10));
        data1.add(new PieChart.Data("Swing", 10));
        data1.add(new PieChart.Data("SWT", 10));
        data1.add(new PieChart.Data("JavaFX", 10));
       // PieChart.setData(data1);  // pieChart에 data1을 데이터로 세팅시켜줌
         
        XYChart.Series<String, Integer> series1 = new XYChart.Series<>();   //시리즈 생성
        series1.setName("남자");
        ObservableList<XYChart.Data<String, Integer>> data2 = FXCollections.observableArrayList();
        data2.add(new XYChart.Data("2015", 70));
        data2.add(new XYChart.Data("2016", 40));
        data2.add(new XYChart.Data("2017", 50));
        data2.add(new XYChart.Data("2018", 30));
        series1.setData(data2);   //시리즈에 데이터 넣어주고
       // barChart.getData().add(series1);   // 차트에 시리즈넣어주고
        //AreaChart.getData().add(series1);   // bar차트두개에 중복된 데이터를 넣어줄순 없다. 
        
        
        
        
        XYChart.Series<String, Integer> series2 = new XYChart.Series<>();
        series2.setName("여자");
        ObservableList<XYChart.Data<String, Integer>> data3 = FXCollections.observableArrayList();
        data3.add(new XYChart.Data("2015", 30));
        data3.add(new XYChart.Data("2016", 60));
        data3.add(new XYChart.Data("2017", 50));
        data3.add(new XYChart.Data("2018", 60));
        series2.setData(data3);   //시리즈에 데이터 넣어주고
       // barChart.getData().add(series2);   // bar차트에 시리즈넣어주고
        
        
        
        
         XYChart.Series<String, Integer> series3 = new XYChart.Series<>();
        series3.setName("평균온도");
        ObservableList<XYChart.Data<String, Integer>> data4 = FXCollections.observableArrayList();
        data4.add(new XYChart.Data("2015", 13));
        data4.add(new XYChart.Data("2016", 6));
        data4.add(new XYChart.Data("2017", 22));
        data4.add(new XYChart.Data("2018", 15));
        series3.setData(data4);   //시리즈에 데이터 넣어주고
       //AreaChart.getData().add(series3);   //  Area차트에 시리즈넣어주고
        
        XYChart.Series<String, Integer> series4 = new XYChart.Series<>();
        series4.setName("평균속도");
        ObservableList<XYChart.Data<String, Integer>> data5 = FXCollections.observableArrayList();
        data5.add(new XYChart.Data("2015", 11));
        data5.add(new XYChart.Data("2016", 1));
        data5.add(new XYChart.Data("2017", 44));
        data5.add(new XYChart.Data("2018", 55));
        series4.setData(data5);   //시리즈에 데이터 넣어주고
       // AreaChart.getData().add(series4);   // Area차트에 시리즈넣어주고
    }    
    
}
