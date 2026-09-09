package ca.bcit.comp2522.inheritance.introToInheritance.messages;

/**
 * Stores information about a post in a social network news feed.
 * The main part of the post consists of a photo and a caption.
 * Other data, such as author and time, are also stored.
 *
 * @author BCIT Based on code by the authors of BlueJ
 * @version 2026
 */
public class PhotoPost extends Post {
    private final String filename;
    private final String caption;

    /**
     * Constructor for objects of class PhotoPost.
     *
     * @param author    The username of the author of this post.
     * @param filename  The filename of the image in this post.
     * @param caption   A caption for the image.
     */
    public PhotoPost(final String author, final String filename, final String caption) {
        super(author);
        this.filename = filename;
        this.caption = caption;
    }

    /**
     * Return the file name of the image in this post.
     *
     * @return The post's image file name.
     */
    public String getImageFile() {
        return filename;
    }

    /**
     * Return the caption of the image of this post.
     *
     * @return The image's caption.
     */
    public String getCaption() {
        return caption;
    }

}
