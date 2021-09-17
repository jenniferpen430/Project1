public class Album {
    private String title;
    private String artist;
    private Genre genre;
    private Data releaseDate;
    private boolean isAvailable;

    //
    public Album(String name, String date) {
        title = "";
        this.artist = artist;
        checkOut = false;
        releaseDate = new Date(date);
    }

    //
    public String getTitle() {
        return title;
    }

    //
    public String getArtist() {
        return artist;
    }

    //
    public Genre getGenre() {
        return genre;
    }

    //
    public boolean getIsAvailable() {
        return isAvailable;
    }

    //
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Album){
            Album album = (Album) obj;
            return album.title.equals(this.title) && album.artist.equal(this.artist);
        }
    }

    //
    @Override
    public String toString() {
        if(isAvailable){
            return
        }
        else{
            return
        }
    }
}