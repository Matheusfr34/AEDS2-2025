import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

class Show{
    private String show_id;
    private String type;
    private String title;
    private String director;
    private String[] cast;
    private String country;
    private Date date_added;
    private int release_year;
    private String rating;
    private String duration;
    private String[] listed_in;


    //CONSTRUTORES
    public Show(){
        this.show_id = "";
        this.type=  "";
        this.title = "";
        this.director = "";
        this.cast = new String[0];
        this.country = "";
        this.date_added = null;
        this.release_year = 0;
        this.rating = "";
        this.duration = "";
        this.listed_in = new String[0];
    }

    public Show( String show_id, String type, String title, String director, String[] cast, String country,
                 Date date_added, int release_year, String rating, String duration, String[] listed_in){
        
        this.show_id = show_id;
        this.type=  type;
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

    //getters
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

    public String[] getCast() {
        return cast;
    }

    public String getCountry() {
        return country;
    }

    public Date getDate_added() {
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

    public String[] getListed_in() {
        return listed_in;
    }

    //setters
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

    public void setCast(String[] cast) {
        this.cast = cast;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDate_added(Date date_added) {
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

    public void setListed_in(String[] listed_in) {
        this.listed_in = listed_in;
    }


    //leitura
    public static void leiaShow(Show[] show) throws IOException, ParseException{
        
        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/disneyplus.csv"), StandardCharsets.UTF_8));

        file.readLine();

        String linha = "";
        while((linha = file.readLine()) != null){
            
            //show_id,type,title,director,cast,country,date_added,release_year,rating,duration,listed_in,description
            // 0   1       2                        3                            4               5          6            7     8      9       10                                              11
            //s1,Movie,A Spark Story,"Jason Steran, Leanne Dare","Apthon Corbin, Louis Gonzales",,"September 24, 2021",2021,TV-PG,88 min,Documentary,Two Pixar filmmakers strive to bring their uniquely personal SparkShorts visions to the screen.
            String[] divisao= linha.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

            // Processa cada campo removendo as aspas externas
            for (int i = 0; i < divisao.length; i++) {
                divisao[i] = divisao[i].replaceAll("^\"|\"$", "").trim();
    
                // Tratamento especial para campos vazios representados como ",,"
                if (divisao[i].isEmpty() && linha.contains(",,")) {
                     divisao[i] = ""; 
                }
            }

            int index = Integer.parseInt(divisao[0].substring(1));
            --index;

            String[]cast = divisao[4].split(",\\s*");// removendo espaços depois da virgula e a virgula
            for(int i = 0; i <cast.length; i++){
                cast[i]=titleHasAspas(cast[i]);
            }
            ordenandoVetor(cast);

            if(divisao[6].isEmpty()){
                divisao[6] = "March 1, 1900";
            }
            Date date;
            SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);
            String data = divisao[6];
            date = formatter.parse(data);

            int ano = Integer.parseInt(divisao[7]);
            String[] listed = divisao[10].split(",\\s*"); 
            for(int i = 0; i <listed.length; i++){
                listed[i]=titleHasAspas(listed[i]);
            }
            ordenandoVetor(cast);

            show[index] = new Show(divisao[0], divisao[1], titleHasAspas(divisao[2]), divisao[3], cast,
                                    divisao[5], date, ano, divisao[8], divisao[9], listed);
        }

        file.close();

    }
    public static void ordenandoVetor(String[] ordenar){
        for(int i = 0; i < ordenar.length - 1; i++){
            for(int j = i+1; j <ordenar.length; j++){
                if(ehMaior(ordenar[i], ordenar[j])){
                    String tmp = ordenar[i];
                    ordenar[i] = ordenar[j];
                    ordenar[j]= tmp;
                }
            }
        }
    }
    
    public static String titleHasAspas(String title) {
        StringBuilder sb = new StringBuilder(title.length());
        boolean aspasAnterior = false;
    
        for(int i = 0; i < title.length(); i++) {
            char c = title.charAt(i);
            
            if(c != '"') {
                // Adiciona espaço apenas se:
                // 1. O caractere anterior era aspas
                // 2. O caractere atual não é espaço
                // 3. Não estamos no início da string
                if(aspasAnterior && c != ' ' && sb.length() > 0) {
                    sb.append(' ');
                }
                sb.append(c);
                aspasAnterior = false;
            } else {
                aspasAnterior = true;
            }
        }
        
        return sb.toString();
    }

    public static boolean ehMaior(String menor, String  maior ){
        boolean ehMaior = false;
        String[] str1 = menor.split(" "), str2 = maior.split(" ") ;
        if(str1[0].compareTo(str2[0]) > 0) {
            ehMaior = true;
        } else if(str1[0].compareTo(str2[0]) == 0) {
            if(str1.length > 1 && str2.length > 1) {
                if(str1[1].compareTo(str2[1]) > 0) {
                    ehMaior = true;
                }
            }
        }
        
        return ehMaior;
    }

    public void imprimir(){

        System.out.print("=> " + show_id + " ## " + title + " ## " + type + " ## " );

        if(director.isEmpty()){
            System.out.print("NaN" + " ## " + "[");
        }else{
            System.out.print( director + " ## " + "[");
        }

        if(cast.length == 1 && cast[0].isEmpty()){
            System.out.print("NaN" + "]");
        }else{
            for(int i = 0; i < cast.length-1;i++){
                System.out.print(cast[i] + ", ");
            }
            System.out.print(cast[cast.length-1] + "]");            
        }
        if (country.isEmpty()) {
            System.out.print(" ## " + "NaN" + " ## ");
        }else{
            System.out.print(" ## " + country + " ## ");
        }

        SimpleDateFormat formatter = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        String data = formatter.format(date_added);
        System.out.print(data + " ## " );
        

        System.out.print(release_year + " ## ");
        System.out.print(rating + " ## ");
        System.out.print(duration + " ## "+ "[");

        if(listed_in.length == 1 && listed_in[0].isEmpty()){
            System.out.println("NaN" + "]"+ "##");
        }else{
            for(int i = 0; i < listed_in.length-1;i++){
                System.out.print(listed_in[i] + ", ");
            }
            System.out.println(listed_in[listed_in.length-1] + "]" +" ##");            
        }

    }

    

}

class No {
    Show elemento;
    No esq, dir;

    public No(Show elemento) {
        this.elemento = elemento;
        this.esq = null;
        this.dir = null;
    }
}

class Arvore {
    No raiz;
    private int comparacoes;
    private long startTime;

    public Arvore() {
        this.raiz = null;
        this.comparacoes = 0;
        this.startTime = System.currentTimeMillis();
    }

    public void inserir(Show x) {
        raiz = inserir(raiz, x);
    }

    private No inserir(No i, Show x) {
        if (i == null) {
            i = new No(x);
        } else {
            comparacoes++;
            int cmp = x.getTitle().compareToIgnoreCase(i.elemento.getTitle());
            if (cmp < 0) {
                i.esq = inserir(i.esq, x);
            } else if (cmp > 0) {
                i.dir = inserir(i.dir, x);
            }
        }
        return i;
    }

    public String pesquisar(String title) {
        StringBuilder path = new StringBuilder("=>raiz ");
        boolean encontrado = pesquisar(raiz, title, path);
        return path.toString() + (encontrado ? " SIM" : " NAO");
    }

    private boolean pesquisar(No i, String title, StringBuilder path) {
        if (i == null) {
            return false;
        }

        int cmp = title.compareToIgnoreCase(i.elemento.getTitle());
        comparacoes++;
        
        if (cmp == 0) {
            return true;
        } else if (cmp < 0) {
            path.append(" esq");
            return pesquisar(i.esq, title, path);
        } else {
            path.append(" dir");
            return pesquisar(i.dir, title, path);
        }
    }

    public void criarLog(String matricula) {
        try {
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            FileWriter writer = new FileWriter(matricula + "_arvoreBinaria.txt");
            writer.write(matricula + "\t" + executionTime + "\t" + comparacoes);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Q01 {
    static Show[] show = new Show[1368];

    public static void main(String[] args) throws IOException, ParseException {
        Scanner sc = new Scanner(System.in);
        Show.leiaShow(show);
        
        Arvore arvore = new Arvore();
        String linha = sc.nextLine();
        
        while (!linha.equals("FIM")) {
            try {
                int index = Integer.parseInt(linha.substring(1)) - 1;
                if (index >= 0 && index < show.length && show[index] != null) {
                    arvore.inserir(show[index]);
                }
            } catch (NumberFormatException e) {
            }
            linha = sc.nextLine();
        }
        
        linha = sc.nextLine();
        while (!linha.equals("FIM")) {
            String resultado = arvore.pesquisar(linha);
            System.out.println(resultado);
            linha = sc.nextLine();
        }
        
        arvore.criarLog("858190");
    }
}