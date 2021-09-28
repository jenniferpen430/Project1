import java.util.Scanner;
import java.util.StringTokenizer;


/**
 The CollectionManager class is used as the user interface for the program.
 It will parse through the commands and execute them if valid.

 @author Adams, Jennifer
 */
public class CollectionManager {
    private Collection collection;
    private String genre;
    private String date;
    private String command;
    private String title;
    private String artist;

    public void run() {
        System.out.println("Collection Manager starts running.");
        Scanner scanner = new Scanner(System.in);
        String line  = scanner.nextLine();
        this.collection = new Collection();
        while(!line.equals("Q")){
            if(line == "" || line.isEmpty() || line == null){
                System.out.println("Invalid command!");
            }else {
                StringTokenizer st = new StringTokenizer(line, ",", false);
                command = st.nextToken();
                if (command.equals("P") || command.equals("PD") || command.equals("PG")) {
                    print(command);
                }else {
                    title = st.nextToken();
                    artist = st.nextToken();
                    if (command.equals("A")) { //add
                        genre = st.nextToken();
                        date = st.nextToken();
                        adding();
                    } else if (command.equals("D")) { //remove
                        remove();
                    } else if (command.equals("L")) { //lend
                        lend();
                    } else if (command.equals("R")) { //return
                        deposit();
                    } else {
                        System.out.println("Invalid command!");
                    }
                }
            }
            scanner = new Scanner(System.in);
            line = scanner.nextLine();
        }
        System.out.println("Collection Manager terminated.");
    }

    public void adding(){
        String readableGenre = genre.substring(0,1).toUpperCase()+genre.substring(1).toLowerCase();
        Album album = new Album(title, artist, readableGenre, date);
        if(!Genre.includes(readableGenre)){
            readableGenre = "Unknown";
        }
        if (collection.isHere(album)) {
            System.out.println(album.toString() + " >> is already in the collection.");
        } else {
            if (album.getReleaseDate().isValid()) {
                collection.add(album);
                System.out.println(album.toString() + " >> added.");
            } else {
                System.out.println("Invalid Date!");
            }
        }
    }
    private void remove(){
        Album album = new Album(title, artist);
        if (collection.remove(album)) {
            System.out.println(title + "::" + artist + " >> deleted.");
        } else {
            System.out.println(title + "::" + artist + " >> is not in the collection");
        }
    }
    private void lend(){
        Album album = new Album(title, artist);
        if (collection.lendingOut(album)) {
            System.out.println(title + "::" + artist + " >> lending out and set to not available.");
        } else {
            System.out.println(title + "::" + artist + " >> is not available.");
        }
    }
    private void deposit(){
        Album album = new Album(title, artist);
        if (collection.returnAlbum(album)) {
            System.out.println(title + "::" + artist + " >> returning and set to available.");
        } else {
            System.out.println(title + "::" + artist + " >> return  cannot  be completed.");
        }
    }
    private void print(String command){
        if (command.equals("P")){
            collection.print();
        } else if(command.equals("PD")) {
            collection.printByReleaseDate();
        } else if(command.equals("PG")) {
            collection.printByGenre();
        }


    }
}
