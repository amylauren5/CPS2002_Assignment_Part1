package com.demo.advertising.general_management.controllers;

import com.demo.advertising.general_management.services.models.Adspace;
import com.demo.advertising.general_management.controllers.requests.CreateAdSpaceRequest;
import com.demo.advertising.general_management.controllers.responses.CreateAdSpaceResponse;
import com.demo.advertising.general_management.controllers.responses.GetAdSpaceResponse;
import com.demo.advertising.general_management.services.AdSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

@RestController
public class AdSpaceController {

    @Autowired
    AdSpaceService resourceManagerService;

    @Autowired
    ModelMapper mapper;

    @PostMapping(value = "spaces", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateAdSpaceResponse> submit(@RequestHeader(name = "X-Ad-Space-Id") String SpaceId, @RequestBody CreateAdSpaceRequest request) {

        Adspace orderSubmission = mapper.map(request, Adspace.class);
        orderSubmission.setSpaceId(SpaceId);

        String newSpaceId = resourceManagerService.createResource(orderSubmission);

        return ResponseEntity.ok(new CreateAdSpaceResponse(newSpaceId));
    }

    @GetMapping(value = "spaces/{spaceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetAdSpaceResponse> get(@RequestHeader(name = "X-Ad-Space-Id") String SpaceId, @PathVariable String newSpaceId) {

        Adspace space = resourceManagerService.getResource(SpaceId);

        if (space == null) {
            return ResponseEntity.notFound().build();
        }

        GetAdSpaceResponse getAdSpaceResponse = mapper.map(space, GetAdSpaceResponse.class);
        return ResponseEntity.ok(getAdSpaceResponse);
    }
}
