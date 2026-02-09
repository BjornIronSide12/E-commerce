package com.ecommerce.userservice.repository;

import com.ecommerce.userservice.entity.SessionEntity;
import com.ecommerce.userservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface SessionRepository extends JpaRepository<SessionEntity, UUID> {

    SessionEntity findByToken(String token);
    List<SessionEntity> findAllByUser(UserEntity user);
}

