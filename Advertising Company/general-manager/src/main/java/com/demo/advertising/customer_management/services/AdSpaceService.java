package com.demo.advertising.customer_management.services;

import com.demo.advertising.customer_management.models.Adspace;
import com.demo.advertising.customer_management.data.entities.ResourceEntity;
import com.demo.advertising.customer_management.data.repositories.ResourceRepository;
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
    ResourceRepository repository;

    @Autowired
    ModelMapper mapper;

    //create resource
    public String createResource(Adspace space) {
        ResourceEntity ResourceEntity = mapper.map(space, ResourceEntity.class);
        ResourceEntity.setSpaceId(UUID.randomUUID().toString());
        ResourceEntity = repository.save(ResourceEntity);
        return ResourceEntity.getSpaceId();
    }

    //read resource
    public Adspace getResource(String SpaceId) {
        ResourceEntity ResourceEntityToFind = new ResourceEntity();
        ResourceEntityToFind.setSpaceId(SpaceId);

        Optional<ResourceEntity> retrievedResourceEntity =
                repository.findOne(Example.of(ResourceEntityToFind, ExampleMatcher.matchingAll()));

        if (retrievedResourceEntity.isEmpty()) return null;

        Adspace space = mapper.map(retrievedResourceEntity.get(), Adspace.class);

        return space;
    }

    //update resource
    //delete resource
}
