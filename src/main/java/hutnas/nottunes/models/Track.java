package hutnas.nottunes.models;

public class Track {
    private int trackId;
    private String name;
    private String artist;
    private String album;
    private String genre;

    public Track(int trackId, String name, String artist, String album, String genre) {
        this.trackId = trackId;
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
