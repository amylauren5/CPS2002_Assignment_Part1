package com.demo.advertising.general_management.controllers;

import com.demo.advertising.general_management.controllers.responses.CreateAdSpaceResponse;
import com.demo.advertising.general_management.controllers.responses.GetAdSpaceResponse;
import com.demo.advertising.general_management.data.repositories.AdSpaceRepository;
import com.demo.advertising.general_management.services.models.Adspace;
import com.demo.advertising.general_management.services.AdSpaceService;
import com.demo.advertising.general_management.services.models.Booking;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "AdSpace",produces = MediaType.APPLICATION_JSON_VALUE)
public class AdSpaceController {

    @Autowired
    AdSpaceService adSpaceService;
    @Autowired
    ModelMapper mapper;

    @PostMapping(path = "{spaceId}")
    public ResponseEntity<CreateAdSpaceResponse> submit(@RequestBody Adspace adspace) {
        Adspace newAdSpace = mapper.map(adspace, Adspace.class);

        String adSpcaceID = adSpaceService.createAdSpace(newAdSpace);
        return ResponseEntity.ok(new CreateAdSpaceResponse(adSpcaceID));
    }

    @GetMapping(path = "{spaceId}")
    public ResponseEntity<GetAdSpaceResponse> get(@RequestHeader String filterBy, @RequestBody String filter) {

        Adspace adspace = adSpaceService.getAdSpace(filter);

        if (adspace == null) {
            return ResponseEntity.notFound().build();
        }

        GetAdSpaceResponse getAdSpaceResponse = mapper.map(adspace, GetAdSpaceResponse.class);
        return ResponseEntity.ok(getAdSpaceResponse);
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
