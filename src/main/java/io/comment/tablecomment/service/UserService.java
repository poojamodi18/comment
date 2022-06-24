package io.comment.tablecomment.service;

import io.comment.tablecomment.dao.UserRepository;
import io.comment.tablecomment.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Map<String,Object> login(User user){
        try {
            return Collections.singletonMap("user",userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword()));
        }catch (Exception e){
            return Collections.singletonMap("message","Failed");
        }
    }
}
