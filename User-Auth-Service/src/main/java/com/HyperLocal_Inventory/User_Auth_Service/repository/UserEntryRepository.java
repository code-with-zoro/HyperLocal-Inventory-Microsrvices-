package com.HyperLocal_Inventory.User_Auth_Service.repository;

import com.HyperLocal_Inventory.User_Auth_Service.entity.UserEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntryRepository extends MongoRepository<UserEntry , ObjectId> {
    boolean existsByEmail (String userName);
    UserEntry getEmailById(ObjectId id);
    UserEntry getById(ObjectId id);
    UserEntry getByUserName(String username);

}
