
/**
 The album class is used to create the album to be used in the other class.
 The attributes of an album are title,artist, genre, releaseDate

 @author Adams, Jennifer
 */

public class Album {
    private String title;
    private String artist;
    private Genre genre;
    private Date releaseDate;
    private boolean isAvailable;

    /**
     The constructer class of the album object that takes in all strings as the parameters
     */
    public Album(String title, String artist, String genre, String releaseData) {
        Genre genreAsEnum = Genre.valueOf(genre);
        this.title = title;
        this.artist = artist;
        this.genre = genreAsEnum;
        isAvailable = true;
        this.releaseDate = new Date(releaseData);
    }

    /**
     The constructer class of the album object that takes in all strings as the parameters but
     only when there is a title and a artist
     */
    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        isAvailable = false;
    }

    /**
     Getter method for title so it can be used in other classes
     @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     Getter method for artist so it can be used in other classes
     @return artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     Getter method for genre so it can be used in other classes
     @return genre
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     Setter method for availability so it can be used in other classes
     */
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    /**
     Getter method for availability so it can be used in other classes
     @return
     */
    public boolean getIsAvailable() {
        return isAvailable;
    }

    /**
     Getter method for releaseDate so it can be used in other classes
     @return Date
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     Getter method for availability so it can be used in other classes
     @return
     */
    @Override
    public boolean equals(Object obj) {
        Album album = (Album) obj;
        return album.title.equals(this.title) && album.artist.equals(this.artist);
    }

    /**
     This method will return the string version of the album with the
     proper formatting to be used in other classes
     @return boolean
     */
    @Override
    public String toString() {
        if(isAvailable){
            return this.title + "::" + this.artist + "::" + this.genre + "::" + releaseDate.toString() + "::is available";
        }
        else{
            return this.title + "::" + this.artist + "::" + this.genre + "::" + releaseDate.toString() + "::is not available";
        }
    }
}