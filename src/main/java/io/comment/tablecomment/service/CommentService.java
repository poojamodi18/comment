package io.comment.tablecomment.service;

import io.comment.tablecomment.dao.CommentRepository;
import io.comment.tablecomment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Collections;
import java.util.Map;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Map<String,Object> addNewComment(Comment comment){
        try {
            comment.setDate(new Date(System.currentTimeMillis()));
            commentRepository.save(comment);
            return Collections.singletonMap("Message", "Comment Saved");
        }
        catch (Exception e){
            return Collections.singletonMap("Message","Comment Not Saved");
        }
    }

    public Map<String,Object> getCommentsByUserId(int userId){
        try{
            return Collections.singletonMap("Comments",commentRepository.findAllByUserId(userId));
        }catch (Exception e){
            return Collections.singletonMap("Message","Not Found");
        }
    }
}
