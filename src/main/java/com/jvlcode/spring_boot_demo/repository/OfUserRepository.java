package com.jvlcode.spring_boot_demo.repository;

import com.jvlcode.spring_boot_demo.entity.OfUsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfUserRepository extends JpaRepository<OfUsersEntity,Long> {
    OfUsersEntity findByUsername(String username);
}
