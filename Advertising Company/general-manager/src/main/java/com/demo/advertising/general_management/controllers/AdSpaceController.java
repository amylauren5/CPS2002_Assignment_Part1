package com.demo.advertising.general_management.controllers;

import com.demo.advertising.general_management.controllers.responses.CreateAdSpaceResponse;
import com.demo.advertising.general_management.controllers.responses.GetAdSpaceResponse;
import com.demo.advertising.general_management.data.repositories.AdSpaceRepository;
import com.demo.advertising.general_management.services.CustomerService;
import com.demo.advertising.general_management.services.models.Adspace;
import com.demo.advertising.general_management.services.AdSpaceService;
import com.demo.advertising.general_management.services.models.Booking;
import com.demo.advertising.general_management.services.models.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "AdSpace",produces = MediaType.APPLICATION_JSON_VALUE)
public class AdSpaceController {

    private final AdSpaceService adSpaceService;

    @Autowired
    public AdSpaceController(AdSpaceService adSpaceService) {
        this.adSpaceService = adSpaceService;
    }

    @Autowired
    ModelMapper mapper;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateAdSpaceResponse> submit(@RequestBody Adspace adspace) {
        Adspace newAdSpace = mapper.map(adspace, Adspace.class);

        String adSpcaceID = adSpaceService.createAdSpace(newAdSpace);
        return ResponseEntity.ok(new CreateAdSpaceResponse(adSpcaceID));
    }

    @GetMapping(value = "{spaceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetAdSpaceResponse> get(String spaceId) {

        Adspace adspace = adSpaceService.getAdSpace(spaceId);

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
