import java.time.LocalDate;
import java.util.Scanner;

class Show{
    private String show_id;
    private String type;
    private String title;
    private String director;
    private String[] cast;
    private String country;
    private LocalDate date_added;
    private int release_year;
    private String rating;
    private String duration;
    private String[] listed_in;

    public Show(){

    }

    //Construtor da classe Show
    public Show(String show_id, String type, String title, String directorprivate, String[] cast, String country,LocalDate date_added, int release_year, String rating, String duration, String[] listed_in){
        this.show_id = show_id;

    }

    //Métodos getters
    public String getShow_id(){
        return show_id;
    }
    public String getType(){
        return type;
    }
    public String getTitle(){
        return title;
    }
    public String getDirector(){
        return director;
    }
    public String[] getCast(){
        return cast;
    }
    public String getCountry(){
        return country;
    }
    public LocalDate getDate_Added(){
        return date_added;
    }
    public int getRelease_year(){
        return release_year;
    }
    public String getRating(){
        return rating;
    }
    public String getDuration(){
        return duration;
    }
    public String[] getListed_in(){
        return listed_in;
    }

    //Métodos setters
    public void setShow_id(String show_id){
        this.show_id = show_id;
    }
    public void setType(String type){
        this.type = type;
    }
    
}
public class Q01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        sc.close();
    }
}
