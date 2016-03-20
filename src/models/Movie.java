package models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Araja Jyothi Babu on 15-Mar-16.
 */
public class Movie {

    public int movieID;
    public String title;
    public ArrayList<Integer> genre; //int indexes to genreList in Genres

    public Movie(int movieID, String title, ArrayList<Integer> genre) {
        this.movieID = movieID;
        this.title = title;
        this.genre = genre;
    }

    public Movie() {
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Integer> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<Integer> genre) {
        this.genre = genre;
    }
}

class Genres{

    public static ArrayList<String> getGenreList() {
        List<String> array = Arrays.asList("Action", "Adventre", "Animation", "Biography", "Comedy", "Crime", "Documentry", "Drama", "Family", "Fantasy", "History", "Horror", "Music", "Mystery", "Romance", "Sci-Fi", "Sport", "Thriller", "War", "Western");
        ArrayList<String> genreList = new ArrayList<String>(array);
        return genreList;
    }

}
