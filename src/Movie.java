import java.util.*;
import java.util.stream.Collectors;

public class Movie {

    private String title;
    private String director;
    private String genre;
    private float rating;

    public Movie(String title, String director, String genre, float rating) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("%s (%s, %s) %.2f", title, director, genre, rating);
    }

    public String getGenre() {
        return genre;
    }

    public float getRating() {
        return rating;
    }

    public String getDirector() {
        return director;
    }

    public String getTitle() {
        return title;
    }
}

class MovieCollection {

    private List<Movie> movies;

    public MovieCollection() {
        movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void printByGenre(String genre) {

        List<Movie> list = movies.stream().sorted(Comparator.comparing(Movie::getTitle)
                .thenComparing(Movie::getRating))
                .collect(Collectors.toList());

        for(Movie movie : list) {
            if(genre.equals(movie.getGenre())) {
                System.out.println(movie);
            }
        }
    }

    public List<Movie> getTopRatedN(int n) {
        List<Movie> list = movies.stream()
                .sorted(Comparator.comparing(Movie::getRating).reversed())
                .limit(n)
                .collect(Collectors.toList());
        return list;
    }

    public Map<String, Integer> getCountByDirector(int n) {
        Map<String, Integer> map = new TreeMap<>();

        for (Movie movie : movies) {
            String director = movie.getDirector();
            if(map.containsKey(director)) {
                map.put(director, map.get(director) + 1);
            }
            else {
                map.put(director, 1);
            }
        }
        return map;
    }
}
