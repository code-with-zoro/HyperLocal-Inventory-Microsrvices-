package com.HyperLocal_Inventory.User_Auth_Service.mapper;

import com.HyperLocal_Inventory.User_Auth_Service.DTOs.*;
import com.HyperLocal_Inventory.User_Auth_Service.entity.UserEntry;


public class UserMapper {
    //Jo user Entry se aarha hai usko offial Entity me map ho rha hai jo database me store hoga
    public static UserEntry toModel(UserRequestDTO userRequestDTO){
        UserEntry newUser = new UserEntry();
        newUser.setUserName(userRequestDTO.getUserName());
        newUser.setPassword(userRequestDTO.getPassword());
        newUser.setEmail(userRequestDTO.getEmail());
        newUser.setRoles(userRequestDTO.getRoles());
        newUser.setLocation(userRequestDTO.getLocation());
        return newUser;
    }
    //Response At the time of creation of new user
    public static SignupResponseDTO toNewUserDto(UserEntry userEntry){
        SignupResponseDTO newUser = new SignupResponseDTO();
        newUser.setUserName(userEntry.getUserName());
        newUser.setEmail(userEntry.getEmail());
        newUser.setRole(userEntry.getRoles());
        return newUser;
    }

    //Response for admin
    public static AdminResponseDTO toAdminResponse(UserEntry users){
        AdminResponseDTO user = new AdminResponseDTO();
        user.setUserName(users.getUserName());
        user.setEmail(users.getEmail());
        user.setRole(users.getRoles());
        return user;
    }

    //Updated Response
    public static UpdateResponseDTO updatedResponse(UserEntry user){
        UpdateResponseDTO updated = new UpdateResponseDTO();
        updated.setUserName(user.getUserName());
        updated.setEmail(user.getEmail());
        updated.setPassword(user.getPassword());
        return updated;
    }

    //Delete Response
    public static DeleteResponseDTO toDeleted(UserEntry user){
        DeleteResponseDTO toDelete = new DeleteResponseDTO();
        toDelete.setUserName(user.getUserName());
        toDelete.setEmail(user.getEmail());
        return toDelete;
    }
}
