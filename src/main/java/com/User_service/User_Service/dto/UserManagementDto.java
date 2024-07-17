package com.User_service.User_Service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserManagementDto {
    private Integer userid;
    private String name;
    private String usermail;
    private String phonenum;
    private String pasword;
}
