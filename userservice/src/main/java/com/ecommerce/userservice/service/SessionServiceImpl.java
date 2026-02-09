package com.ecommerce.userservice.service;

import com.ecommerce.userservice.entity.SessionEntity;
import com.ecommerce.userservice.entity.UserEntity;
import com.ecommerce.userservice.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;

    public SessionServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public SessionEntity createSession(UserEntity user) {
        SessionEntity sessionEntity = new SessionEntity(user);
        sessionRepository.save(sessionEntity);
        return sessionEntity;
    }

    @Override
    public void deleteSession(String token) {
        SessionEntity sessionEntity = sessionRepository.findByToken(token);
        sessionRepository.delete(sessionEntity);
    }

    @Override
    public void revokeAllSessions(UserEntity user) {
        List<SessionEntity> sessions = sessionRepository.findAllByUser(user);
        for (SessionEntity sessionEntity : sessions) {
            sessionRepository.delete(sessionEntity);
        }
    }
}
