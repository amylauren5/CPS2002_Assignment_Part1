package com.demo.advertising.general_management.controllers;

import com.demo.advertising.general_management.services.models.Adspace;
import com.demo.advertising.general_management.services.AdSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "AdSpace",produces = MediaType.APPLICATION_JSON_VALUE)
public class AdSpaceController {

    private final AdSpaceService adSpaceService;

    @Autowired
    public AdSpaceController(AdSpaceService adSpaceService) {
        this.adSpaceService = adSpaceService;
    }

    @PostMapping
    public String createAdSpace(@RequestBody Adspace adspace){
        return adSpaceService.createAdSpace(adspace);
    }

    @GetMapping(path = "{spaceId}")
    public Adspace getAdSpace(String spaceId){
        return adSpaceService.getAdSpace(spaceId);
    }


    @PutMapping(path = "{spaceId}")
    public void updateAdSpace(@PathVariable("spaceId") String spaceId, @RequestBody Adspace adspace) {
        adSpaceService.updateAdSpace(spaceId, adspace);
    }

    /*

    @DeleteMapping(path = "{spaceId}")
    public void deleteAdSpace(@PathVariable("spaceId") String spaceId) {
        adSpaceService.deleteAdSpace(spaceId);
    }

     */

}
