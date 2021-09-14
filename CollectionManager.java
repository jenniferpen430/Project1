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

        }
    }
}
