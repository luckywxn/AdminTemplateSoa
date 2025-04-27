package com.strongculture.service.repository;

import com.strongculture.service.contact.entity.TokenSession;

public interface SessionRepository {
    Boolean saveSession(TokenSession session);
    TokenSession getSession(String token);
    Boolean setValue(TokenSession session,String key,String value);
    String getValue(TokenSession session,String key);

    void removeSession(String token);
}
