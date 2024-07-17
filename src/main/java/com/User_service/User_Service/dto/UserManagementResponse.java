package com.User_service.User_Service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserManagementResponse {
    private Integer status;
    private String message;
    private Integer userId;
    private String username;
    private String userMail;
    private String phoneNum;
}
