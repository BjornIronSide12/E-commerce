package com.ecommerce.userservice.service;

import com.ecommerce.userservice.entity.SessionEntity;
import com.ecommerce.userservice.entity.UserEntity;
import org.apache.catalina.User;

import java.util.UUID;

public interface SessionService {

    // Explicit: Creates a session for this specific user
    SessionEntity createSession(UserEntity user);

    // Explicit: Deletes ONLY the session matching this token (Standard Logout)
    void deleteSession(String token);

    // Optional: Only if you support "Log out of all devices"
    void revokeAllSessions(UserEntity user);
}
