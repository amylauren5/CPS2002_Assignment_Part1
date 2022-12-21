package com.demo.advertising.general_management.services;

import com.demo.advertising.general_management.services.models.Adspace;
import com.demo.advertising.general_management.data.entities.AdSpaceEntity;
import com.demo.advertising.general_management.data.repositories.AdSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;


import java.util.Optional;
import java.util.UUID;

@Service
public class AdSpaceService {

    @Autowired
    AdSpaceRepository repository;

    @Autowired
    ModelMapper mapper;

    //create resource
    public void createAdSpace(Adspace space) {
        AdSpaceEntity adSpaceEntity = mapper.map(space, AdSpaceEntity.class);
        //adSpaceEntity.setSpaceId(UUID.randomUUID().toString());
        repository.save(adSpaceEntity);
    }

    //read resource
    public Adspace getAdSpace(String SpaceId) {
        AdSpaceEntity AdSpaceEntityToFind = new AdSpaceEntity();
        AdSpaceEntityToFind.setSpaceId(SpaceId);

        Optional<AdSpaceEntity> retrievedResourceEntity =
                repository.findOne(Example.of(AdSpaceEntityToFind, ExampleMatcher.matchingAll()));

        if (retrievedResourceEntity.isEmpty()) return null;

        Adspace space = mapper.map(retrievedResourceEntity.get(), Adspace.class);

        return space;
    }

    //update resource
    public void updateAdSpace(String SpaceId, Adspace newSpace){
        Adspace space = getAdSpace(SpaceId); //find ad space
        if (space != null) space = newSpace;   //assign new variables
    }

    //delete resource
    public void deleteAdSpace(String SpaceId){
        Adspace space = getAdSpace(SpaceId);
        if (space != null) repository.delete(space);
    }
}
