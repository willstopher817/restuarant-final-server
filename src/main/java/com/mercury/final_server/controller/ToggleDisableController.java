package com.mercury.final_server.controller;

import com.mercury.final_server.bean.PasswordHolder;
import com.mercury.final_server.bean.ToggleDisable;
import com.mercury.final_server.dao.ToggleDisableDao;
import com.mercury.final_server.http.Response;
import com.mercury.final_server.service.ToggleDisableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class ToggleDisableController {

    @Autowired
    ToggleDisableDao toggleDisableDao;

    @Autowired
    ToggleDisableService toggleDisableService;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    @PutMapping
    public Response toggleDisable(@RequestBody ToggleDisable toggleDisable) {
        return toggleDisableService.toggleDisable(toggleDisable);
    }
}
