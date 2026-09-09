package ca.bcit.comp2522.iterators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests Playlist, and the Iterator contract it implements.
 *
 * Implementing an interface is a promise, and the tests below are that promise
 * written out: hasNext must be false on an empty playlist, next must return
 * the elements in order, a second call to iterator() must start again from the
 * beginning, and the two documented exceptions must actually be thrown.
 *
 * Both exceptions here are contract, not negative tests. Iterator's own
 * documentation requires NoSuchElementException when next() is called with
 * nothing left, and Playlist's documentation promises fail-fast behaviour with
 * ConcurrentModificationException. A promise that is never tested is a promise
 * you will eventually break.
 *
 * @author BCIT
 * @version 2026
 */
class PlaylistTest {

    private static final int SECONDS = 200;

    private Playlist playlist;

    @BeforeEach
    void setUp() {
        playlist = new Playlist();
    }

    private static Track track(final String title) {
        return new Track(title, "Some Artist", SECONDS);
    }

    @Test
    void aNewPlaylistIsEmpty() {
        assertEquals(0, playlist.size());
    }

    @Test
    void anIteratorOverAnEmptyPlaylistHasNoNext() {
        assertFalse(playlist.iterator().hasNext());
    }

    @Test
    void addingATrackIncreasesTheSize() {
        playlist.add(track("One"));
        assertEquals(1, playlist.size());
    }

    @Test
    void anIteratorOverANonEmptyPlaylistHasANext() {
        playlist.add(track("One"));
        assertTrue(playlist.iterator().hasNext());
    }

    @Test
    void nextReturnsTheFirstTrackAdded() {
        playlist.add(track("One"));
        playlist.add(track("Two"));
        assertEquals("One", playlist.iterator().next().getTitle());
    }

    @Test
    void theForEachLoopVisitsEveryTrack() {
        playlist.add(track("One"));
        playlist.add(track("Two"));
        playlist.add(track("Three"));

        int visited = 0;
        for (final Track ignored : playlist) {
            visited++;
        }

        assertEquals(3, visited);
    }

    @Test
    void eachCallToIteratorStartsANewTraversal() {
        playlist.add(track("One"));

        final Iterator<Track> first = playlist.iterator();
        first.next();

        // The first iterator is exhausted; a second one must not be.
        assertTrue(playlist.iterator().hasNext());
    }

    @Test
    void nextThrowsWhenThereIsNothingLeft() {
        final Iterator<Track> iterator = playlist.iterator();

        final NoSuchElementException thrown =
                assertThrows(NoSuchElementException.class, iterator::next);

        assertTrue(thrown.getMessage().contains("no tracks left"));
    }

    @Test
    void modifyingDuringATraversalFailsFast() {
        playlist.add(track("One"));
        playlist.add(track("Two"));

        final Iterator<Track> iterator = playlist.iterator();
        iterator.next();
        playlist.add(track("Three"));

        final ConcurrentModificationException thrown =
                assertThrows(ConcurrentModificationException.class, iterator::next);

        assertTrue(thrown.getMessage().contains("modified during traversal"));
    }
}
