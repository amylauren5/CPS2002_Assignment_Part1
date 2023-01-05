package com.demo.advertising.general_management.controllers;

import com.demo.advertising.general_management.controllers.requests.CreateAdSpaceRequest;
import com.demo.advertising.general_management.controllers.responses.CreateAdSpaceResponse;
import com.demo.advertising.general_management.data.entities.AdSpaceEntity;
import com.demo.advertising.general_management.services.models.AdSpace.*;
import com.demo.advertising.general_management.services.AdSpaceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.Valid;

@RestController
public class AdSpaceController {

    @Autowired
    AdSpaceService adSpaceService;

    @Autowired
    ModelMapper mapper;

    @PostMapping(value = "/AdSpace", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateAdSpaceResponse> createAdSpace(@Valid @RequestBody AdSpace newAdSpace) {

        if (!Objects.equals(newAdSpace.getType(), "bus") && !Objects.equals(newAdSpace.getType(), "bench") &&
                !Objects.equals(newAdSpace.getType(), "billboard")) {
            throw new IllegalStateException("Type must be bus, bench or billboard!");
        }else if (Objects.equals(newAdSpace.getPopularity(), "string") || Objects.equals(newAdSpace.getSize(), "string") ||
                Objects.equals(newAdSpace.getPrice(), "string") || Objects.equals(newAdSpace.getMinWeeks(), "string") ||
                Objects.equals(newAdSpace.getMaxWeeks(), "string")) {
            throw new IllegalStateException("Please fill in all fields!");
        }

        int minweeks = Integer.parseInt(newAdSpace.getMinWeeks());
        int maxweeks = Integer.parseInt(newAdSpace.getMaxWeeks());

        if (minweeks > maxweeks) {
            throw new IllegalStateException("Minimum weeks must be less than maximum weeks!");
        }

        String SpaceId = null;
        if (Objects.equals(newAdSpace.getType(), "bus")) {
            BusAd adSpace = mapper.map(newAdSpace, BusAd.class);
            SpaceId = adSpaceService.createAdSpace(adSpace);
        } else if (Objects.equals(newAdSpace.getType(), "billboard")) {
            BillboardAd adSpace = mapper.map(newAdSpace, BillboardAd.class);
            SpaceId = adSpaceService.createAdSpace(adSpace);
        } else if (Objects.equals(newAdSpace.getType(), "bench")) {
            BenchAd adSpace = mapper.map(newAdSpace, BenchAd.class);
            SpaceId = adSpaceService.createAdSpace(adSpace);
        }

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
