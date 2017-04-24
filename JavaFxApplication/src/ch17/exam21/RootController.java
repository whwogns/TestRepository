package ch17.exam21;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
    private ListView<Food> listView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listView.setCellFactory(new Callback<ListView<Food>, ListCell<Food>>() {
            @Override
            public ListCell<Food> call(ListView<Food> param) {
                ListCell<Food> listCell = new ListCell<Food>() {
                    @Override
                    protected void updateItem(Food item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty)  return;
                     try {
                          HBox hbox = (HBox) FXMLLoader.load(getClass().getResource("item.fxml"));
                            ImageView foodImage1 = (ImageView) hbox.lookup("#image1");   //node는 imageview의 최상위 클래스   //  id값을 참조해올때는 앞에 #을 붙인다.                         
                            Label foodName = (Label) hbox.lookup("#name");                            
                            ImageView score = (ImageView) hbox.lookup("#image2");
                            Label foodDescription = (Label) hbox.lookup("#description");
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            foodImage1.setImage(new Image(getClass().getResource("images1/" + item.getImage()).toString()));
                            foodName.setText(item.getName());
                            score.setImage(new Image(getClass().getResource("images2/star" + item.getScore()) + ".png".toString()));
                            foodDescription.setText(item.getDescription());
                            setGraphic(hbox);
                        } catch (IOException ex) {
                        }
                    }

                };
                return listCell;

            }
        });

//        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Food>() {
//            @Override
//            public void changed(ObservableValue<? extends Food> observable, Food oldValue, Food newValue) {
//                
//                
//                String foodName = newValue.getName();
//                int score = newValue.getScore();
//                String foodDescription = newValue.getDescription();
//                
//                System.out.println(newValue.getImage());
//            }
//        });
        ObservableList<Food> value = FXCollections.observableArrayList();

        value.add(new Food("food01.png", "삼겹살", 0, "맜있음"));
        value.add(new Food("food02.png", "갈비", 0, "좀 맜있음"));
        value.add(new Food("food03.png", "장어구이", 0, "약간 맜있음"));
        value.add(new Food("food04.png", "비빔밥", 0, "아주 맜있음"));
        value.add(new Food("food05.png", "새우볶음밥", 0, "쪼금 맜있음"));
        listView.setItems(value);

    }

}
