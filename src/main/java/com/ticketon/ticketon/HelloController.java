package com.ticketon.ticketon;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class HelloController {
    @FXML
    private GridPane grid;

    public void initialize() throws IOException {

        for (int i=0; i < 10; i++) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("item.fxml"));

            AnchorPane anchorPane = loader.load();
            ItemController itemController = loader.getController();
            itemController.setData(
                    "" + i,
                    "Tittle " + i,
                    "10" + "/10",
                    "description",
                    "logo.png"
            );

            grid.add(anchorPane, 0 , i);
        }


    }

}