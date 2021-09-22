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
                String title = st.nextToken();
                String artist = st.nextToken();
                String genre = st.nextToken();
                String date = st.nextToken();

                Album album = new Album(title,artist,genre, date);

                if(album.getReleaseDate().isValid()){
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
            else if(command.equals('L')){
                    String title = st.nextToken();
                    String artist = st.nextToken();

                    Album album = new Album(title, artist);
                    if()
            }
            else if(command.equals('R')){

            }
            else if(command.equals('P')){

            }
            else if(command.equals('PD')){

            }
            else if(command.equals('PG')){

            }
            else {
                System.out.println("Invalid command!");
            }

        }
        System.out.println("Collection Manager terminated");
    }
}
