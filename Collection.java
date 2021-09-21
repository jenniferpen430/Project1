
public class Collection {
    private Album[] albums;
    private int numAlbums; //number of albums currently in the collection

    private int find(Album album) {
        for( int c = 0; c < albums.length; c++ ){
            if( albums[c].equals(album) ){
                return c;
            }
        }
        //aren't we supposed to return an int, how do we return not_found
        //this 0 is a placeholder
        return 0;
    } //find the album index, or return NOT_FOUND

    private void grow() {
        Album[] biggerList = new Album[albums.length+4];
        for( int c = 0; c < albums.length; c++ ){
            biggerList[c] = albums[c];
        }
        this.albums = biggerList;
    } //increase the capacity of the array list by 4

    public boolean add(Album album) {
        //Checking where the last entry is to know if the array is filled already or not.
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
        return true;
    }

    public boolean remove(Album album) {
        /*
        //newListPointer is a pointer for the new albums array that doesn't skip over the cell where the album is
        //being removed
         */
        int newListPointer = 0;
        Album[] newList = new Album[albums.length];
        //traverse albums to find the album the user wants to remove
        for( int c = 0; c < albums.length; c++){
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
                //the album was found and removed
                return true;
            }
        }
        //the album was not found and thus could not be removed
        return false;
    }

    public boolean lendingOut(Album album) {
        album.isAvailable = 0;
    } //set to not available

    public boolean returnAlbum(Album album) {
        album.isAvailable = 1;
    } //set to available

    public void print() {
        for( int c = 0; c < albums.length; c++ ){
            System.out.println(albums[c].toString());
        }
    } //display the list without specifying the order

    public void printByReleaseDate() {
    }

    public void printByGenre() {
    }

}