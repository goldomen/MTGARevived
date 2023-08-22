package com.example.summertrudvang.domain;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class Sessions {

    @Id
    private Long id;

    @Column
    @NotNull
    private Long gameId;

    @Column
    @NotNull
    private Long sessionId;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private Instant created;

    @Column
    private Instant lastUpdated;

    public Sessions(Long gameId, Long sessionId, String name) {
        this.gameId = gameId;
        this.sessionId = sessionId;
        this.name = name;
        this.created = Instant.now();
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Instant lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
