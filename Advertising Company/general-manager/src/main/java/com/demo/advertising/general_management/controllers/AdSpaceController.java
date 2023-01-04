package com.demo.advertising.general_management.controllers;

import com.demo.advertising.general_management.controllers.requests.CreateBenchAdRequest;
import com.demo.advertising.general_management.controllers.requests.CreateBillboardAdRequest;
import com.demo.advertising.general_management.controllers.requests.CreateBusAdRequest;
import com.demo.advertising.general_management.controllers.responses.CreateAdSpaceResponse;
import com.demo.advertising.general_management.controllers.responses.GetAdSpaceResponse;
import com.demo.advertising.general_management.services.models.AdSpace.AdSpace;
import com.demo.advertising.general_management.services.AdSpaceService;
import com.demo.advertising.general_management.services.models.AdSpace.BenchAd;
import com.demo.advertising.general_management.services.models.AdSpace.BillboardAd;
import com.demo.advertising.general_management.services.models.AdSpace.BusAd;
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
    public ResponseEntity<CreateAdSpaceResponse> createAdSpace(@Valid @RequestHeader String Type, @RequestBody(required=false) CreateBusAdRequest newBusAd,
                                                               @RequestBody(required=false) CreateBillboardAdRequest newBillboardAd,
                                                               @RequestBody(required=false) CreateBenchAdRequest newBenchAd) {

        if(!Objects.equals(Type, "bus") && !Objects.equals(Type, "bench") &&
                !Objects.equals(Type, "billboard")) {
            throw new IllegalStateException("Type must be bus, bench or billboard!");
        }

        BusAd busAd = mapper.map(newBusAd, BusAd.class);
        BillboardAd billboardAd = mapper.map(newBillboardAd, BillboardAd.class);
        BenchAd benchAd = mapper.map(newBenchAd, BenchAd.class);

        AdSpace adSpace = new AdSpace();
        switch (Type) {
            case "bus": {
                adSpace = mapper.map(busAd, AdSpace.class);
                break;
            }
            case "billboard": {
                adSpace = mapper.map(billboardAd, AdSpace.class);
                break;
            }
            case "bench": {
                adSpace = mapper.map(benchAd, AdSpace.class);
                break;
            }
        }
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

        String SpaceId = adSpaceService.createAdSpace(Type,busAd,billboardAd,benchAd);

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
