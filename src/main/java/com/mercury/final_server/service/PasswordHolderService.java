package com.mercury.final_server.service;

import com.mercury.final_server.bean.PasswordHolder;
import com.mercury.final_server.bean.User;
import com.mercury.final_server.dao.PasswordHolderDao;
import com.mercury.final_server.http.Response;
import com.mercury.final_server.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class PasswordHolderService {

    @Autowired
    PasswordHolderDao passwordHolderDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Response changePassword(PasswordHolder passwordHolder) {
        PasswordHolder passwordFromDataBase = passwordHolderDao.findById(passwordHolder.getId()).get();
        if (passwordEncoder.matches(passwordHolder.getOldPassword(), passwordFromDataBase.getOldPassword())) {
            passwordFromDataBase.setOldPassword(passwordEncoder.encode(passwordHolder.getNewPassword()));
            passwordHolderDao.save(passwordFromDataBase);
            return new Response(true);
        } else {
            return new Response(false);
        }
    }
}

