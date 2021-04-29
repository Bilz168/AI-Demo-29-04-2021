package com.doom_tp.game.entities;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.doom_tp.game.world.GameMap;

@SuppressWarnings("rawtypes")
public enum EntityType {
	//A list of all the sprite objects
	PLAYER("player", Player.class, 14, 32, 40),
	Enemy1("Enemy1",Enemy1.class,15,28,100),
	Enemy2("Enemy2",Enemy2.class,15,28,100),
	Enemy3("Enemy3",Enemy3.class,15,28,50),
	Enemy4("Enemy4",Enemy4.class,15,28,40),
	Enemy5("Enemy5",Enemy5.class,15,28,40),
	Enemy6("Enemy6",Enemy6.class,25,35,0),
	Attack("Attack",Attack.class,25,20,40);
	
	
	private String id;
	private Class loaderClass;
	private int width, height;
	private float weight;
	
	private EntityType(String id, Class loaderClass, int width, int height, float weight) {
		this.id = id;
		this.loaderClass = loaderClass;
		this.width = width;
		this.height = height;
		this.weight = weight;
	}

	public String getId() {
		return id;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public float getWeight() {
		return weight;
	}

	private static HashMap<String, EntityType> entityTypes; 

	static {
		entityTypes = new HashMap<String, EntityType>();
		for (EntityType type : EntityType.values())
			entityTypes.put(type.id, type);
	}

}
