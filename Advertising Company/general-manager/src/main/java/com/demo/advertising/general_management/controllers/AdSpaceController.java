package com.demo.advertising.general_management.controllers;

import com.demo.advertising.general_management.services.CustomerService;
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

    private final AdSpaceService adSpaceService;

    @Autowired
    public AdSpaceController(AdSpaceService adSpaceService) {
        this.adSpaceService = adSpaceService;
    }

    @PostMapping
    public void createAdSpace(@RequestBody Adspace adspace){
        adSpaceService.createAdSpace(adspace);
    }

    @GetMapping(value = "{spaceId}")
    public Adspace getAdSpace(String spaceId){
        return adSpaceService.getAdSpace(spaceId);
    }

    @PutMapping(value = "{spaceId}")
    public void updateAdSpace(@PathVariable("spaceId") String spaceId, @RequestBody Adspace adspace) {
        adSpaceService.updateAdSpace(spaceId, adspace);
    }

    @DeleteMapping(value = "{spaceId}")
    public void deleteAdSpace(@PathVariable("spaceId") String spaceId) {
        adSpaceService.deleteAdSpace(spaceId);
    }

}
