package com.mercury.final_server.controller;

import com.mercury.final_server.bean.PasswordHolder;
import com.mercury.final_server.dao.PasswordHolderDao;
import com.mercury.final_server.http.Response;
import com.mercury.final_server.service.PasswordHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class PasswordHolderController {

    @Autowired
    PasswordHolderDao passwordHolderDao;

    @Autowired
    PasswordHolderService passwordHolderService;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    @PutMapping("/{id}")
    public Response changePassword(@RequestBody PasswordHolder passwordHolder) {
//        System.out.println(passwordHolder);
        return passwordHolderService.changePassword(passwordHolder);
    }


}
