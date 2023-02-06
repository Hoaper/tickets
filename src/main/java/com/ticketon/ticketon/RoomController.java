package com.ticketon.ticketon;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class RoomController {
    private String film_id;
    @FXML
    private Text tittle;
    @FXML
    private Text reserved_count;
    @FXML
    private Button btn_back;
    @FXML
    private Button btn_reserve;

    public void setData(String f_id, String t) {
        film_id = f_id;
        tittle.setText(t);
    }
    public void onSitClick(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {

        }
    }

    public void initialize() {
        btn_back.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    Node node = (Node) mouseEvent.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("hello-view.fxml"));
                    Scene scene = null;
                    try {
                        scene = new Scene(fxmlLoader.load());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    stage.setScene(scene);
                }
            }
        });
    }

}
