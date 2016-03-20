package controllers;

import models.Movie;
import models.Rating;
import models.User;
import utils.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Araja Jyothi Babu on 20-Mar-16.
 */
public class OracleDAO {

    public static ArrayList<Movie> getMovies() throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        ResultSet moviesFromDB = statement.executeQuery("SELECT * FROM movies");
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        while(moviesFromDB.next())
            movieList.add(Utils.makeMovie(moviesFromDB));
        return movieList;
    }

    public static ArrayList<User> getUsers(String userId) throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        ResultSet usersFromDB = statement.executeQuery("SELECT * FROM users where UserId != '" + userId + "'");
        ArrayList<User> userList = new ArrayList<User>();
        while(usersFromDB.next())
            userList.add(Utils.makeUser(usersFromDB));
        return userList;
    }

    public static ArrayList<User> getUsers() throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        ResultSet usersFromDB = statement.executeQuery("SELECT * FROM users");
        ArrayList<User> userList = new ArrayList<User>();
        while(usersFromDB.next())
            userList.add(Utils.makeUser(usersFromDB));
        return userList;
    }

    public static ArrayList<Rating> getRating() throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        ResultSet ratingsFromDB = statement.executeQuery("SELECT * FROM ratings");
        ArrayList<Rating> ratingList = new ArrayList<Rating>();
        while(ratingsFromDB.next())
            ratingList.add(Utils.makeRating(ratingsFromDB));
        return ratingList;
    }

    public static Rating ratingOfUserToMovie(int userId, int movieId) throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        ResultSet ratingOfUserFromDB = statement.executeQuery("SELECT * FROM ratings where movieId ='" + movieId + "' and userId ='" + userId + "'");
        if(ratingOfUserFromDB.next())
            return Utils.makeRating(ratingOfUserFromDB);
        return Utils.makeRating(); //not found rating
    }

    public static ArrayList<Rating> getRatingsOfUser(int userId) throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        ResultSet ratingsOfUserFromDB = statement.executeQuery("SELECT * FROM ratings where userId ='" + userId + "'");
        ArrayList<Rating> ratingList = new ArrayList<Rating>();
        if(ratingsOfUserFromDB.next())
            ratingList.add(Utils.makeRating(ratingsOfUserFromDB));
        return ratingList;
    }
    
}