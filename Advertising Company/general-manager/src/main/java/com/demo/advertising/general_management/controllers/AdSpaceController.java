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

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public ResponseEntity<List<GetAdSpaceResponse>> get(@RequestHeader String FilterBy, @RequestHeader String Filter) {

        List<Adspace> adSpaces = adSpaceService.getAdSpace(FilterBy, Filter);

        if (adSpaces == null) {
            return ResponseEntity.notFound().build();
        }

        List<GetAdSpaceResponse> getAdSpaceResponse = adSpaces
                .stream()
                .map(user -> mapper.map(user, GetAdSpaceResponse.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(getAdSpaceResponse);
    }

    @PutMapping(value = "AdSpace/{SpaceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateCustomer(@RequestHeader String SpaceId, @RequestParam(required = false) String Popularity,
                               @RequestParam(required = false) String Type, @RequestParam(required = false) String Size,
                               @RequestParam(required = false) String Price, @RequestParam(required = false) String Location,
                               @RequestParam(required = false) String BusRoute) {
        adSpaceService.updateAdSpace(SpaceId, Popularity, Type, Size, Price, Location, BusRoute);
    }


    /*

    @DeleteMapping(path = "{spaceId}")
    public void deleteAdSpace(@PathVariable("spaceId") String spaceId) {
        adSpaceService.deleteAdSpace(spaceId);
    }

     */

}
