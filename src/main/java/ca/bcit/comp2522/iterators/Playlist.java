package ca.bcit.comp2522.iterators;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A collection of Tracks that you can walk through with a for-each loop.
 *
 * This is the whole point of the file. The for-each loop is not magic and it
 * does not work on any class you like: it works on arrays, and on anything
 * that implements Iterable. Writing
 *
 *     for (final Track track : playlist) { ... }
 *
 * is the compiler's shorthand for asking the playlist for an Iterator and
 * calling hasNext and next on it until hasNext returns false. Implement
 * Iterable and your own class gets that syntax for free.
 *
 * Iterable demands exactly one method, iterator(), which returns an Iterator.
 * Iterator demands two, hasNext() and next(), and offers a third, remove().
 *
 * Notice where the Iterator lives: TrackIterator is a private inner class. It
 * is private because nothing outside needs to name the type, and it is inner
 * rather than static because it needs to see the enclosing Playlist's tracks
 * list. That is the classic reason to reach for an inner class, and it is why
 * Week 11 teaches nested classes and iterators together.
 *
 * @author BCIT
 * @version 2026
 */
public final class Playlist implements Iterable<Track> {

    private final List<Track> tracks;

    /**
     * Counts how many times this Playlist has been structurally changed.
     *
     * An Iterator records this number when it is created and checks it on
     * every call. If they stop matching, the collection was modified while a
     * traversal was in progress and the Iterator gives up immediately rather
     * than returning nonsense. That is what "fail-fast" means. The real
     * ArrayList does exactly this, under exactly this name.
     */
    private int modificationCount;

    /**
     * Constructs an empty Playlist.
     */
    public Playlist() {
        tracks = new ArrayList<>();
        modificationCount = 0;
    }

    /**
     * Adds a Track to the end of this Playlist.
     *
     * @param track the Track to add
     */
    public void add(final Track track) {
        tracks.add(track);
        modificationCount++;
    }

    /**
     * Returns the number of Tracks in this Playlist.
     *
     * @return the track count as an int
     */
    public int size() {
        return tracks.size();
    }

    /**
     * Returns an Iterator that walks this Playlist from first track to last.
     *
     * A fresh Iterator is created on every call, so two loops over the same
     * Playlist do not interfere with one another. An Iterator is a position in
     * a traversal, not a property of the collection.
     *
     * @return a new Iterator over this Playlist's Tracks
     */
    @Override
    public Iterator<Track> iterator() {
        return new TrackIterator();
    }

    /**
     * Walks a Playlist one Track at a time.
     *
     * Inner, not static, because it reads the enclosing Playlist's tracks list
     * and modificationCount directly.
     */
    private final class TrackIterator implements Iterator<Track> {

        /** The index of the next Track to hand back. */
        private int nextIndex;

        /** What modificationCount was when this Iterator was created. */
        private final int expectedModificationCount;

        private TrackIterator() {
            nextIndex = 0;
            expectedModificationCount = modificationCount;
        }

        /**
         * Returns true if there is another Track to visit.
         *
         * @return true if next() would succeed
         */
        @Override
        public boolean hasNext() {
            return nextIndex < tracks.size();
        }

        /**
         * Returns the next Track and advances past it.
         *
         * @return the next Track in this traversal
         */
        @Override
        public Track next() {

            // The playlist changed underneath us. Stop now, loudly, rather
            // than carrying on and skipping or repeating an element.
            if (modificationCount != expectedModificationCount) {
                throw new ConcurrentModificationException(
                        "the playlist was modified during traversal");
            }

            // Calling next() when hasNext() is false is a programming error,
            // and the Iterator contract says exactly which exception to throw.
            if (!hasNext()) {
                throw new NoSuchElementException("no tracks left");
            }

            final Track track = tracks.get(nextIndex);
            nextIndex++;
            return track;
        }
    }
}
