package com.HyperLocal_Inventory.Loaction_Service.repository;

import com.HyperLocal_Inventory.Loaction_Service.entity.UserEntity;
import com.HyperLocal_Inventory.Loaction_Service.enums.Roles;
import org.bson.types.ObjectId;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.Optional;

@Repository
public interface LocationRepository extends MongoRepository<UserEntity , ObjectId> {

    boolean existsByUserId(String userId);

    Optional<UserEntity> findByUserId(String userId);


    List<UserEntity> findByLocationNearAndRoles(Point userPoint, Distance radius, Roles roles);
}
