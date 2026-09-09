package ca.bcit.comp2522.iterators;

/**
 * One track in a Playlist.
 *
 * A small immutable value class, here only so that Playlist has something to
 * iterate over.
 *
 * @author BCIT
 * @version 2026
 */
public final class Track {

    private final String title;
    private final String artist;
    private final int seconds;

    /**
     * Constructs a Track.
     *
     * @param title   the track's title
     * @param artist  the performing artist
     * @param seconds the running time in seconds
     */
    public Track(final String title, final String artist, final int seconds) {
        this.title = title;
        this.artist = artist;
        this.seconds = seconds;
    }

    /**
     * Returns this Track's title.
     *
     * @return the title as a String
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns this Track's artist.
     *
     * @return the artist as a String
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Returns this Track's running time.
     *
     * @return the running time in seconds
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * Returns a description of this Track.
     *
     * @return this Track as a String
     */
    @Override
    public String toString() {
        final int secondsPerMinute = 60;
        return String.format("%s by %s (%d:%02d)",
                title, artist, seconds / secondsPerMinute, seconds % secondsPerMinute);
    }
}
