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
                                                               @RequestParam String type, @RequestParam String size,
                                                               @RequestParam String price,@RequestParam String index,
                                                               @RequestParam(required = false) String location,
                                                               @RequestParam(required = false) String busRoute,
                                                               @RequestParam String minWeeks,@RequestParam String maxWeeks) {

        if (!Objects.equals(type, "bus") && !Objects.equals(type, "bench") &&
                !Objects.equals(type, "billboard")) {
            throw new IllegalStateException("Type must be bus, bench or billboard!");
        }

        int minweeks = Integer.parseInt(minWeeks);
        int maxweeks = Integer.parseInt(maxWeeks);

        if (minweeks > maxweeks) {
            throw new IllegalStateException("Minimum weeks must be less than maximum weeks!");
        }

        AdSpace.AdSpaceBuilder builder = new AdSpace.AdSpaceBuilder(popularity,type,size,price,index,minWeeks,maxWeeks);
        AdSpace adSpace;
        if (Objects.equals(type, "bus")) {
            adSpace = builder.setBusRoute(busRoute).build();
        } else{
            adSpace = builder.setLocation(location).build();
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
                               @RequestParam(required = false) String Type, @RequestParam(required = false) String Size,
                               @RequestParam(required = false) String Price, @RequestParam(required = false) String Location,
                               @RequestParam(required = false) String BusRoute, @RequestParam(required = false) String Index) {
        adSpaceService.updateAdSpace(SpaceId, Popularity, Type, Size, Price, Location, BusRoute, Index);
    }


    @DeleteMapping(value = "/AdSpace/{SpaceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAdSpace(@RequestHeader String SpaceId) {
        adSpaceService.deleteAdSpace(SpaceId);
    }


}
