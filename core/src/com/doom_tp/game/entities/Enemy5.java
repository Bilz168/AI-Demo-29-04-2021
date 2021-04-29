package com.doom_tp.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.doom_tp.game.world.GameMap;


//Same as Enemy1.java
public class Enemy5 extends Entity{
	Texture image;
	protected GameMap map;
	
	public Enemy5(float x, float y, GameMap map) {
		super(x, y, EntityType.Enemy5, map);
		image = new Texture("Enemy.png");//Enemy Image
	}

	@Override //Movement
	public void update(float deltaTime, float gravity) {
		super.update(deltaTime, 0);
		move();
	}
	public void move(){
		moveEnemy5(10);
	}
	
	@Override
	public void render(SpriteBatch batch) {
		batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
	}

	
	
}
