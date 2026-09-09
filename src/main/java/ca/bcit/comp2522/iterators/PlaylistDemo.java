package ca.bcit.comp2522.iterators;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Drives Playlist, and shows fail-fast traversal failing.
 *
 * @author BCIT
 * @version 2026
 */
public final class PlaylistDemo {

    /** The tracks the demonstration starts with. */
    private static final Track[] TRACKS = {
        new Track("Alright", "Kendrick Lamar", 219),
        new Track("Bad Guy", "Billie Eilish", 194),
        new Track("Kyoto", "Phoebe Bridgers", 185),
        new Track("Nights", "Frank Ocean", 307),
    };

    /** Added mid-traversal, on purpose, to trip the fail-fast check. */
    private static final Track INTRUDER =
            new Track("Sneaky Addition", "Nobody", 1);

    private PlaylistDemo() {
    }

    /**
     * Builds the Playlist the rest of the demonstration works on.
     *
     * @return a Playlist holding four Tracks
     */
    private static Playlist buildPlaylist() {

        final Playlist playlist = new Playlist();

        for (final Track track : TRACKS) {
            playlist.add(track);
        }

        return playlist;
    }

    /**
     * Walks the playlist with a for-each loop, then again by hand.
     *
     * Read the two loops together once and you will never have to wonder what
     * a for-each loop does again: the second is what the compiler turns the
     * first into.
     *
     * @param playlist the Playlist to walk
     */
    private static void walkTwoWays(final Playlist playlist) {

        // This works ONLY because Playlist implements Iterable. Comment out
        // "implements Iterable<Track>" and this loop stops compiling.
        System.out.println("--- for-each ---");
        for (final Track track : playlist) {
            System.out.println(track);
        }

        System.out.println("--- the same thing, longhand ---");
        final Iterator<Track> iterator = playlist.iterator();
        while (iterator.hasNext()) {
            final Track track = iterator.next();
            System.out.println(track);
        }
    }

    /**
     * Runs two traversals at the same time.
     *
     * Each call to iterator() returns a separate position, so the inner and
     * outer loops do not interfere with one another.
     *
     * @param playlist the Playlist to walk
     */
    private static void walkTwice(final Playlist playlist) {

        System.out.println("--- every pair of tracks ---");
        for (final Track first : playlist) {
            for (final Track second : playlist) {
                if (!first.getTitle().equals(second.getTitle())) {
                    System.out.println(first.getTitle() + " then " + second.getTitle());
                }
            }
        }
    }

    /**
     * Modifies the playlist mid-traversal, on purpose, to show it fail fast.
     *
     * @param playlist the Playlist to break
     */
    private static void breakATraversal(final Playlist playlist) {

        System.out.println("--- modifying during a traversal ---");

        try {
            for (final Track track : playlist) {
                System.out.println("visiting " + track.getTitle());
                playlist.add(INTRUDER);
            }
        } catch (final ConcurrentModificationException e) {
            System.out.println("Caught ConcurrentModificationException, as expected.");
            System.out.println("Reason: " + e.getMessage());
        }
    }

    /**
     * Drives the program.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        final Playlist playlist = buildPlaylist();

        walkTwoWays(playlist);
        walkTwice(playlist);
        breakATraversal(playlist);

        System.out.println("The playlist now holds " + playlist.size() + " tracks.");
    }
}
