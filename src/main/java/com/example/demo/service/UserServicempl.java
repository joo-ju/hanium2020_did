package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("UserService")
public class UserServicempl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Override
    public User findByUserId(String userId){
//        User user = userRepository.findByUserId(userId);
        return (userRepository.findByUserId(userId));
    }
//        return Lists.newArrayList(userRepository.findByUserId(userId));
//        return user;
//    }
    @Override
    public User save(User user) {
        userRepository.save(user);
        return user;
    }

//    @Override
//    public void updateByUserId(String userId, String userAddress){
//        User e = userRepository.findByUserId(userId);
//        // 모든 컬럼들을 전부 get으로 가져와서 set해줘야함.
////        e.setUserName(user.getUserName());
////        e.setUserPassword(user.getUserPassword());
////        e.setUserId(user.getUserId());
////        e.setUserBirth(user.getUserBirth());
////        e.setUserGender(user.getUserGender());
////        e.setUserPhone(user.getUserPhone());
//        e.setUserAddress(userAddress);
////        e.setUserEmail(user.getUserEmail());
////        e.setUserInputdate(user.getUserInputdate());
//
//        userService.save(e);
//    }


}
