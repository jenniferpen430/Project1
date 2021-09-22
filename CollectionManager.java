import java.util.Scanner;


/**
 The CollectionManager class is used to run

 @author Adams, Jennifer
 */
public class CollectionManager {
    private Collection collection;

    public void run() {
        System.out.println("Collection Manager starts running.");
        Scanner scanner = new Scanner(System.in);
        String line  = scanner.nextLine();
        collection = new Collection();
        while(!line.equals('Q')){
            StringTokenizer st = new StringTokenizer(line, "," , false);
            String command = st.nextToken();

            if(command.equals('A')){ //add
                int NOT_FOUND = -1;
                String title = st.nextToken();
                String artist = st.nextToken();
                String genre = st.nextToken();
                String date = st.nextToken();

                Album album = new Album(title,artist,genre, date);

                if(collection.find(album) == NOT_FOUND){
                    System.out.println(title + "::" + artist + " >> is not in  the collection.");
                }
                else if(album.getReleaseDate().isValid()){
                    collection.add(album);
                    System.out.println(album.toString() + " >> added.");
                }
                else{
                    System.out.println("Invalid Date!")
                }
            }
            else if(command.equals('D')){ //remove
                String title = st.nextToken();
                String artist = st.nextToken();

                Album album = new Album(title, artist);

                if(collection.remove(album)){
                    System.out.println(title + "::" + artist + " >> deleted.");
                }
                else {
                    System.out.println(title + "::" + artist + " >> is not in the collection");
                }
            }
            else if(command.equals('L')){ //lend
                    String title = st.nextToken();
                    String artist = st.nextToken();

                    Album album = new Album(title, artist);
                    if(collection.lendingOut(album)){
                        System.out.println(title + "::" + artist + " >> lending out and set to not avaible.");
                    }
                    else{
                        System.out.println(title + ":" + artist + " >> is not in the collection");
                    }
            }
            else if(command.equals('R')){ //return
                    String title = st.nextToken();
                    String artist = st.nextToken();

                    Album album = new Album(title, artist);
                    if(collection.returnAlbum(album)){
                        System.out.println(title + ":" + artist + " >> returning and set to available.");
                    }
                    else{
                        System.out.println(title + ":" + artist + " >> return  cannot  be completed.");
                    }

            }
            else if(command.equals('P')){
                    collection.print();
            }
            else if(command.equals('PD')){
                    collection.printByReleaseDate();
            }
            else if(command.equals('PG')){
                    collection.printByGenre();
            }
            else {
                System.out.println("Invalid command!");
            }
        }
        System.out.println("Collection Manager terminated");
    }
}
