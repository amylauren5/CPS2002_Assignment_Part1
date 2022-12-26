package com.demo.advertising.general_management.controllers;

import com.demo.advertising.general_management.controllers.requests.AdSpace;
import com.demo.advertising.general_management.controllers.requests.CreateAdSpaceRequest;
import com.demo.advertising.general_management.controllers.responses.CreateAdSpaceResponse;
import com.demo.advertising.general_management.controllers.responses.GetAdSpaceResponse;
import com.demo.advertising.general_management.services.models.Adspace;
import com.demo.advertising.general_management.services.AdSpaceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class AdSpaceController {

    @Autowired
    AdSpaceService adSpaceService;

    @Autowired
    ModelMapper mapper;

    @PostMapping(value = "AdSpace", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateAdSpaceResponse> submit(@RequestBody CreateAdSpaceRequest newAdSpace) {

        Adspace adSpace = mapper.map(newAdSpace, Adspace.class);

        String SpaceId = adSpaceService.createAdSpace(adSpace);

        return ResponseEntity.ok(new CreateAdSpaceResponse(SpaceId));
    }

    @GetMapping(value = "AdSpace/{Filter}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetAdSpaceResponse> get(@RequestHeader String FilterBy, @RequestHeader String Filter) {

        if(Objects.equals(FilterBy, "SpaceId")){
            Adspace adSpace = adSpaceService.getAdSpace(Filter);

            if (adSpace == null) {
                return ResponseEntity.notFound().build();
            }

            GetAdSpaceResponse getAdSpaceResponse = mapper.map(adSpace, GetAdSpaceResponse.class);
            return ResponseEntity.ok(getAdSpaceResponse);
        }

        return null;
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
