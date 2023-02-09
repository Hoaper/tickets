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
    public ResultSet getMovieById(String _id) throws SQLException {
        Statement state = conn.createStatement();
        ResultSet res = state.executeQuery("SELECT * FROM public.cinema WHERE id=" + _id);
        res.next();
        return res;
    }
    public ResultSet getSits(String film_id) throws SQLException {
        Statement state = conn.createStatement();
        return state.executeQuery("SELECT * FROM public.sits WHERE film_id=" + film_id);
    }

    public void changeBought(boolean status, String filmId, String sitId) throws SQLException {
        Statement state = conn.createStatement();
        state.executeUpdate(
                "UPDATE public.sits SET bought=" + status + " WHERE film_id="
                        + filmId +" AND sit_id=" + sitId
        );
    }


}
