package com.demo.advertising.general_management.services;

import com.demo.advertising.general_management.data.entities.BookingEntity;
import com.demo.advertising.general_management.data.entities.CustomerEntity;
import com.demo.advertising.general_management.data.repositories.CustomerRepository;
import com.demo.advertising.general_management.services.models.Adspace;
import com.demo.advertising.general_management.data.entities.AdSpaceEntity;
import com.demo.advertising.general_management.data.repositories.AdSpaceRepository;
import com.demo.advertising.general_management.services.models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;


import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class AdSpaceService {

    //make AdSpaceId generate random without output
    //make getAdSpace work by filters
    //make deleteAdSpace work
    //make updateAdSpace work

    @Autowired
    AdSpaceRepository adSpaceRepository;

    @Autowired
    ModelMapper mapper;

    //create resource
    public String createAdSpace(Adspace space) {
        AdSpaceEntity adSpaceEntity = mapper.map(space, AdSpaceEntity.class);
        adSpaceEntity.setSpaceId(UUID.randomUUID().toString());
        adSpaceEntity = adSpaceRepository.save(adSpaceEntity);
        return adSpaceEntity.getSpaceId();
    }

    //read resource
    public Adspace getAdSpace(String SpaceId) {
        AdSpaceEntity AdSpaceEntityToFind = new AdSpaceEntity();
        AdSpaceEntityToFind.setSpaceId(SpaceId);
        Optional<AdSpaceEntity> retrievedResourceEntity =
                adSpaceRepository.findOne(Example.of(AdSpaceEntityToFind, ExampleMatcher.matchingAll()));

        return retrievedResourceEntity.map(adSpaceEntity -> mapper.map(adSpaceEntity, Adspace.class)).orElse(null);
    }

    //update resource
    public void updateAdSpace(String SpaceId, Adspace newSpace){
        Adspace space = getAdSpace(SpaceId); //find ad space
        if (space != null) space = newSpace;   //assign new variables
    }

    /*

    //delete resource
    public void deleteAdSpace(String SpaceId){
        Adspace space = getAdSpace(SpaceId);
        if (space != null) adSpaceRepository.delete(space);
    }

     */
}
