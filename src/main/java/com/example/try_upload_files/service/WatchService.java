package com.example.try_upload_files.service;

import com.example.try_upload_files.entity.Watch;

import java.util.List;

public interface WatchService {
    
    List<Watch> getAlWatch();

    Watch createWatch(Watch watch);

    Watch updateWatch(int id, Watch watch);

    void deleteWatch(int id);

    Watch getWatchById(int id);
}
