package com.example.data.json.spell;

import com.example.data.Resource;
import com.example.data.json.game.GameObject;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(HealthGainSpell.class),
        @JsonSubTypes.Type(ManaGainSpell.class),
})
public abstract class Spell extends Resource {
    private int manaCost;

    public Spell(int manaCost) {
        this.manaCost = manaCost;
    }

    public int getManaCost() {
        return manaCost;
    }

    public abstract void apply(GameObject gameObject);
}
