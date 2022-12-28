package com.demo.advertising.general_management.controllers;

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

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class AdSpaceController {

    @Autowired
    AdSpaceService adSpaceService;

    @Autowired
    ModelMapper mapper;

    @PostMapping(value = "AdSpace", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateAdSpaceResponse> submit(@RequestBody CreateAdSpaceRequest newAdSpace) {

        if(!Objects.equals(newAdSpace.getType(), "bus") && !Objects.equals(newAdSpace.getType(), "bench") &&
                !Objects.equals(newAdSpace.getType(), "billboard")){
            throw new IllegalStateException("Type must be bus, bench or billboard!");
        }else if(Objects.equals(newAdSpace.getPopularity(), "string")||Objects.equals(newAdSpace.getSize(), "string")||
                Objects.equals(newAdSpace.getPrice(), "string")||Objects.equals(newAdSpace.getMinWeeks(), "string")||
                Objects.equals(newAdSpace.getMaxWeeks(), "string")){
            throw new IllegalStateException("Please fill in all fields!");
        }else if((Objects.equals(newAdSpace.getLocation(), "string")&&!Objects.equals(newAdSpace.getBusRoute(), "string"))||
                (!Objects.equals(newAdSpace.getLocation(), "string")&&Objects.equals(newAdSpace.getBusRoute(), "string"))){
            throw new IllegalStateException("Please only fill in busRoute or location!");
        }

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
    public void updateAdSpace(@RequestHeader String SpaceId, @RequestParam(required = false) String Popularity,
                               @RequestParam(required = false) String Type, @RequestParam(required = false) String Size,
                               @RequestParam(required = false) String Price, @RequestParam(required = false) String Location,
                               @RequestParam(required = false) String BusRoute) {
        adSpaceService.updateAdSpace(SpaceId, Popularity, Type, Size, Price, Location, BusRoute);
    }


    @DeleteMapping(value = "AdSpace/{SpaceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAdSpace(@RequestHeader String SpaceId) {
        adSpaceService.deleteAdSpace(SpaceId);
    }


}
