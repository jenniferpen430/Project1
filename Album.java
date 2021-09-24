public class Album {
    private String title;
    private String artist;
    private Genre genre;
    private Date releaseDate;
    private boolean isAvailable;

    //public enum Genre{ Classical, Country, Jazz, Pop, Unknown};


    public Album(String title, String artist, String genre, String releaseData) {
        //System.out.println(genre);
        String readableGenre = genre.substring(0,1).toUpperCase()+genre.substring(1).toLowerCase();
        //System.out.println(readableGenre);
        Genre genreAsEnum = Genre.valueOf(readableGenre);
        this.title = title;
        this.artist = artist;
        this.genre = genreAsEnum;
        //changed this to default to true.
        isAvailable = true;
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
    public boolean equals(Object obj) {
        Album album = (Album) obj;
        return album.title.equals(this.title) && album.artist.equals(this.artist);
    }

    @Override
    public String toString() {
        if(isAvailable){
            return this.title + "::" + this.artist + "::" + this.genre + "::" + releaseDate.toString() + " is available";
        }
        else{
            return this.title + "::" + this.artist + "::" + this.genre + ":: is not available";
        }
    }
}