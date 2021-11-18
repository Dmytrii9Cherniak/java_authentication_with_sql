package com.example.try_upload_files.controller;

import com.example.try_upload_files.entity.Watch;
import com.example.try_upload_files.service.WatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/watch")

public class WatchController {

    @Autowired
    private WatchService watchService;

    @GetMapping
    public List<Watch> getAllWatch() {
        return watchService.getAlWatch();
    }

    @GetMapping("/{id}")
    public Watch getWatchById(@PathVariable int id) {
        return watchService.getWatchById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Watch createWatch(@RequestBody Watch watch) {
        return watchService.createWatch(watch);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Watch updateWatch(@PathVariable int id, @RequestBody Watch watch) {
        return watchService.updateWatch(id, watch);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteWatch(@PathVariable int id){
        watchService.deleteWatch(id);
    }

}
