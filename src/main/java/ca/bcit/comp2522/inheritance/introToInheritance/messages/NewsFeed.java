package ca.bcit.comp2522.inheritance.introToInheritance.messages;

import java.util.ArrayList;

/**
 * Stores news posts for the feed of a social media application.
 *
 * The point of this package is the Post hierarchy, not the feed. A Post is the
 * general case; MessagePost and PhotoPost are two specific kinds of Post. This
 * class holds an ArrayList of Post and calls display() on each one without
 * knowing or caring which kind it has. That is polymorphism, and it is why
 * adding a third kind of post later requires no change to this file at all.
 *
 * Display of the posts is currently simulated by printing the details to the
 * terminal.
 *
 * @author BCIT Based on code by the authors of BlueJ
 * @version 2026
 */
public class NewsFeed {

    private final ArrayList<Post> posts;

    /**
     * Constructs empty news feed.
     */
    public NewsFeed() {
        posts = new ArrayList<>();
    }

    /**
     * Adds a post to the news feed.
     *
     * @param post  The post to be added.
     */
    public void addPost(final Post post) {
        posts.add(post);
    }

    /**
     * Shows the news feed. Currently: print the news feed details
     * to the terminal. (To do: replace this later with display
     * in web browser.)
     */
    public void show() {
        for (Post post : posts) {
            post.display();
            System.out.println();
        }
    }

    /**
     * Drives the program.
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        final NewsFeed feed = new NewsFeed();

        // Three different types go into the same list, because all three are
        // a Post. Look at the declared type of the list: ArrayList<Post>.
        feed.addPost(new Post("adebayo"));
        feed.addPost(new MessagePost("priya",
                "Third coffee of the day and it is only 10am"));
        feed.addPost(new PhotoPost("mei", "sunrise-from-the-skytrain.jpg",
                "Worth getting up early for"));

        for (final Post post : feed.posts) {
            post.like();
        }

        for (final Post post : feed.posts) {
            post.addComment("Same here");
        }

        feed.show();
    }
}
