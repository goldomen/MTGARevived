package com.example.summertrudvang.domain;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class Rulebooks {

    @Id
    private Long id;

    @Column
    @NotNull
    private Long game_id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private Instant created;

    @Column
    private Instant lastUpdated;

    public Rulebooks(Long game_id, String name) {
        this.game_id = game_id;
        this.name = name;
        this.created = Instant.now();
    }

    public Long getGame_id() {
        return game_id;
    }

    public void setGame_id(Long game_id) {
        this.game_id = game_id;
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
