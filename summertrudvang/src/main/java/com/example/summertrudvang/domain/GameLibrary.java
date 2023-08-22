package com.example.summertrudvang.domain;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class GameLibrary{
    public GameLibrary(Long gameId, String name) {
        this.gameId = gameId;
        this.name = name;
        this.created = Instant.now();
    }

    @Id
    private Long id;

    @Column
    @NotNull
    private Long gameId;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private Instant created;

    @Column
    private Instant lastUpdated;

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
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
