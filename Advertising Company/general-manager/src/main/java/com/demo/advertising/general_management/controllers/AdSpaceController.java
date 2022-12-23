package com.demo.advertising.general_management.controllers;

import com.demo.advertising.general_management.controllers.requests.AdSpace;
import com.demo.advertising.general_management.controllers.responses.CreateAdSpaceResponse;
import com.demo.advertising.general_management.controllers.responses.GetAdSpaceResponse;
import com.demo.advertising.general_management.services.models.Adspace;
import com.demo.advertising.general_management.services.AdSpaceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdSpaceController {

    @Autowired
    AdSpaceService adSpaceService;

    @Autowired
    ModelMapper mapper;

    @PostMapping(value = "AdSpace", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateAdSpaceResponse> submit(@RequestBody AdSpace newAdSpace) {

        Adspace adSpace = mapper.map(newAdSpace, Adspace.class);

        String SpaceId = adSpaceService.createAdSpace(adSpace);

        return ResponseEntity.ok(new CreateAdSpaceResponse(SpaceId));
    }

    @GetMapping(value = "AdSpace/{SpaceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetAdSpaceResponse> get(@PathVariable String SpaceId) {

        Adspace adSpace = adSpaceService.getAdSpace(SpaceId);

        if (adSpace == null) {
            return ResponseEntity.notFound().build();
        }

        GetAdSpaceResponse getAdSpaceResponse = mapper.map(adSpace, GetAdSpaceResponse.class);
        return ResponseEntity.ok(getAdSpaceResponse);
    }

    @PutMapping(value = "AdSpace/{SpaceId}", produces = MediaType.APPLICATION_JSON_VALUE)
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
