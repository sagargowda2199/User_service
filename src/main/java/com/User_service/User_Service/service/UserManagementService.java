package com.User_service.User_Service.service;

import com.User_service.User_Service.dto.UserManagementDto;
import com.User_service.User_Service.entity.UserManagementEntity;
import com.User_service.User_Service.repository.UserManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserManagementService {

    @Autowired
    UserManagementRepository userManagementRepository;

    public UserManagementEntity registerNewUser(UserManagementDto userManagementDto) {
        UserManagementEntity userManagementEntity = new UserManagementEntity();
        userManagementEntity.setUserId(userManagementDto.getUserid());
        userManagementEntity.setUsername(userManagementDto.getName());
        userManagementEntity.setUsermail((userManagementDto.getUsermail()));
        userManagementEntity.setPhoneNo(userManagementDto.getPhonenum());
        userManagementEntity.setPassword(userManagementDto.getPasword());
        return userManagementRepository.save(userManagementEntity);
    }

    public Optional<UserManagementEntity> getUserById(Integer userId) {
        return userManagementRepository.findById(userId);
    }

    public UserManagementEntity updateUser(Integer userId, UserManagementDto userManagementDto) {
        UserManagementEntity userEntity = userManagementRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        userEntity.setUsername(userManagementDto.getName());
        userEntity.setUsermail(userManagementDto.getUsermail());
        userEntity.setPhoneNo(userManagementDto.getPhonenum());
        return userManagementRepository.save(userEntity);
    }

    public void deleteUser(Integer userId) {
        if (userManagementRepository.existsById(userId)) {
            userManagementRepository.deleteById(userId);
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
