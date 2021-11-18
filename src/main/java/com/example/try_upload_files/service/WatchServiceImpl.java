package com.example.try_upload_files.service;

import com.example.try_upload_files.dao.WatchDao;
import com.example.try_upload_files.entity.Watch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class WatchServiceImpl implements WatchService{

    @Autowired
    private WatchDao watchDao;

    @Override
    public List<Watch> getAlWatch() {
        return watchDao.findAll();
    }

    @Override
    public Watch getWatchById(int id) {
        return watchDao
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "No watch with such id"));
    }

    @Override
    public Watch createWatch(Watch watch) {
        return watchDao.saveAndFlush(watch);
    }

    @Override
    public Watch updateWatch(int id, Watch watch) {
        watch.setId(id);
        if (!watchDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No watch found");
        }
        return watchDao.saveAndFlush(watch);
    }

    @Override
    public void deleteWatch(int id) {
        if (!watchDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No watch found");
        }
    }
}
