public class Album {
    private String title;
    private String artist;
    private Genre genre;
    private Date releaseDate;
    private boolean isAvailable;

    public enum Genre{ Classical, Country, Jazz, Pop, Unknown};

    //note ay
    public Album(String title, String artist, Genre genre, String releaseData) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        isAvailable = false;
        this.releaseDate = new Date(releaseData);
    }

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        isAvailable = false;
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
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    //
    public boolean getIsAvailable() {
        return isAvailable;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    //
    @Override
    public boolean equals(Album album) {
            return album.title.equals(this.title) && album.artist.equal(this.artist);
    }

    @Override
    public String toString() {
        if(isAvailable){
            return this.title + "::" + this.artist + "::" + this.genre + ":: is available";
        }
        else{
            return this.title + "::" + this.artist + "::" + this.genre + ":: is not available";
        }
    }
}