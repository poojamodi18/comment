package io.comment.tablecomment.util;

public enum CommentType {
    PARENT("parent"),
    CHILD("child");

    public final String commentType;

    CommentType(String commentType){this.commentType = commentType;}

    public String getCommentType(){return commentType;}
}
