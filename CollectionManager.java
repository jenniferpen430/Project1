import java.util.Scanner;
import java.util.StringTokenizer;


/**
 The CollectionManager class is used as the user interface for the program.
 It will parse through the commands and execute them if valid.

 @author Adams, Jennifer
 */
public class CollectionManager {
    private Collection collection;

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
                String command = st.nextToken();
                String title = st.nextToken();
                String artist = st.nextToken();
                if (command.equals("A")) { //add
                    String genre = st.nextToken();
                    String date = st.nextToken();
                    Album album = new Album(title, artist, readableGenre, date);
                    adding(album);
                } else if (command.equals("D")) { //remove
                    Album album = new Album(title, artist);
                    remove(album);
                } else if (command.equals("L")) { //lend
                    Album album = new Album(title, artist);
                    lend(album);
                } else if (command.equals("R")) { //return
                    Album album = new Album(title, artist);
                    deposit(album);
                } else if (command.equals("P") || command.equals("PD") || command.equals("PG")) {
                    print(command);
                }else{
                    System.out.println("Invalid command!");
                }
            }
            scanner = new Scanner(System.in);
            line = scanner.nextLine();
        }
        System.out.println("Collection Manager terminated.");
    }

    public void adding(Album album){
        String readableGenre = genre.substring(0,1).toUpperCase()+genre.substring(1).toLowerCase();
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
    public void remove(Album album){
        if (collection.remove(album)) {
            System.out.println(title + "::" + artist + " >> deleted.");
        } else {
            System.out.println(title + "::" + artist + " >> is not in the collection");
        }
    }
    public void lend(Album album){
        if (collection.lendingOut(album)) {
            System.out.println(title + "::" + artist + " >> lending out and set to not available.");
        } else {
            System.out.println(title + "::" + artist + " >> is not available.");
        }
    }
    public void deposit(Album album){
        if (collection.returnAlbum(album)) {
            System.out.println(title + "::" + artist + " >> returning and set to available.");
        } else {
            System.out.println(title + "::" + artist + " >> return  cannot  be completed.");
        }
    }
    public void print(String command){
        if (command.equals("P"){
            collection.print();
        } else if(command.equals("PD")) {
            collection.printByReleaseDate();
        } else if(command.equals("PG")) {
            collection.printByGenre();
        }


    }
}
