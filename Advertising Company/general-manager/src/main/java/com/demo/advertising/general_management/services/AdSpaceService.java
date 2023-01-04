package com.demo.advertising.general_management.services;

import com.demo.advertising.general_management.data.entities.AdSpaceEntity;
import com.demo.advertising.general_management.data.repositories.AdSpaceRepository;
import com.demo.advertising.general_management.services.models.AdSpace.AdSpace;

import com.demo.advertising.general_management.services.models.AdSpace.BenchAd;
import com.demo.advertising.general_management.services.models.AdSpace.BillboardAd;
import com.demo.advertising.general_management.services.models.AdSpace.BusAd;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class AdSpaceService {

    @Autowired
    ModelMapper mapper;

    @Autowired
    AdSpaceRepository adSpaceRepository;

    //create ad space
    public <T extends AdSpace> String createAdSpace(AdSpace adSpace){
        AdSpaceEntity adSpaceEntity = mapper.map(adSpace, AdSpaceEntity.class);
        adSpaceEntity.setSpaceId(UUID.randomUUID().toString());
        adSpaceEntity = adSpaceRepository.save(adSpaceEntity);
        return adSpaceEntity.getSpaceId();
    }


    //get ad space
    public List<AdSpace> getAdSpace(String FilterBy, String Filter) {
        AdSpaceEntity adSpaceEntityToFind = new AdSpaceEntity();

        if(Objects.equals(FilterBy, "SpaceId")){
            adSpaceEntityToFind.setSpaceId(Filter);
        }else if(Objects.equals(FilterBy, "Popularity")){
            adSpaceEntityToFind.setPopularity(Filter);
        }else if(Objects.equals(FilterBy, "Type")){
            adSpaceEntityToFind.setType(Filter);
        }else if(Objects.equals(FilterBy, "Size")){
            adSpaceEntityToFind.setSize(Filter);
        }else if(Objects.equals(FilterBy, "Price")){
            adSpaceEntityToFind.setPrice(Filter);
        }else if(Objects.equals(FilterBy, "MinWeeks")){
            adSpaceEntityToFind.setMinWeeks(Filter);
        }else if(Objects.equals(FilterBy, "MaxWeeks")){
            adSpaceEntityToFind.setMaxWeeks(Filter);
        }else if(Objects.equals(FilterBy, "BusRoute")){
            adSpaceEntityToFind.setBusRoute(Filter);
        }else if(Objects.equals(FilterBy, "Location")){
            adSpaceEntityToFind.setLocation(Filter);
        }else if(Objects.equals(FilterBy, "Index")){
            adSpaceEntityToFind.setIndex(Filter);
        }

        List<AdSpaceEntity> retrievedOrderEntity =
                adSpaceRepository.findAll(Example.of(adSpaceEntityToFind, ExampleMatcher.matchingAll()));

        if (retrievedOrderEntity.isEmpty()) return null;

        List<AdSpace> spaces= new ArrayList<>();
        for (AdSpaceEntity adSpaceEntity : retrievedOrderEntity) {
            if (Objects.equals(adSpaceEntity.getType(), "bus")) {
                BusAd adSpace = mapper.map(adSpaceEntity, BusAd.class);
                spaces.add(adSpace);
            } else if (Objects.equals(adSpaceEntity.getType(), "billboard")) {
                BillboardAd adSpace = mapper.map(adSpaceEntity, BillboardAd.class);
                spaces.add(adSpace);
            } else if (Objects.equals(adSpaceEntity.getType(), "bench")) {
                BenchAd adSpace = mapper.map(adSpaceEntity, BenchAd.class);
                spaces.add(adSpace);
            }
        }
        return spaces;
    }

    //update ad space
    @Transactional
    public void updateAdSpace(String SpaceId, String Popularity, String Type, String Size,
                              String Price, String Location, String BusRoute, String Position, String Index) {

        AdSpaceEntity adSpace = adSpaceRepository.findById(SpaceId).orElseThrow(
                () -> new IllegalStateException("Ad space does not exist!")
        );

        if(Popularity != null && Popularity.length() > 0 && !Objects.equals(adSpace.getPopularity(), Popularity)){
            adSpace.setPopularity(Popularity);
        }

        if(Type != null && Type.length() > 0 && !Objects.equals(adSpace.getType(), Type)){
            adSpace.setType(Type);
        }

        if(Size != null && Size.length() > 0 && !Objects.equals(adSpace.getSize(), Size)){
            adSpace.setSize(Size);
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

        if(Position != null && Position.length() > 0 && !Objects.equals(adSpace.getPosition(), Position)){
            adSpace.setPosition(Position);
        }

        if(Index != null && Index.length() > 0 && !Objects.equals(adSpace.getIndex(), Index)){
            adSpace.setIndex(Index);
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
