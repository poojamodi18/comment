package io.comment.tablecomment.dao;

import io.comment.tablecomment.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

    List<Comment> findAllByUserId(int userId);
}
