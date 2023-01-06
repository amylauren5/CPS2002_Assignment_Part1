package com.demo.advertising.general_management.controllers;

import com.demo.advertising.general_management.controllers.responses.CreateAdSpaceResponse;
import com.demo.advertising.general_management.services.models.AdSpace;
import com.demo.advertising.general_management.services.AdSpaceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class AdSpaceController {

    @Autowired
    AdSpaceService adSpaceService;

    @PostMapping(value = "/AdSpace", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateAdSpaceResponse> createAdSpace(@RequestParam String popularity,
                                                               @RequestParam String type, @RequestParam String length,
                                                               @RequestParam String width,@RequestParam String price,
                                                               @RequestParam String minWeeks,@RequestParam String maxWeeks,
                                                               @RequestParam(required = false) String durationInterval,
                                                               @RequestParam(required = false) String location,
                                                               @RequestParam(required = false) String busRoute) {

        if (!Objects.equals(type, "bus") && !Objects.equals(type, "bench") &&
                !Objects.equals(type, "billboard")) {
            throw new IllegalStateException("Type must be bus, bench or billboard!");
        }

        int minweeks = Integer.parseInt(minWeeks);
        int maxweeks = Integer.parseInt(maxWeeks);

        if (minweeks > maxweeks) {
            throw new IllegalStateException("Minimum weeks must be less than maximum weeks!");
        }

        AdSpace.AdSpaceBuilder builder = new AdSpace.AdSpaceBuilder(popularity,type,length,width,price,minWeeks,maxWeeks);
        AdSpace adSpace = null;
        switch (type) {
            case "bus":
                adSpace = builder.setBusRoute(busRoute).build();
                break;
            case "billboard":
                adSpace = builder.setLocation(location).setDurationInterval(durationInterval).build();
                break;
            case "bench":
                adSpace = builder.setLocation(location).build();
                break;
        }
        String SpaceId = adSpaceService.createAdSpace(adSpace);

        return ResponseEntity.ok(new CreateAdSpaceResponse(SpaceId));
    }

    @GetMapping(value = "/AdSpace/{Filter}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AdSpace>> get(@RequestHeader String FilterBy, @RequestHeader String Filter) {

        List<AdSpace> adSpaces = adSpaceService.getAdSpace(FilterBy, Filter);

        if (adSpaces == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(adSpaces);
    }

    @PutMapping(value = "/AdSpace/{SpaceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateAdSpace(@RequestHeader String SpaceId, @RequestParam(required = false) String Popularity,
                               @RequestParam(required = false) String Type, @RequestParam(required = false) String Length,
                              @RequestParam(required = false) String Width, @RequestParam(required = false) String Price,
                              @RequestParam(required = false) String Location, @RequestParam(required = false) String BusRoute,
                              @RequestParam(required = false) String DurationInterval) {
        adSpaceService.updateAdSpace(SpaceId, Popularity, Type, Length, Width, Price, Location, BusRoute, DurationInterval);
    }


    @DeleteMapping(value = "/AdSpace/{SpaceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAdSpace(@RequestHeader String SpaceId) {
        adSpaceService.deleteAdSpace(SpaceId);
    }


}
