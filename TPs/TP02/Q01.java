
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Show {

    private String show_id;
    private String type;
    private String title;
    private String director;
    private List<String> cast;
    private String country;
    private LocalDate date_added;
    private int release_year;
    private String rating;
    private String duration;
    private List<String> listed_in;

    //Construtor
    public Show() {
        show_id = "";
        type = "";
        title = "";
        director = "";
        cast = null;
        country = "";
        date_added = null;
        release_year = 0;
        rating = "";
        duration = "";
        listed_in = null;
    }

    //Construtor
    public Show(String show_id, String type, String title, String director, List<String> cast, String country, LocalDate date_added, int release_year, String rating, String duration, List<String> listed_in) {
        this.show_id = show_id;
        this.type = type;
        this.title = title;
        this.director = director;
        this.cast = cast;
        this.country = country;
        this.date_added = date_added;
        this.release_year = release_year;
        this.rating = rating;
        this.duration = duration;
        this.listed_in = listed_in;
    }

    //Métodos getters
    public String getShow_id() {
        return show_id;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public List<String> getCast() {
        return cast;
    }

    public String getCountry() {
        return country;
    }

    public LocalDate getDate_Added() {
        return date_added;
    }

    public int getRelease_year() {
        return release_year;
    }

    public String getRating() {
        return rating;
    }

    public String getDuration() {
        return duration;
    }

    public List<String> getListed_in() {
        return listed_in;
    }

    //Métodos setters
    public void setShow_id(String show_id) {
        this.show_id = show_id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDate_added(LocalDate date_added) {
        this.date_added = date_added;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setListed_in(List<String> listed_in) {
        this.listed_in = listed_in;
    }

    //Outros métodos 
    //Converter para String
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);

        StringBuilder sb = new StringBuilder();

        sb.append("=> ");
        sb.append(show_id).append(" ## ");
        sb.append(title).append(" ## ");
        sb.append(type).append(" ## ");
        sb.append(director.isEmpty() ? "NaN" : director).append(" ## ");

        if (cast == null || cast.isEmpty()) {
            sb.append("[NaN]").append(" ## ");
        } else {
            sb.append("[").append(String.join(", ", cast)).append("]").append(" ## ");
        }

        sb.append(country.isEmpty() ? "NaN" : country).append(" ## ");

        if (date_added == null) {
            sb.append("NaN").append(" ## ");
        } else {
            sb.append(date_added.format(dtf)).append(" ## ");
        }

        sb.append(release_year).append(" ## ");
        sb.append(rating.isEmpty() ? "NaN" : rating).append(" ## ");
        sb.append(duration.isEmpty() ? "NaN" : duration).append(" ## ");

        if (listed_in == null || listed_in.isEmpty()) {
            sb.append("[NaN]").append(" ##");
        } else {
            sb.append("[").append(String.join(", ", listed_in)).append("]").append(" ##");
        }

        return sb.toString();
    }

    //Método para imprimir 
    public void imprimir() {
        System.out.println(toString());
    }

    //Método para buscar pelo show_id
    public boolean buscarShow_id(String id) {
        return show_id.equals(id);
    }

    //Método para clonar show 
    public Show clonar(Show show) {

        return new Show(show.show_id, show.type, show.title, show.director, show.cast, show.country, show.date_added, show.release_year, show.rating, show.duration, show.listed_in);
    }

}

public class Q01 {

    static List<Show> shows = new ArrayList<>();
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void ordenarInsercao(List<String> cast) {
        for (int i = 1; i < cast.size(); i++) {
            String tmp = cast.get(i);
            int j = i - 1;
    
            while (j >= 0 && cast.get(j).compareTo(tmp) > 0) {
                cast.set(j + 1, cast.get(j));
                j--;
            }
    
            cast.set(j + 1, tmp);
        }
    }
    

    //Método para preencher show com os dados do arquivo
    public static void preencherShows() {

        String show = "/tmp/disneyplus.csv";

        try {
            RandomAccessFile file = new RandomAccessFile(show, "r");

            Charset charset = Charset.forName("UTF-8");

            file.readLine();

            String linha;
            while ((linha = file.readLine()) != null) {

                linha = new String(linha.getBytes("ISO-8859-1"), charset);

                //Implementar lógica
                String[] campos = parseCSVLine(linha);

                Show s = new Show();

                //show_id
                s.setShow_id(campos[0]);

                //type
                s.setType(campos[1]);

                //type
                s.setTitle(campos[2]);

                //director
                s.setDirector(campos[3].equals("NaN") ? "" : campos[3]);
                
                // cast
                List<String> cast = new ArrayList<>();
                if (!campos[4].equals("NaN") && !campos[4].isEmpty()) {
                    String[] atores = campos[4].split(", ");
                    Collections.addAll(cast, atores);
                }
                ordenarInsercao(cast);
                s.setCast(cast);
                
                // country
                s.setCountry(campos[5].equals("NaN") ? "" : campos[5]);
                
                // date_added
                if (!campos[6].equals("NaN") && !campos[6].isEmpty()) {
                    DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
                    try {
                        LocalDate data = LocalDate.parse(campos[6], formatoData);
                        s.setDate_added(data);
                    } catch (Exception e) {
                        s.setDate_added(null);
                    }
                } else {
                    s.setDate_added(null);
                }

                // release year
                s.setRelease_year(Integer.parseInt(campos[7]));

                // rating
                s.setRating(campos[8]);

                // duration
                s.setDuration(campos[9]);

                // listed_in
                List<String> categorias = new ArrayList<>();
                if (!campos[10].equals("NaN") && !campos[10].isEmpty()) {
                    String[] partes = campos[10].split(", ");
                    Collections.addAll(categorias, partes);
                }
                s.setListed_in(categorias);

                // adiciona na lista
                shows.add(s);

            }

        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    //Método para identificar o fim da entrada quando encontrar "FIM"
    public static boolean isFim(String str) {
        boolean fim = false;
        if (str.equals("FIM")) {
            fim = true;
        }

        return fim;
    }

    public static String[] parseCSVLine(String linha) {
        List<String> campos = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean dentroDeAspas = false;

        for (int i = 0; i < linha.length(); i++) {
            char c = linha.charAt(i);

            if (c == '"') {
                dentroDeAspas = !dentroDeAspas;
            } else if (c == ',' && !dentroDeAspas) {
                campos.add(sb.toString().trim());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        campos.add(sb.toString().trim());

        return campos.toArray(new String[0]);
    }

    public static void main(String[] args) {

        preencherShows();

        Scanner sc = new Scanner(System.in);

        String str = "";

        do {
            str = sc.nextLine();

            if (!isFim(str)) {

                for (int i = 0; i < shows.size(); i++) {

                    Show show = shows.get(i);
                    if (show.buscarShow_id(str)) {
                        show.imprimir();
                        break;
                    }
                }
            }

        } while (!isFim(str));

        sc.close();
    }
}
