package com.doom_tp.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.doom_tp.game.world.GameMap;

public class Attack extends Entity{
	Texture image;
	
	public Attack(float x, float y, GameMap map) {
		super(x, y, EntityType.Attack, map);
		image = new Texture("Circle.png");//Enemy Image
	}

	@Override
	public void update(float deltaTime, float gravity) {
		moveAttack(4);
	}
	
	@Override
	public void render(SpriteBatch batch) {
		batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
	}
	
	
}
