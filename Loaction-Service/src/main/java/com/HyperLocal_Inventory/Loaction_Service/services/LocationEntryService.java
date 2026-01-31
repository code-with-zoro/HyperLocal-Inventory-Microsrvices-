package com.HyperLocal_Inventory.Loaction_Service.services;

import com.HyperLocal_Inventory.Loaction_Service.DTOs.*;
import com.HyperLocal_Inventory.Loaction_Service.entity.UserEntity;
import com.HyperLocal_Inventory.Loaction_Service.enums.Roles;
import com.HyperLocal_Inventory.Loaction_Service.exceptions.UserAlreadyExistsException;
import com.HyperLocal_Inventory.Loaction_Service.exceptions.UserNotFoundException;
import com.HyperLocal_Inventory.Loaction_Service.mapper.LoactionMapper;
import com.HyperLocal_Inventory.Loaction_Service.repository.LocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LocationEntryService {

    private static final Logger log = LoggerFactory.getLogger(LocationEntryService.class);
    private final LocationRepository locationRepository;

    public LocationEntryService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<EntryResponseDTO> getAll(){
        return locationRepository.findAll().stream().map(LoactionMapper :: toEntryResponse).toList();
    }

    public EntryResponseDTO saveLocation(String userId,EntryRequestDTO newUser){
        if(locationRepository.existsByUserId(userId)){
            throw new UserAlreadyExistsException("User Already Exists  , Try To Update User" +userId );
        }
        UserEntity save = locationRepository.save(LoactionMapper.toModel(userId,newUser));
        return LoactionMapper.toEntryResponse(save);
    }

    public UpdateResponseDTO updateLocation(String id , UpdateRequestDTO location){
        UserEntity toUpdate = locationRepository.findByUserId(id)
                .orElseThrow(()-> new UserNotFoundException("User With This usserId Do Not Exists:- " + id));
        toUpdate.setlocation(location.getLocationToUpdate());
        toUpdate.setUpdatedAt(LocalDateTime.now());
        UserEntity saved = locationRepository.save(toUpdate);
        return LoactionMapper.toUpdateResponse(saved);
    }


    //to get all vendor near that user
    public SearchResponseDTO searchResult(SearchRequestDTO search ){
        log.info(search.getUserId());
        UserEntity user = locationRepository.findByUserId(search.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User Location Is Not Listed"));

        GeoJsonPoint userPoint = user.getlocation();

        /*Point userPoint = new Point(
                userLocation.getX(), userLocation.getY()
        );*/

        Distance searchRadius = new Distance(search.getRadius() , Metrics.KILOMETERS);


        List<UserEntity> nearByVendors = locationRepository.findByLocationNearAndRoles(userPoint, searchRadius, Roles.VENDOR);
         List<String> vendors= nearByVendors
                .stream()
                 .limit(search.getLimit())
                .map(UserEntity::getUserId)
                .toList();
        return LoactionMapper.toSearchResponse(vendors) ;
    }
}
