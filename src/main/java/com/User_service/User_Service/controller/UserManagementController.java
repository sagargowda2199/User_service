package com.User_service.User_Service.controller;

import com.User_service.User_Service.dto.UserManagementDto;
import com.User_service.User_Service.dto.UserManagementResponse;
import com.User_service.User_Service.entity.UserManagementEntity;
import com.User_service.User_Service.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Controller
@RequestMapping("/api/user")
public class UserManagementController {

    @Autowired
    UserManagementService userManagementService;


    //registration of new user
    @PostMapping("/register-new-user")
    public ResponseEntity<UserManagementEntity> registerNewUser(@RequestBody UserManagementDto userManagementDto) {
        UserManagementEntity userDetails = userManagementService.registerNewUser(userManagementDto);
        return ResponseEntity.ok(userDetails);
    }

    //retrieval of all users
    @GetMapping("/get-all-users")
    public ResponseEntity<UserManagementResponse> getUserById(@RequestParam("userId") Integer userId) {
        Optional<UserManagementEntity> userEntity = userManagementService.getUserById(userId);

        if (userEntity.isPresent()) {
            UserManagementEntity user = userEntity.get();
            UserManagementResponse response = new UserManagementResponse();
            response.setUserId(user.getUserId());
            response.setUsername(user.getUsername());
            response.setUserMail(user.getUsermail());
            response.setPhoneNum(user.getPhoneNo());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Update user
    @PutMapping("/update-user")
    public ResponseEntity<UserManagementResponse> updateUser(@RequestParam("userId") Integer userId, @RequestBody UserManagementDto userManagementDto) {
        UserManagementEntity updatedUser = userManagementService.updateUser(userId, userManagementDto);
        UserManagementResponse response = new UserManagementResponse();
        response.setUserId(updatedUser.getUserId());
        response.setUsername(updatedUser.getUsername());
        response.setUserMail(updatedUser.getUsermail());
        response.setPhoneNum(updatedUser.getPhoneNo());
        return ResponseEntity.ok(response);
    }

    //delete user
    @DeleteMapping("/delete-user")
    public ResponseEntity<Void> deleteUser(@RequestParam("userId") Integer userId) {
        userManagementService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    //Manage user roles
    @PostMapping("/manage-user-role")
    public ResponseEntity<UserManagementResponse> manageUserRole(UserManagementDto userManagementDto) {
        return null;
    }
}
