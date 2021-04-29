package com.doom_tp.game.entities;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.doom_tp.game.world.GameMap;

public class EntityLoader {

    private static Json json = new Json();
    
    public static ArrayList<Entity> loadEntities (String id, GameMap map) {
		Gdx.files.internal(id + ".json");
		FileHandle file = Gdx.files.internal(id + ".json");
		if (file.exists()) {
			EntitySnapshot[] snapshots = json.fromJson(EntitySnapshot[].class, file.readString());
            ArrayList<Entity> entities = new ArrayList<Entity>();
            for (EntitySnapshot snapshot : snapshots) {
                entities.add(EntityType.createEntityUsingSnapshot(snapshot, map));
            }
			return entities;
		}
		else {
			Gdx.app.error("EntityLoader", "Could not load entities.");
			return null;
		}
			
	}
}
