package ca.bcit.comp2522.inheritance.introToInheritance.messages;

/**
 * Stores information about a post in a social network news feed.
 * The main part of the post consists of a (possibly multi-line)
 * text message. Other data, such as author and time, are also stored.
 * =
 * @author BCIT Based on code by the authors of BlueJ
 * @version 2026
 */
public class MessagePost extends Post {
    private final String message;

    /**
     * Constructor for objects of class MessagePost.
     *
     * @param author    The username of the author of this post.
     * @param text      The text of this post.
     */
    public MessagePost(final String author, final String text) {
        super(author);
        message = text;
    }

    /**
     * Return the text of this post.
     *
     * @return The post's message text.
     */
    public String getText() {
        return message;
    }
}
