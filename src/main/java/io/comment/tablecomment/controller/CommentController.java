package io.comment.tablecomment.controller;

import io.comment.tablecomment.model.Comment;
import io.comment.tablecomment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    ResponseEntity<Map<String,Object>> addNewComment(@RequestBody Comment comment){
        return new ResponseEntity<>(commentService.addNewComment(comment), HttpStatus.OK);
    }

    @GetMapping("/get/{userId}")
    ResponseEntity<Map<String,Object>> getCommentsByUserId(@PathVariable int userId){
        return new ResponseEntity<>(commentService.getCommentsByUserId(userId),HttpStatus.OK);
    }
}
