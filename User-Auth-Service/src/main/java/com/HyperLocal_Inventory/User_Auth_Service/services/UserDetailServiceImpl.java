package com.HyperLocal_Inventory.User_Auth_Service.services;

import com.HyperLocal_Inventory.User_Auth_Service.entity.UserEntry;
import com.HyperLocal_Inventory.User_Auth_Service.exception.UserDoNotExistsException;
import com.HyperLocal_Inventory.User_Auth_Service.repository.UserEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserEntryRepository userEntryRepository;

    public UserDetailServiceImpl(UserEntryRepository userEntryRepository) {
        this.userEntryRepository = userEntryRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String value) throws UsernameNotFoundException {
        UserEntry user;
        if (ObjectId.isValid(value)) {
            ObjectId userId = new ObjectId(value);
            user = userEntryRepository.getById(userId);
        } else {
            user = userEntryRepository.getByUserName(value);
        }
        if (user == null) {
            throw new UserDoNotExistsException("User Do Not Exist of UserName: " + user.getUserName());
        }
            return User.builder()
                    .username(user.getUserName())
                    .password(user.getPassword())
                    .roles(String.valueOf(user.getRoles()))
                    .build();

            /*UserDetails buildUser = User.builder()
                    .username(user.getUserName())
                    .password(user.getPassword())
                    .roles(user.getRoles().toString())
                    .build();
            return buildUser;*/
    }
}
