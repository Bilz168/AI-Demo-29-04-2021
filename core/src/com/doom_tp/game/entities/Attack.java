package com.doom_tp.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.doom_tp.game.world.GameMap;

//The bullet that the player shoots
public class Attack extends Entity{
	Texture image;
	
	public Attack(float x, float y, GameMap map) {
		super(x, y, EntityType.Attack, map);//Creates the object in Entity.class
		image = new Texture("Circle.png");//Enemy Image
	}

	@Override
	public void update(float deltaTime, float gravity) {
		moveAttack(3);//(Movement speed)
	}
	
	@Override
	public void render(SpriteBatch batch) {
		batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
	}
	
	
}
