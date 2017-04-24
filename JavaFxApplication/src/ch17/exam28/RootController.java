/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch17.exam28;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;




public class RootController implements Initializable {
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    //how1
    @FXML
    private void handleOpenFileChooser(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(AppMain.primaryStage);    //appmain에서 스태틱 필드로 선언하여 불러오는 방법이 있다.
        System.out.println(file.getPath());
    }

 
    @FXML
    private void handleSaveFileChooser(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(((Button) event.getSource()).getScene().getWindow());
        System.out.println(file.getPath());
    }

    @FXML
    private void handleDirectoryChooser(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File file = directoryChooser.showDialog(((Button) event.getSource()).getScene().getWindow());
        System.out.println(file.getPath());
    }

    @FXML
    private void handlePopUpChooser(ActionEvent event) throws Exception {
//        Popup popup = new Popup();
//        HBox hbox = (HBox)FXMLLoader.load(getClass().getResource("popup.fxml"));
//        ImageView imgMessage = (ImageView)hbox.lookup("#imgMessage");
//        Label lblMessage = (Label)hbox.lookup("#lblMessage");
//        popup.getContent().add(hbox);
//        popup.setAutoHide(true);
//        popup.show(AppMain.primaryStage);
        //showNotification("알림","메세지가 도착했습니다.");
        showNotification("경고","도둑이 도착했습니다.");
        
    }

    
    private void showNotification(String type, String message) throws Exception{            //  알림에 따라 사진이 바뀐다.
        Popup popup = new Popup();
        HBox hbox = (HBox)FXMLLoader.load(getClass().getResource("popup.fxml"));
        ImageView imgMessage = (ImageView)hbox.lookup("#imgMessage");
        Label lblMessage = (Label)hbox.lookup("#lblMessage");
        
        if(type.equals("알림")){
            imgMessage.setImage(new Image(getClass().getResource("images/dialog-info.png").toString()));
        }else if(type.equals("경고")){
            imgMessage.setImage(new Image(getClass().getResource("images/dialog-warning.png").toString()));
        }
        lblMessage.setText(message);
        popup.getContent().add(hbox);
        popup.setAutoHide(true);
        popup.show(AppMain.primaryStage);
    }
    
    
    @FXML
    private void handleCustomChooser(ActionEvent event) throws IOException {
//        Stage dialog = new Stage(StageStyle.UTILITY);
//        Parent parent = FXMLLoader.load(getClass().getResource("custom-dialog.fxml"));
//        Scene scene = new Scene(parent);
//        dialog.setScene(scene);
//        dialog.initModality(Modality.WINDOW_MODAL);
//        dialog.initOwner(AppMain.primaryStage);
//        dialog.show();
         //showCustomDialog("error","네트워크 통신이 되지 않습니다.");
         //showCustomDialog("help","도와드릴까요?");
         //showCustomDialog("info","정보드릴까요?");
         showCustomDialog("warning","경고!.");
    }
    
    
    
    private void showCustomDialog(String type, String message) throws IOException{
        Stage dialog = new Stage(StageStyle.UTILITY);
        Parent parent = FXMLLoader.load(getClass().getResource("custom-dialog.fxml"));
        
        ImageView icon = (ImageView)parent.lookup("#icon");
        Label lblMessage = (Label)parent.lookup("#message");      //필드가 아닌곳에서는 id를 이용하여 lookup()으로 호출시킴.
        Button btnOk = (Button)parent.lookup("#btnOk");
        
        if(type.equals("error")){
            icon.setImage(new Image(getClass().getResource("images/dialog-error.png").toString()));
        }else if(type.equals("help")){
            icon.setImage(new Image(getClass().getResource("images/dialog-help.png").toString()));
        }else if(type.equals("info")){
            icon.setImage(new Image(getClass().getResource("images/dialog-info.png").toString()));
        }else if(type.equals("warning")){
            icon.setImage(new Image(getClass().getResource("images/dialog-warning.png").toString()));
        }
        lblMessage.setText(message);
        
        btnOk.setOnAction(e->{
            dialog.hide();
        });
        
        Scene scene = new Scene(parent);
        dialog.setScene(scene);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.initOwner(AppMain.primaryStage);
        dialog.show();
            
    }
    
}
