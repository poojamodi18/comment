package io.comment.tablecomment.dao;

import io.comment.tablecomment.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUserNameAndPassword(String userName,String password);
}
