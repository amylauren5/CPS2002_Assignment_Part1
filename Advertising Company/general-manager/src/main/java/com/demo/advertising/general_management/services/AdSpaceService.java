package com.demo.advertising.general_management.services;

import com.demo.advertising.general_management.data.entities.AdSpaceEntity;
import com.demo.advertising.general_management.data.repositories.AdSpaceRepository;
import com.demo.advertising.general_management.services.models.AdSpace;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;


@Service
public class AdSpaceService {
    @Autowired
    ModelMapper mapper;

    @Autowired
    AdSpaceRepository adSpaceRepository;

    //create ad space
    public String createAdSpace(AdSpace adSpace){
        AdSpaceEntity adSpaceEntity = mapper.map(adSpace, AdSpaceEntity.class);
        adSpaceEntity.setSpaceId(UUID.randomUUID().toString());
        adSpaceEntity = adSpaceRepository.save(adSpaceEntity);
        return adSpaceEntity.getSpaceId();
    }

    //get ad space
    public List<AdSpace> getAdSpace(String FilterBy, String Filter) {
        AdSpaceEntity adSpaceEntityToFind = new AdSpaceEntity();

        if(Objects.equals(FilterBy, "spaceId")){
            adSpaceEntityToFind.setSpaceId(Filter);
        }else if(Objects.equals(FilterBy, "popularity")){
            adSpaceEntityToFind.setPopularity(Filter);
        }else if(Objects.equals(FilterBy, "type")){
            adSpaceEntityToFind.setType(Filter);
        }else if(Objects.equals(FilterBy, "length")){
            adSpaceEntityToFind.setLength(Filter);
        }else if(Objects.equals(FilterBy, "width")){
            adSpaceEntityToFind.setWidth(Filter);
        }else if(Objects.equals(FilterBy, "price")){
            adSpaceEntityToFind.setPrice(Filter);
        }else if(Objects.equals(FilterBy, "minWeeks")){
            adSpaceEntityToFind.setMinWeeks(Filter);
        }else if(Objects.equals(FilterBy, "maxWeeks")){
            adSpaceEntityToFind.setMaxWeeks(Filter);
        }else if(Objects.equals(FilterBy, "busRoute")){
            adSpaceEntityToFind.setBusRoute(Filter);
        }else if(Objects.equals(FilterBy, "location")){
            adSpaceEntityToFind.setLocation(Filter);
        }

        List<AdSpaceEntity> retrievedOrderEntity =
                adSpaceRepository.findAll(Example.of(adSpaceEntityToFind, ExampleMatcher.matchingAll()));

        if (retrievedOrderEntity.isEmpty()) return null;

        List<AdSpace> spaces= new ArrayList<>();
        for (AdSpaceEntity adSpaceEntity : retrievedOrderEntity) {
            AdSpace.AdSpaceBuilder builder = new AdSpace.AdSpaceBuilder(
                    adSpaceEntity.getPopularity(),adSpaceEntity.getType(), adSpaceEntity.getLength(),
                    adSpaceEntity.getWidth(),adSpaceEntity.getPrice(),adSpaceEntity.getMinWeeks(),
                    adSpaceEntity.getMaxWeeks()).setSpaceId(adSpaceEntity.getSpaceId());
            AdSpace adSpace = null;
            switch (adSpaceEntity.getType()) {
                case "bus":
                    adSpace = builder.setBusRoute(adSpaceEntity.getBusRoute()).build();
                    break;
                case "billboard":
                    adSpace = builder.setLocation(adSpaceEntity.getLocation())
                            .setDurationInterval(adSpaceEntity.getDurationInterval()).build();
                    break;
                case "bench":
                    adSpace = builder.setLocation(adSpaceEntity.getLocation()).build();
                    break;
            }
            spaces.add(adSpace);
        }
        return spaces;
    }

    //update ad space
    @Transactional
    public void updateAdSpace(String SpaceId, String Popularity, String Type, String Length, String Width,
                              String Price, String Location, String BusRoute, String DurationInterval) {

        AdSpaceEntity adSpace = adSpaceRepository.findById(SpaceId).orElseThrow(
                () -> new IllegalStateException("Ad space does not exist!")
        );

        if(Popularity != null && Popularity.length() > 0 && !Objects.equals(adSpace.getPopularity(), Popularity)){
            adSpace.setPopularity(Popularity);
        }

        if(Type != null && Type.length() > 0 && !Objects.equals(adSpace.getType(), Type)){
            adSpace.setType(Type);
        }

        if(Width != null && Width.length() > 0 && !Objects.equals(adSpace.getWidth(), Width)){
            adSpace.setWidth(Width);
        }

        if(Length != null && Length.length() > 0 && !Objects.equals(adSpace.getLength(), Length)){
            adSpace.setLength(Length);
        }

        if(Price != null && Price.length() > 0 && !Objects.equals(adSpace.getPrice(), Price)){
            adSpace.setPrice(Price);
        }

        if(Location != null && Location.length() > 0 && !Objects.equals(adSpace.getLocation(), Location)){
            adSpace.setLocation(Location);
        }

        if(BusRoute != null && BusRoute.length() > 0 && !Objects.equals(adSpace.getBusRoute(), BusRoute)){
            adSpace.setBusRoute(BusRoute);
        }


        if(DurationInterval != null && DurationInterval.length() > 0 && !Objects.equals(adSpace.getDurationInterval(), DurationInterval)){
            adSpace.setDurationInterval(DurationInterval);
        }
    }

    //delete resource
    public void deleteAdSpace(String SpaceId){
        boolean exists = adSpaceRepository.existsById(SpaceId);

        if(!exists){
            throw new IllegalStateException("Ad space does not exist!");
        }

        adSpaceRepository.deleteById(SpaceId);
    }
}
