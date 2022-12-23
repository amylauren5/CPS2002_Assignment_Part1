package com.demo.advertising.general_management.data.repositories;

import com.demo.advertising.general_management.data.entities.AdSpaceEntity;
import com.demo.advertising.general_management.data.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AdSpaceRepository extends JpaRepository<AdSpaceEntity, String> {

/*    @Query("SELECT c FROM AdSpaceEntity c WHERE c.SpaceId = ?1")
    Optional<AdSpaceEntity> fineAdSpacebyId(String SpaceId);

    @Query("SELECT c FROM AdSpaceEntity c WHERE c.Popularity = ?1")
    Optional<AdSpaceEntity> findAdSpacerByPopularity(String Popularity);

    @Query("SELECT c FROM AdSpaceEntity c WHERE c.Type = ?1")
    Optional<AdSpaceEntity> findAdSpaceByType(String Type);

    @Query("SELECT c FROM AdSpaceEntity c WHERE c.Price = ?1")
    Optional<AdSpaceEntity> findAdSpacePrice(String Price);

    @Query("SELECT c FROM AdSpaceEntity c WHERE c.Size = ?1")
    Optional<AdSpaceEntity> findAdSpaceSize(String Size);

    @Query("SELECT c FROM AdSpaceEntity c WHERE c.Location = ?1")
    Optional<AdSpaceEntity> findAdSpaceLocation(String Location);

    @Query("SELECT c FROM AdSpaceEntity c WHERE c.BusRoute = ?1")
    Optional<AdSpaceEntity> findAdSpaceBusRoute(String BusRoute);*/
}
