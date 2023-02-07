package com.ticketon.ticketon;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class HelloController {
    @FXML
    private GridPane grid;

    public void initialize() throws IOException, SQLException {

        DBController db = new DBController();
        int i = 0;
        for (Movie movie: db.getMovies()) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("item.fxml"));

            AnchorPane anchorPane = loader.load();
            ItemController itemController = loader.getController();
            itemController.setData(
                    String.valueOf(movie.id),
                    movie.movieTittle,
                    movie.movieRating + "/10",
                    movie.movieDescription,
                    movie.moviePath
            );

            grid.add(anchorPane, 0 , i);
            i++;
        }


    }

}