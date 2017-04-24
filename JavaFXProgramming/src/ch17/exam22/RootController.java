
package ch17.exam22;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RootController implements Initializable {

    @FXML
    private TableView<Phone> tableView;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TableColumn tc0 = tableView.getColumns().get(0);
        TableColumn tc1 = tableView.getColumns().get(1);
        TableColumn tc2 = tableView.getColumns().get(2);
        //컬럼 객체 생성
        
        tc0.setCellValueFactory(new PropertyValueFactory<Phone, String>("name"));
        tc1.setCellValueFactory(new PropertyValueFactory<Phone, String>("image"));
        tc2.setCellValueFactory(new PropertyValueFactory<Phone, String>("content"));
        
        //phone 객체와 column을 연결시켜줌
        //각 컬럼에  폰객체에서의 각 필드값을 넣어줌.  <객체,필드타입>(필드)
        
        ObservableList<Phone> list = FXCollections.observableArrayList();   //옵져버블리스트는 폰객체를 가진 컬렉션
        list.add(new Phone("phone01.png","갤럭시s1","첫번째모델"));
         list.add(new Phone("phone02.png","갤럭시s2","첫번째모델"));
          list.add(new Phone("phone03.png","갤럭시s3","첫번째모델"));
          tableView.setItems(list);   //테이블뷰에 데이터 세팅
          //각각의 데이터를 각각의 tc0,tc1,tc2에 넣어줌.
          
          
    }    
    
}
