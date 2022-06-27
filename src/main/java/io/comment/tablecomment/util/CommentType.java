package io.comment.tablecomment.util;

public enum CommentType {
    PARENT("parent"),
    CHILD("child");

    public final String comment;

    CommentType(String commentType){this.comment = commentType;}

    public String getComment(){return comment;}
}
