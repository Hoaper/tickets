package com.ticketon.ticketon;
// disbled color: #8c8c8c
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

public class RoomController {
    private double cst;
    private String film_id;
    @FXML
    private Text tittle;
    @FXML
    private Text reserved_count;
    @FXML
    private Button btn_back;
    @FXML
    private Button btn_reserve;
    @FXML
    private Text cost;
    private List<String> reserved = new ArrayList<>();
    public void setData(String f_id, String t, Double c) {
        film_id = f_id;
        tittle.setText(t);
        cost.setText("Cost: $" + c);
        cst = c;
    }
    public void onSitClick(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            Text sitText = null;
            Pane target = null;
            try {
                target = (Pane) event.getTarget();
                sitText = (Text) target.getChildren().get(0);
            } catch (ClassCastException e) {
                sitText = (Text) event.getTarget();
                target = (Pane) sitText.getParent();
            }
            String sitId = sitText.getText();
            if (reserved.contains(sitId)) {
                reserved.remove(sitId);
                target.setStyle("-fx-background-color:  #d9d9d9");
            } else {
                reserved.add(sitId);
                target.setStyle("-fx-background-color:  #00b359");
            }
            int cntOfReservations = reserved.size();
            Double price = cst * cntOfReservations;
            reserved_count.setText(
                    String.format("Reserved: %d sits, price: $%.2f", cntOfReservations, price)
            );
            btn_reserve.setDisable(reserved.isEmpty());
        }
    }

    public void initialize() {

        btn_reserve.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

            }
        });

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
