package com.User_service.User_Service.repository;

import com.User_service.User_Service.entity.UserManagementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserManagementRepository extends JpaRepository<UserManagementEntity,Integer> {
}
