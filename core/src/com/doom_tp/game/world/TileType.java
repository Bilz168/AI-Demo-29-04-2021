package com.doom_tp.game.world;

import java.util.HashMap;

public enum TileType {

	GRASS(1, true, "Grass"),
	DIRT(2, true, "Dirt"),
	STONE(3, true, "Stone"),
	COBBLE(4, true, "Cobblestone"),
	CIBBLE(5, true, "Cibblestone"),
	CLAY(6, true, "Clay"),
	SAND(7, true, "Sand"),
	LOG(8, false, "Log"),
	LEAVES(9, true, "Leaves"),
	WATER(10, false, "Water"),
	LAVA(11, false, "Lava"),
	CLOUD(12, true, "Cloud"),
	SKY(13, false, "Sky"),
	STONEBACK(14, false, "Stone background"),
	DIRTBACK(15, false, "Dirt background"),
	COBBLEBACK(16, false, "Cobblestone background"),
	CIBBLEBACK(17, false, "Cibblestone background"),
	CLAYBACK(18, false, "Clay background"),
	SANDBACK(19, false, "Sand background"),
	BARRIER(20, true, "Barrier"),
	DOORBOTTOM(21, false, "Door Bottom"),
	DOORTOP(22, false, "Door Top");
	
	
	public static final int TILE_SIZE = 16;
	
	private int id;
	private boolean collidable;
	private String name;
	private float damage;

	private TileType (int id, boolean collidable, String name) {
		this(id, collidable, name, 0);
	}
	
	private TileType (int id, boolean collidable, String name, float damage) {
		this.id = id;
		this.collidable = collidable;
		this.name = name;
		this.damage = damage;
	}

	public int getId() {
		return id;
	}

	public boolean isCollidable() {
		return collidable;
	}

	public String getName() {
		return name;
	}

	public float getDamage() {
		return damage;
	}
	
	private static HashMap<Integer, TileType> tileMap;
	
	static {
		tileMap = new HashMap<Integer, TileType>();
		for (TileType tileType : TileType.values()) {
			tileMap.put(tileType.getId(), tileType);
		}
		
	}
	
	public static TileType getTileTypeById(int id) {
		return tileMap.get(id);
	}
	
}
