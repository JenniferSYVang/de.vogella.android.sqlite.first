package jvang.cs.cis3334.devogellaandroidsqlitefirst;

/**
 * Created by Jenni V on 3/31/2017.
 */

public class Comment {
    private long id;                            // this variable is used to track the id of the comment
    private String comment;                     // this variable will represent one of the various comments available

    // this method will return the id of a particular comment
    public long getId() {
        return id;
    }

    // this method will set the id of a comment to the id that was fed in as the parameter
    public void setId(long id) {
        this.id = id;
    }

    // this method will return a comment
    public String getComment() {
        return comment;
    }

    // this method will set comment to the comment provided in the parameter
    public void setComment(String comment) {
        this.comment = comment;
    }

    // Will be used by the ArrayAdapter in the ListView
    // this sets up how the string will be returned when this method is called
    @Override
    public String toString() {
        return comment;
    }
}
