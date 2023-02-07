package com.ticketon.ticketon;
import java.sql.*;
import java.util.ArrayList;

public class DBController {
    private Connection conn;
    public DBController() {
        {
            try {
                conn = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/test",
                        "zh0per",
                        "123");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<Movie> getMovies() throws SQLException {
        ArrayList<Movie> movies = new ArrayList<>();
        Statement state = conn.createStatement();
        ResultSet res = state.executeQuery("SELECT * FROM cinema");
        while (res.next()){
            movies.add(
                    new Movie(
                            res.getInt("id"),
                            res.getString("movie_title"),
                            res.getString("movie_img"),
                            res.getDouble("movie_rating"),
                            res.getString("movie_description"),
                            res.getDouble("cost"))
            );
        }
        return movies;
    }


}
