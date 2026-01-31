package com.HyperLocal_Inventory.Loaction_Service.mapper;

import com.HyperLocal_Inventory.Loaction_Service.DTOs.EntryRequestDTO;
import com.HyperLocal_Inventory.Loaction_Service.DTOs.EntryResponseDTO;
import com.HyperLocal_Inventory.Loaction_Service.DTOs.SearchResponseDTO;
import com.HyperLocal_Inventory.Loaction_Service.DTOs.UpdateResponseDTO;
import com.HyperLocal_Inventory.Loaction_Service.entity.UserEntity;

import java.time.LocalDateTime;
import java.util.List;

public class LoactionMapper {

    public static UserEntity toModel(String userId , EntryRequestDTO newEntry){
        UserEntity newUser = new UserEntity();
        newUser.setUserId(userId);
        newUser.setRoles(newEntry.getRoles());
        newUser.setlocation(newEntry.getLocation());
        newUser.setCreatedAt(LocalDateTime.now());
        newUser.setUpdatedAt(LocalDateTime.now());
        return newUser;
    }

    public static EntryResponseDTO toEntryResponse(UserEntity save) {
        EntryResponseDTO response = new EntryResponseDTO();
        response.setUserId(save.getUserId());
        response.setRoles(save.getRoles());
        response.setLocation(save.getlocation());
        return response;
    }

    public static UpdateResponseDTO toUpdateResponse(UserEntity toUpdate) {
        UpdateResponseDTO updated = new UpdateResponseDTO();
        updated.setUserId(toUpdate.getUserId());
        updated.setLocation(toUpdate.getlocation());
        updated.setRoles(toUpdate.getRoles());
        updated.setUpdateAt(toUpdate.getUpdatedAt());
        return updated;
    }

    public static SearchResponseDTO toSearchResponse(List<String> user){
        SearchResponseDTO search = new SearchResponseDTO();
        search.setVendorIds(user == null ? List.of() : user);
        return search;
    }
}
