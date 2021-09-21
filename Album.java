public class Album {
    private String title;
    private String artist;
    private Genre genre;
    private Data releaseDate;
    private boolean isAvailable;

    //
    public Album(String name, String date) {
        title = "";
        this.artist = name;

        this.releaseDate = new Date(date);
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

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    //
    public boolean getIsAvailable() {
        return isAvailable;
    }

    //
    @Override
    public boolean equals(Album obj) {
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