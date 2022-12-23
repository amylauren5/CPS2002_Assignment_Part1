package com.demo.advertising.general_management.services;

import com.demo.advertising.general_management.data.entities.AdSpaceEntity;
import com.demo.advertising.general_management.data.repositories.AdSpaceRepository;
import com.demo.advertising.general_management.services.models.Adspace;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


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

    public Adspace getAdSpace(String SpaceId) {
        AdSpaceEntity adSpaceEntityToFind = new AdSpaceEntity();
        adSpaceEntityToFind.setSpaceId(SpaceId);

        Optional<AdSpaceEntity> retrievedOrderEntity =
                adSpaceRepository.findOne(Example.of(adSpaceEntityToFind, ExampleMatcher.matchingAll()));

        if (retrievedOrderEntity.isEmpty()) return null;

        Adspace space = mapper.map(retrievedOrderEntity, Adspace.class);

        return space;
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
