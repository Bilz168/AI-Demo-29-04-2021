package com.doom_tp.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.doom_tp.game.world.GameMap;

//The 1st enemy
public class Enemy1 extends Entity{
	Texture image;//Image
	protected GameMap map;
	
	public Enemy1(float x, float y, GameMap map) {//Constructor
		super(x, y, EntityType.Enemy1, map);
		image = new Texture("Enemy.png");//Enemy Image
	}

	@Override //Movement
	public void update(float deltaTime, float gravity) {
		super.update(deltaTime, gravity);
		move();
	}
	public void move(){
		moveEnemy1(1);//Movement function in Entity
	}
	
	@Override
	public void render(SpriteBatch batch) {
		batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
	}

	
	
}
