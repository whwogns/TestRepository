
package ch17.exam20;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

public class RootController implements Initializable {

    @FXML
    private ListView<Phone> listView;  //  객체 Phone을 잡아넣어줌


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listView.setCellFactory(new Callback<ListView<Phone>, ListCell<Phone>>(){     //CELL안에 들어가는 팩토리객체를 넣어줌. 팩토리=콜백을 넣어줌.  //cell을만드니 cellFactory
            @Override
            public ListCell<Phone> call(ListView<Phone> param) {       // call은 listcell 객체를 만들어주어 리턴시키는 메소드    이걸 반복하면 listCell을 여러 행을 만들어줌.
                
               ListCell<Phone> listCell = new ListCell<Phone>(){          //listCell을 상속하여 익명개체 생성시킨것.
                   @Override
                   protected void updateItem(Phone item, boolean empty) {   // updateItem listCell안에 들어갈것을 정의하는 메소드
                       super.updateItem(item, empty);   //상속하여 재정의하면 재정의된것만 실행되는데, 부모의 메소드내용도 불러오려면 super로 불러와야함.     // 부모의 메소드에는 선택할수있는 내용이 들어잇음.
                       if(empty) return; //맨처음 실행할땐 데이터가 들어오는  것이 없으므로 phone이  null이 되니까 밑의 코드를 실행하지 말라는 코드
                       
                      
                       // 폰을 넣어주면  Phone item에 대입되고 {}안에 입력될 내용을 입력하여 listcell을 만들어 리턴.
                       // 이때 이것을 FXML로 만들어주어 불러오거나 코드로 작성하는 방법       // fxml에서 id를 갖다 씀. fi:id가 아님.
                       // fx:id는  컨트롤러의 @FXML로 참조할 목적 // id는 코드에서 직접 id값으로 객체를 찾을 때 사용하거나, css에서 객체를 찾을때 사용함.

                       try {
                      //cell에 들어갈 컨테이너 생성
                       HBox hbox = (HBox)FXMLLoader.load(getClass().getResource("item.fxml"));
                       ImageView phoneImage =(ImageView) hbox.lookup("#image");   //node는 imageview의 최상위 클래스   //  id값을 참조해올때는 앞에 #을 붙인다.
                       Label phoneName = (Label) hbox.lookup("#name");
                       Label phoneContent = (Label) hbox.lookup("#content");
                       
                       
                        //cell의 내용으로 설정
                       phoneImage.setImage(new Image(getClass().getResource("images/"+item.getImage()).toString()));   //phoneimage 세팅
                       phoneName.setText(item.getName());
                       phoneContent.setText(item.getContent());
                       setGraphic(hbox);
                       
                       } catch (IOException ex) {
                           ex.printStackTrace();
                       }
                   }
               
               }; 
              return listCell;
              
            }
    }); 
        //선택이벤트처리 (선택 속성감시)
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Phone>(){
            @Override
            public void changed(ObservableValue<? extends Phone> observable, Phone oldValue, Phone newValue) {
                System.out.println(newValue.getImage());
               
            }
        
            
        });
        
        
        
        //데이타 세팅
        ObservableList<Phone> value = FXCollections.observableArrayList();
        value.add(new Phone("phone01.png","갤럭시s1","삼성스마트폰의 최초모델입니다."));
        value.add(new Phone("phone02.png","갤럭시s2","삼성스마트폰의 둘째모델입니다."));
        value.add(new Phone("phone03.png","갤럭시s3","삼성스마트폰의 셋째모델입니다."));

        listView.setItems(value);
    }    
    
}
