package com.demo.advertising.general_management.controllers;

import com.demo.advertising.general_management.controllers.requests.CreateAdSpaceRequest;
import com.demo.advertising.general_management.controllers.responses.CreateAdSpaceResponse;
import com.demo.advertising.general_management.controllers.responses.GetAdSpaceResponse;
import com.demo.advertising.general_management.services.models.AdSpace.AdSpace;
import com.demo.advertising.general_management.services.AdSpaceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<CreateAdSpaceResponse> createAdSpace(@Valid @RequestBody CreateAdSpaceRequest newAdSpace,
                                                               @RequestParam(required=false) String location,
                                                               @RequestParam(required=false) String busRoute,
                                                               @RequestParam(required=false) String position,
                                                               @RequestParam(required=false) String index){

        if(!Objects.equals(newAdSpace.getType(), "bus") && !Objects.equals(newAdSpace.getType(), "bench") &&
                !Objects.equals(newAdSpace.getType(), "billboard")) {
            throw new IllegalStateException("Type must be bus, bench or billboard!");
        }

        AdSpace adSpace = mapper.map(newAdSpace, AdSpace.class);

        if(Objects.equals(adSpace.getPopularity(), "string")||Objects.equals(adSpace.getSize(), "string")||
                Objects.equals(adSpace.getPrice(), "string")||Objects.equals(adSpace.getMinWeeks(), "string")||
                Objects.equals(adSpace.getMaxWeeks(), "string")){
            throw new IllegalStateException("Please fill in all fields!");
        }

        int minweeks = Integer.parseInt(adSpace.getMinWeeks());
        int maxweeks = Integer.parseInt(adSpace.getMaxWeeks());

        if(minweeks>maxweeks){
            throw new IllegalStateException("Minimum weeks must be less than maximum weeks!");
        }

        String SpaceId = adSpaceService.createAdSpace(adSpace,location,busRoute,position,index);

        return ResponseEntity.ok(new CreateAdSpaceResponse(SpaceId));
    }

    @GetMapping(value = "/AdSpace/{Filter}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GetAdSpaceResponse>> get(@RequestHeader String FilterBy, @RequestHeader String Filter) {

        List<AdSpace> adSpaces = adSpaceService.getAdSpace(FilterBy, Filter);

        if (adSpaces == null) {
            return ResponseEntity.notFound().build();
        }

        List<GetAdSpaceResponse> getAdSpaceResponse = adSpaces
                .stream()
                .map(user -> mapper.map(user, GetAdSpaceResponse.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(getAdSpaceResponse);
    }

    @PutMapping(value = "/AdSpace/{SpaceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateAdSpace(@RequestHeader String SpaceId, @RequestParam(required = false) String Popularity,
                               @RequestParam(required = false) String Type, @RequestParam(required = false) String Size,
                               @RequestParam(required = false) String Price, @RequestParam(required = false) String Location,
                               @RequestParam(required = false) String BusRoute) {
        adSpaceService.updateAdSpace(SpaceId, Popularity, Type, Size, Price, Location, BusRoute);
    }


    @DeleteMapping(value = "/AdSpace/{SpaceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAdSpace(@RequestHeader String SpaceId) {
        adSpaceService.deleteAdSpace(SpaceId);
    }


}
