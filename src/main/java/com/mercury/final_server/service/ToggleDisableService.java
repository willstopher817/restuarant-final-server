package com.mercury.final_server.service;

import com.mercury.final_server.bean.ToggleDisable;
import com.mercury.final_server.dao.ToggleDisableDao;
import com.mercury.final_server.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToggleDisableService {

    @Autowired
    ToggleDisableDao toggleDisableDao;

    public Response toggleDisable(ToggleDisable toggleDisable) {
        ToggleDisable td = toggleDisableDao.findById(toggleDisable.getId()).get();
        td.setDisable(toggleDisable.getDisable());
        toggleDisableDao.save(td);
        return new Response(true);
    }

}
