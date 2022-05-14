import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class MovieAnalytics {
    private List<Movie> listMovie;
    MovieAnalytics(){
        this.listMovie = new ArrayList<>();
    }
    public static Consumer<Movie> showInfo(){
        return new Consumer<Movie>() {
            @Override
            public void accept(Movie t){
                System.out.format("%s (By %s, %d)%n", t.getTitle(), t.getDirector(), t.getReleaseYear());
            }
        };
    }
    void populateWithData(String fileName) throws IOException{
        try(var reader = new BufferedReader(new FileReader(fileName))){
            reader.lines().forEach((k)->{
                String[] strArr = k.split(";");
                this.listMovie.add(new Movie(strArr[0], Integer.parseInt(strArr[1]), Integer.parseInt(strArr[2]), strArr[3], Double.parseDouble(strArr[4]), strArr[5]));
            });

        }
    }
    Stream<Movie> moviesAfter(int year){
        return this.listMovie.stream().filter(t->t.getReleaseYear() >= year).sorted((a,b)->a.getReleaseYear()-b.getReleaseYear());
    }
    Stream<Movie> moviesBefore(int year){
        return this.listMovie.stream().filter(t->t.getReleaseYear() <= year).sorted((a,b)->a.getReleaseYear()-b.getReleaseYear());
    }
    Stream<Movie> moviesBetween(int yearA, int yearB){
        return this.listMovie.stream().filter(t->t.getReleaseYear() >= yearA && t.getReleaseYear() <= yearB).sorted((a,b)->a.getReleaseYear()-b.getReleaseYear());
    }
    Stream<Movie> moviesByDirector(String director){
        return this.listMovie.stream().filter(t->t.getDirector().equalsIgnoreCase(director)).sorted((a,b)->a.getReleaseYear()-b.getReleaseYear());
    }
}   
