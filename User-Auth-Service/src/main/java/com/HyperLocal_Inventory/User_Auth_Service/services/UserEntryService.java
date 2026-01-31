package com.HyperLocal_Inventory.User_Auth_Service.services;


import com.HyperLocal_Inventory.User_Auth_Service.DTOs.*;
import com.HyperLocal_Inventory.User_Auth_Service.entity.UserEntry;
import com.HyperLocal_Inventory.User_Auth_Service.exception.EmailAlreadyExistsException;
import com.HyperLocal_Inventory.User_Auth_Service.exception.UserDoNotExistsException;
import com.HyperLocal_Inventory.User_Auth_Service.mapper.UserMapper;
import com.HyperLocal_Inventory.User_Auth_Service.repository.UserEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserEntryService {

    private final UserEntryRepository userEntryRepository;
    private final PasswordEncoder passwordEncoder;

    public UserEntryService(UserEntryRepository userEntryRepository, PasswordEncoder passwordEncoder) {
        this.userEntryRepository = userEntryRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<AdminResponseDTO> getAllUsers(){
        return userEntryRepository.findAll().stream().map(UserMapper :: toAdminResponse).toList();
    }



    public SignupResponseDTO saveUser(UserRequestDTO newUser){
        if(userEntryRepository.existsByEmail(newUser.getEmail())){
            throw new EmailAlreadyExistsException("User With This Email Already Exists : "+newUser.getEmail());
        }
            UserEntry save = UserMapper.toModel(newUser);
        save.setRoles(newUser.getRoles());
        save.setLocation(null);
        save.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userEntryRepository.save(save);
        return UserMapper.toNewUserDto(save);
    }

    public UpdateResponseDTO updateUser(String id, UserRequestDTO updated){
        ObjectId userId = new ObjectId(id);
        UserEntry toUpdate = userEntryRepository.findById(userId).orElseThrow(() -> new UserDoNotExistsException("User Do Not Exists"));

        if(userEntryRepository.existsByEmail(toUpdate.getEmail()) && !toUpdate.getEmail().equals(updated.getEmail())){
            throw new EmailAlreadyExistsException("User With This Email Already Exists : "+updated.getEmail());
        }
        toUpdate.setUserName(updated.getUserName());
        toUpdate.setEmail(updated.getEmail());
        toUpdate.setPassword(passwordEncoder.encode(updated.getPassword()));
        UserEntry saved = userEntryRepository.save(toUpdate);
        return UserMapper.updatedResponse(saved);
    }

    public DeleteResponseDTO deleteUser(String id){
        ObjectId userId = new ObjectId(id);
        UserEntry toDelete = userEntryRepository.findById(userId).orElseThrow(()-> new UserDoNotExistsException("User Do Not Exists"));
        userEntryRepository.delete(toDelete);
        return UserMapper.toDeleted(toDelete);
    }
}

