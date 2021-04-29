package com.doom_tp.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.doom_tp.game.world.GameMap;


public class Player extends Entity {

	private static final int SPEED = 80;
	private static final int JUMP_VELOCITY = 5;
	private Sound sound; 
	Texture image;

	public Player(float x, float y, GameMap map) {
		super(x, y, EntityType.PLAYER, map);
		image = new Texture("karlpelab.png");//Enemy Image
		sound = Gdx.audio.newSound(Gdx.files.internal("Jump effect.wav"));//Jump sound effect
	}
	
	@Override
	public void update(float deltaTime, float gravity) {
		if (Gdx.input.isKeyPressed(Keys.SPACE) && grounded) {//Makes the player jump off the ground
			this.velocityY += JUMP_VELOCITY * getWeight();
			long id = sound.play(0.5f);
			sound.setPitch(id, 2);
			sound.setLooping(id,false);
		} else if (Gdx.input.isKeyPressed(Keys.SPACE) && !grounded && this.velocityY > 0) {//Controlling the player's jump while they are in the air
			this.velocityY += JUMP_VELOCITY * getWeight() * deltaTime;
		}
			
		super.update(deltaTime, gravity); // Applies Gravity
		
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {//Moves the player left
			moveX(-SPEED * deltaTime);
		}
		
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {//Moves the player right
			moveX(SPEED * deltaTime);
		}
	}
	
	public float getPlayerX() {
		return pos.x;
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
	}


}
