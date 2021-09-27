/**
 The Collection class is used to instantiate a Collection object and perform Collection operations.
 Supported operations include find, grow add, remove, lendingOut, returnAlbum, print,
 printByReleaseDate, and printByGenre

  @author Adams, Jennifer
 */
public class Collection {
    private Album[] albums;
    private int numAlbums; //number of albums currently in the collection

    public Collection(Album[] albums){
        this.numAlbums = 0;
        this.albums = albums;
    }

    public Collection(){
        numAlbums = 0;
        albums = new Album[4];
    }

    /**
     * The find method is used to find a specific album in the collection or return the NOT_FOUND int
     * if the collection is empty or the album does not exist in the collection.
     * @param album
     * @return
     */
    private int find(Album album) {
        int NOT_FOUND = -1;
        if(albums[0] == null){
            return NOT_FOUND;
        }
        for( int c = 0; c < numAlbums; c++ ){
            if( albums[c].equals(album) ){
                return c;
            }
        }
        return NOT_FOUND;
    } //find the album index, or return NOT_FOUND

    /**
     * The isHere method returns false if the collection is empty or if the album that is passed in as an argument is
     * not found in the collection. The method uses a for loop to go through the collection and the .equals() method
     * to compare the album argument to each album in the collection until it finds the correct album, at which point
     * it returns true.
     * @param album
     * @return
     */
    public boolean isHere(Album album){
        if(albums[0] == null){
            return false;
        }
        boolean here = false;
        for(int c = 0; c < numAlbums; c++){
            if (albums[c].equals(album)){
                here = true;
                break;
            }
        }
        return here;
    }

    /**
     * The grow method is called upon whenever a new album needs to be added to the collection, but the collection
     * is full. Grow expands the size of the collection by 4 whenever it is called.
     */
    private void grow() {
        Album[] biggerList = new Album[albums.length+4];
        for( int c = 0; c < albums.length; c++ ){
            biggerList[c] = albums[c];
        }
        this.albums = biggerList;
    } //increase the capacity of the array list by 4

    /**
     * The add method is called upon to add whatever album is passed as an argument to the collection. The return
     * value is a boolean that is used to notify the user whether the command was able to be completed.
     * If the album is already in the collection, the method returns false. Otherwise, the method finds the last open
     * spot in the collection to add the album, or grows the collection if no such spot is available.
     * @param album
     * @return
     */
    public boolean add(Album album) {
        //checking if the album is already in the collection.
        if(find(album)>=0){
            return false;
        }
        //Checking where the last entry is to know if the array is filled already or not.
        album.setIsAvailable(true);
        int lastEntryLocation = 0;
        for( int c = 0; c < albums.length; c++ ){
            if( albums[c] == null ){
                break;
            }
            lastEntryLocation++;
        }
        lastEntryLocation--;
        //If the array is not filled already, we can add the album directly
        if( lastEntryLocation < albums.length-1 ){
            albums[lastEntryLocation+1] = album;
        }
        //If the array is filled already, we need to grow the array then add the album.
        else{
            grow();
            albums[lastEntryLocation+1] = album;
        }
        numAlbums++;
        return true;
    }

    /**
     * The remove method finds the location of the given album and creates a new array of albums without it.
     * If the process was unable to be completed, the method returns false to notify the user that the album
     * was not found and thus could not be removed.
     * @param album
     * @return
     */
    public boolean remove(Album album) {
        /*
        //newListPointer is a pointer for the new albums array that doesn't skip over the cell where the album is
        //being removed
         */
        int newListPointer = 0;
        Album[] newList = new Album[albums.length];
        //traverse albums to find the album the user wants to remove
        for( int c = 0; c < numAlbums; c++){
            if( albums[c].equals(album) ){
                //once the album is found, replicate the old array into a new one without the removed object
                for( int g = 0; g < albums.length; g++ ){
                    if(g == c) {
                        continue;
                    }else{
                        newList[newListPointer] = albums[g];
                    }
                    newListPointer++;
                }
                this.albums = newList;
                numAlbums--;
                //the album was found and removed
                return true;
            }
        }
        //the album was not found and thus could not be removed
        return false;
    }

    /**
     * The emptyArray helper method is used to find out if the Collection is empty or not. The method returns
     * true if the albums array that makes up the Collection is empty, by checking the first element. Otherwise,
     * the method returns false.
     * @param albums
     * @return
     */
    private boolean emptyArray(Album[] albums){
        if(albums[0] == null){
            return true;
        }
        return false;
    }

    /**
     * If the album given as a parameter is in the collection and if it is available, its availability is set to
     * false and the method returns true to notify the user that the function was completed. Otherwise, the method
     * returns false.
     * @param album
     * @return
     */
    public boolean lendingOut(Album album) {
        if(find(album) >= 0){
            if( albums[find(album)].getIsAvailable()  ){
                albums[find(album)].setIsAvailable(false);
                return true;
            }
        }
        return false;
    } //set to not available

    /**
     * Return album checks if the inputted album is in the collection and checks the album's availability. If it
     * is in the collection and unavailable, the album is returned and the method returns true. Otherwise, the
     * method returns false and nothing else is changed.
     * @param album
     * @return
     */
    public boolean returnAlbum(Album album) {
        if( find(album) >= 0 ){
            if( !albums[find(album)].getIsAvailable() ){
                albums[find(album)].setIsAvailable(true);
                return true;
            }
        }
        return false;
    } //set to available

    /**
     * Print first checks if the collection is empty and, if so, returns a statement. Otherwise, the collection is
     * looped through and each album's string representation is displayed one by one.
     */
    public void print() {
        if (emptyArray(albums)) {
            System.out.println("The collection is empty!");
        } else {
            System.out.println("*List of albums in the collection.");
            for (int c = 0; c < numAlbums; c++) {
                System.out.println(albums[c].toString());
            }
            System.out.println("*End of list");
        }
    } //display the list without specifying the order

    /**
     * sortByDate is a helper method which uses the Selection Sort algorithm to modify the existing
     * collection and sort it by release dates ascending order.
     * @param albums
     */
    public void sortByDate(Album[] albums){
        //Selection Sort algorithm
        //int albumsLength = albums.length;
        for( int i = 0; i < numAlbums; i++ ){
            int earliest = i;
            for(int j = i+1; j < numAlbums; j++){
                if( albums[earliest].getReleaseDate().compareTo(albums[j].getReleaseDate()) > 0 ){
                    earliest = j;
                }
            }
            swap(albums, i, earliest);
        }
    }

    /**
     * Swap is a helper method to sortByDate and sortByGenre which does the work of swapping two albums at
     * indices i and j in the Album array albums.
     * @param albums
     * @param first
     * @param last
     */
    public static void swap(Album[] albums, int first, int last){
        //Swap helper method for selection sort algorithm
        Album save = albums[first];
        albums[first] = albums[last];
        albums[last] = save;
    }

    /**
     * printByReleaseDate checks if the collection is empty. If so, a corresponding statement is displayed.
     * Otherwise, sortByDate is called on the collection. Then, the collection is looped through and the string
     * representation of each album is displayed one by one.
     */
    public void printByReleaseDate() {
        if(emptyArray(albums)){
            System.out.println("The collection is empty!");
        }else {
            System.out.println("*Album collection by the release dates.");
            sortByDate(albums);
            for (int c = 0; c < numAlbums; c++) {
                System.out.println(albums[c].toString());
            }
            System.out.println("*End of list");
        }
    }

    /**
     * sortByGenre is a helper method which uses the Selection Sort algorithm to modify the existing
     * collection and sort it by genre in alphabetical order.
     * @param albums
     */
    public void sortByGenre(Album[] albums){
        //Selection Sort algorithm
        for( int i = 0; i < numAlbums; i++ ){
            int earliest = i;
            for(int j = i+1; j<numAlbums; j++){
                if( albums[earliest].getGenre().compareTo(albums[j].getGenre()) > 0 ){
                    earliest = j;
                }
            }
            swap(albums, i, earliest);
        }
    }

    /**
     * printByGenre checks if the collection is empty. If so, a corresponding statement is displayed.
     * Otherwise, sortByGenre is called on the collection. Then, the collection is looped through and the string
     * representation of each album is displayed one by one.
     */
    public void printByGenre() {
        if(emptyArray(albums)){
            System.out.println("The collection is empty!");
        }else {
            System.out.println("*Album collection by genre.");
            sortByGenre(albums);
            for (int c = 0; c < numAlbums; c++) {
                System.out.println(albums[c].toString());
            }
            System.out.println("*End of list");
        }
    }

}