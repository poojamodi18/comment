package io.comment.tablecomment.service;

import io.comment.tablecomment.dao.CommentRepository;
import io.comment.tablecomment.model.Comment;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public static final String MESSAGE = "Message";

    public Map<String,Object> addNewComment(Comment comment){
        try {
            comment.setDate(new Date(System.currentTimeMillis()));
            commentRepository.save(comment);
            return Collections.singletonMap(MESSAGE, "Comment Saved");
        }
        catch (HibernateException e){
            return Collections.singletonMap(MESSAGE,"Comment Not Saved");
        }
    }

    public Map<String,Object> getCommentsByUserId(int userId){
        try{
            List<Comment> comments = commentRepository.findAllByUserId(userId);
            if(comments.isEmpty()){
                return Collections.singletonMap(MESSAGE,"Not Found");
            }
            else {
                return Collections.singletonMap("Comments", comments);
            }
        }catch (HibernateException e){
            return Collections.singletonMap(MESSAGE,"Not Found");
        }
    }
}
