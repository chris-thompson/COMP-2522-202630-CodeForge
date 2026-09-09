package ca.bcit.comp2522.inheritance.introToInheritance.messages;

import java.util.ArrayList;

/**
 * Stores information about a news feed post in a social network. Posts can be
 * stored and displayed. This class serves as a superclass for more specific
 * post types.
 *
 * @author BCIT Based on code by the authors of BlueJ
 * @version 2026
 */
public class Post {
    private final String username;
    private final long timestamp;
    private int likes;
    private final ArrayList<String> comments;

    /**
     * Constructor for objects of class Post.
     *
     * @param author the username of the author of this post
     */
    public Post(final String author) {
        username = author;
        timestamp = System.currentTimeMillis();
        likes = 0;
        comments = new ArrayList<>();
    }

    /**
     * Record one more 'Like' indication from a user.
     */
    public void like() {
        likes++;
    }

    /**
     * Record that a user has withdrawn his/her 'Like' vote.
     */
    public void unlike() {
        if (likes > 0) {
            likes--;
        }
    }

    /**
     * Adds a comment to this post.
     *
     * @param text
     *            The new comment to add.
     */
    public void addComment(final String text) {
        comments.add(text);
    }

    /**
     * Returns the time of creation of this post.
     *
     * @return The post's creation time, as a system time value.
     */
    public long getTimeStamp() {
        return timestamp;
    }

    /**
     * Displays the details of this post.
     */
    public void display() {
        System.out.println(username);
        System.out.print(timeString(timestamp));

        if (likes > 0) {
            System.out.println("  -  " + likes + " people like this.");
        } else {
            System.out.println();
        }

        if (comments.isEmpty()) {
            System.out.println("   No comments.");
        } else {
            System.out.println("   " + comments.size() + " comment(s). Click here to view.");
        }
    }

    /**
     * Creates a string describing a time point in the past in terms relative to
     * current time, such as "30 seconds ago" or "7 minutes ago". Currently,
     * only seconds and minutes are used for the string.
     *
     * @param time
     *            The time value to convert (in system milliseconds)
     * @return A relative time string for the given time
     */
    private String timeString(final long time) {
        long current = System.currentTimeMillis();
        long pastMillis = current - time; // time passed in milliseconds
        final long millisecondsPerSecond = 1000;
        long seconds = pastMillis / millisecondsPerSecond;
        final long secondsPerMinute = 60;
        long minutes = seconds / secondsPerMinute;
        if (minutes > 0) {
            return minutes + " minutes ago";
        } else {
            return seconds + " seconds ago";
        }
    }
}
