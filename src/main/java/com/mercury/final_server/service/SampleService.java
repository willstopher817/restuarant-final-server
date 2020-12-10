package com.mercury.final_server.service;

// wrap business logic: exception, transaction management, ...

import com.mercury.final_server.bean.Sample;
import com.mercury.final_server.dao.SampleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service    // same thing as @Component
public class SampleService {

    @Autowired
    SampleDao sampleDao;

    public List<Sample> getAllSamples() {
        return sampleDao.findAll();
    }

    @Transactional  // warp all the SQL generated within the method in one transaction(commit/rollback)
    public boolean addOneSample(Sample sample) {
        // begin transaction
        try {
            Optional<Sample> sampleInDB = sampleDao.findById(sample.getName());
            if (sampleInDB.isPresent()) {
                return false;
            } else {
                sampleDao.save(sample);  // if exists, update, otherwise, insert
                Sample sampleBackup = new Sample(sample.getName() + "_backup", sample.getAge());
                sampleDao.save(sampleBackup);
                return true;
            }
            // commit
        } catch (Exception e) {
            return false;
            // rollback
        }

    }

}
