package com.mercury.final_server.controller;

import com.mercury.final_server.bean.Sample;
import com.mercury.final_server.dao.SampleDao;
import com.mercury.final_server.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@ResponseBody   // if all the methods in the class need @ResponseBody, we can move it here
@RestController // @Controller + @ResponseBody
@RequestMapping("/samples")
public class SampleController {

    @Autowired
    SampleDao sampleDao;

    @Autowired
    SampleService sampleService;

    // GET /samples
    @GetMapping
//    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    public List<Sample> getSamples() {
        return sampleService.getAllSamples();
    }

    // POST /samples
    // request body
    // convert json data to java object: by using jackson
    @PostMapping
    public String postSamples(@RequestBody Sample sample) {
        boolean result = sampleService.addOneSample(sample);
        if (result) {
            return "Sample added!";
        } else {
            return "Sample not added!";
        }
    }

}
