package com.mercury.final_server.service;

import java.util.ArrayList;
import java.util.List;

import com.mercury.final_server.bean.UserDetail;
import com.mercury.final_server.mail.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.final_server.bean.User;
import com.mercury.final_server.bean.UserProfile;
import com.mercury.final_server.dao.UserDao;
import com.mercury.final_server.http.Response;


@Service
@Transactional
public class UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserDao userDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    EmailService emailService;

    public List<User> getUsers(){
        return userDao.findAll();
    }

    public User getOneUser(int id) {
        return userDao.findById(id).orElse(new User());
    }

    public Response register(User user) {
        // TODO: validation.
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            List<UserProfile> profiles = new ArrayList<UserProfile>();
            UserDetail details = new UserDetail();
            profiles.add(new UserProfile(2));
            details.setUser(user);
            user.setProfiles(profiles);
            user.setUserDetail(details);
            user.setDisable("N");
            userDao.save(user);
            // TODO: send email. assume username is the email for now
            emailService.sendSimpleMessage(user.getEmail(), "Account Created", user.getUsername() + ", your account is created!");
            return new Response(true);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return new Response(false, 400, e.getMessage());
        }

    }

//    public Response toggleDisable(User user) {
//        User u = userDao.findById(user.getId()).get();
//        u.setDisable(user.getDisable());
//        userDao.save(u);
//        return new Response(true);
//    }

//    public Response changePassword(User user, Authentication authentication) {
//        if(user.getUsername().equals(authentication.getName()) || SecurityUtils.isAdmin(authentication.getAuthorities())) {
//            User u = userDao.findByUsername(user.getUsername());
//            u.setPassword(passwordEncoder.encode(user.getPassword()));
//            userDao.save(u);
//        }else {
//            //TODO: Not authorize to update password if not current loggedin user or admin.
//            return new Response(false);
//        }
//        return new Response(true);
//    }

//    public Response deleteUser(int id) {
//        if(userDao.findById(id).get() != null) {
//            userDao.deleteById(id);
//            return new Response(true);
//        }else {
//            return new Response(false, "User is not found!");
//        }
//    }

}
