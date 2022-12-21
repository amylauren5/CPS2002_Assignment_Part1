package com.demo.advertising.general_management.controllers;

import com.demo.advertising.general_management.services.models.Adspace;
import com.demo.advertising.general_management.services.AdSpaceService;
import com.demo.advertising.general_management.services.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

@RestController
@RequestMapping(path = "AdSpace",produces = MediaType.APPLICATION_JSON_VALUE)
public class AdSpaceController {

    @Autowired
    AdSpaceService AdSpaceService;

    @Autowired
    ModelMapper mapper;

    @PostMapping
    public void createAdSpace(@RequestBody Adspace adspace){
        AdSpaceService.createAdSpace(adspace);
    }

    @GetMapping(path = "{spaceId}")
    public Adspace getAdSpace(String spaceId){
        return AdSpaceService.getAdSpace(spaceId);
    }

    @PutMapping(path = "{spaceId}")
    public void updateAdSpace(@PathVariable("spaceId") String spaceId, @RequestBody Adspace adspace) {
        AdSpaceService.updateAdSpace(spaceId, adspace);
    }

    @DeleteMapping(path = "{spaceId}")
    public void deleteAdSpace(@PathVariable("spaceId") String spaceId) {
        AdSpaceService.deleteAdSpace(spaceId);
    }

}
