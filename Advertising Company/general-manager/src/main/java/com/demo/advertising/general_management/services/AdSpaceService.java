package com.demo.advertising.general_management.services;

import com.demo.advertising.general_management.data.entities.AdSpaceEntity;
import com.demo.advertising.general_management.data.repositories.AdSpaceRepository;
import com.demo.advertising.general_management.services.models.Adspace;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class AdSpaceService {

    //make AdSpaceId generate random without output
    //make getAdSpace work by filters
    //make deleteAdSpace work
    //make updateAdSpace work

    @Autowired
    ModelMapper mapper;

    @Autowired
    AdSpaceRepository adSpaceRepository;

    //create resource
    public String createAdSpace(Adspace space) {
        AdSpaceEntity adSpaceEntity = mapper.map(space, AdSpaceEntity.class);
        adSpaceEntity.setSpaceId(UUID.randomUUID().toString());
        adSpaceEntity = adSpaceRepository.save(adSpaceEntity);
        return adSpaceEntity.getSpaceId();
    }

    public List<Adspace> getAdSpace(String FilterBy, String Filter) {
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
        }else if(Objects.equals(FilterBy, "Location")){
            adSpaceEntityToFind.setLocation(Filter);
        }else if(Objects.equals(FilterBy, "BusRoute")){
            adSpaceEntityToFind.setBusRoute(Filter);
        }

        List<AdSpaceEntity> retrievedOrderEntity =
                adSpaceRepository.findAll(Example.of(adSpaceEntityToFind, ExampleMatcher.matchingAll()));

        if (retrievedOrderEntity.isEmpty()) return null;

        List<Adspace> spaces = retrievedOrderEntity
                .stream()
                .map(user -> mapper.map(user, Adspace.class))
                .collect(Collectors.toList());

        return spaces;
    }

    //update resource
    public void updateAdSpace(String SpaceId, Adspace newSpace){

    }

    /*

    //delete resource
    public void deleteAdSpace(String SpaceId){
        Adspace space = getAdSpace(SpaceId);
        if (space != null) adSpaceRepository.delete(space);
    }

     */
}
