package com.ticketon.ticketon;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ItemController {
    @FXML
    private Button btn_go;
    @FXML
    private Text bd_id;
    @FXML
    private ImageView image;
    @FXML
    private Text tittle;
    @FXML
    private Text rating;
    @FXML
    private Text desc;


    public void setData(String _id, String t, String r, String d, String file_name) {
        bd_id.setText(_id);
        tittle.setText(t);
        rating.setText(r);
        desc.setText(d);
        image.setImage(
                new Image(getClass().getResourceAsStream("img/" + file_name))
        );
        btn_go.setOnMouseClicked(new EventHandler<MouseEvent>() {
            String film_id = bd_id.getText();
            String tittle_name = tittle.getText();
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("cinema-room.txt.fxml"));
                    Scene scene = null;
                    try {
                        scene = new Scene(loader.load());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    RoomController roomController = loader.getController();
//                    Нужно будет сюда передавать данные об наших местах (заняты ли и тд.)
                    roomController.setData(this.film_id, this.tittle_name);

                    Node node = (Node) mouseEvent.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.setScene(scene);
                }
            }
        });
    }

}
