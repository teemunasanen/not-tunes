package hutnas.nottunes.models;

public class Track {
    private int trackId;
    private String name;
    private int albumId;
    private int genreId;

    public Track(int trackId, String name, int albumId, int genreId) {
        this.trackId = trackId;
        this.name = name;
        this.albumId = albumId;
        this.genreId = genreId;
    }

    public int getTrackId() {
        return trackId;
    }

    public String getName() {
        return name;
    }

    public int getAlbumId() {
        return albumId;
    }

    public int getGenreId() {
        return genreId;
    }
}
