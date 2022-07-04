package io.comment.tablecomment.service;

import io.comment.tablecomment.dao.UserRepository;
import io.comment.tablecomment.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public static final String MESSAGE = "Message";

    public Map<String,Object> login(User user){
        try {
            User userDetails = userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
            if(userDetails!=null){
                Map<String,Object> response = new HashMap<>();
                response.put(MESSAGE,"User Found");
                response.put("User",userDetails);
                return response;
            }else{
                return Collections.singletonMap(MESSAGE,"User Not Found");
            }

        }catch (Exception e){
            return Collections.singletonMap(MESSAGE,"Failed");
        }
    }

    public Map<String,Object> creteUser(User user){
        try{
            userRepository.save(user);
            return Collections.singletonMap(MESSAGE,"User Created");
        }catch (Exception e){
            return Collections.singletonMap(MESSAGE,"User Not Created");
        }
    }
}
