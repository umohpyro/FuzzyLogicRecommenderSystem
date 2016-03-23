package controllers.distance_metrics;

import controllers.OracleDAO;
import models.*;
import utils.Utils;

import java.util.ArrayList;

/**
 * Created by Araja Jyothi Babu on 16-Mar-16.
 */
public class Manhattan {

    public static double dissimilarityBetweenUsers(User userU, User userV) throws Exception{
        ArrayList<UserSimilarity> similarityList = OracleDAO.getSimilarity(userU, userV);
        double sumOfDifferences = 0;
        double ratingDifference = 0;
        for(UserSimilarity us : similarityList){
            ratingDifference = us.ratingU - us.ratingV;
            sumOfDifferences += Math.abs(ratingDifference);
        }
        return sumOfDifferences;
    }

    public static double dissimilarityBetweenMovies(Movie movie1, Movie movie2) throws Exception {
        ArrayList<String> genreList = Genre.getGenreList();
        double sumOfDifferences = 0;
        double genreDifference = 0;
        for(int i = 0; i < genreList.size(); i++){
            genreDifference = movie1.genres.get(i) - movie2.genres.get(i);
            sumOfDifferences += genreDifference;
        }
        return sumOfDifferences;
    }

}
