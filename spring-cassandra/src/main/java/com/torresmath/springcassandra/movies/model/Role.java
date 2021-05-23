package com.torresmath.springcassandra.movies.model;

public class Role {

    private final String actorName;
    private final String characterName;

    public Role(String actorName, String characterName) {
        this.actorName = actorName;
        this.characterName = characterName;
    }

    public String getActorName() {
        return actorName;
    }

    public String getCharacterName() {
        return characterName;
    }
}
