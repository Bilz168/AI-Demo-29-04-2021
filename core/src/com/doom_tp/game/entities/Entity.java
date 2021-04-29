package com.doom_tp.game.entities;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.IntIntMap;
import com.doom_tp.game.world.GameMap;

//Handles all of the sprites on the map
public abstract class Entity {
	protected Vector2 pos;
	protected EntityType type;//From EnemyType.java
	protected float velocityY = 0;
	protected GameMap map;//From GameMap.java
	protected boolean grounded = false;
	private boolean direction = false;
	private boolean attackDirection = false;
	
	//Constructor for the sprite that called this function
	public Entity(float x,float y,EntityType type, GameMap map) {
		this.pos = new Vector2(x,y);//Coordinate position
		this.type = type;//Type of sprite
		this.map = map;
	}
	
	public void update (float deltaTime, float gravity) {
		float newY = pos.y;//Constantly getting the Y coordinate of each sprite individually
		this.velocityY += gravity * deltaTime * getWeight();//Calculates the gravity for this sprite
		newY += this.velocityY * deltaTime;//Applies the new gravity
		
		if (map.collideMap(pos.x, newY, getWidth(), getHeight())) {//Is the sprite touching another object?
			if (velocityY < 0) {//Is the sprite on the ground
				this.pos.y = (float) Math.floor(pos.y);
				grounded = true;
			}
			this.velocityY = 0;
		}
		else {//Not on the ground: keep applying gravity
			this.pos.y = newY;
			grounded = false;
		}
	}
	
	public abstract void render (SpriteBatch batch);

	//Player movement
	protected void moveX(float amount) {
		float newX = pos.x + amount;//Gets a new X coordinate 
		if (!map.collideMap(newX, pos.y, getWidth(), getHeight())) {//Is there a wall in the way the player wants to go? 
			this.pos.x = newX;
		}
	}

	//Moves Enemy1
	protected void moveEnemy1(float amount) {
		if(!direction) {//Is it going right?
			float newX = pos.x+amount;
			float newY = pos.y+5;
			
			if(pos.x > 2335) {//Is it out of its section of the map?
				direction = true;//Go the other direction
			}else if(!map.collideMap(newX, pos.y, getWidth(), getHeight())) {//Can it move forward?
				pos.x = newX;//Move forward
			}else if(!map.collideMap(pos.x, newY, getWidth(), getHeight())) {//Can it move up?
				pos.y = newY;//Jump
			}
		}else if(direction) {//Is it going left?
			float newX = pos.x-amount;
			float newY = pos.y+5;
			
			if(pos.x < 1930) {//Is it out of its section of the map?
				direction = false;//Go the other direction
			}else if(!map.collideMap(newX, pos.y, getWidth(), getHeight())) {//Can it move forward?
				pos.x = newX;
			}else if(!map.collideMap(pos.x, newY, getWidth(), getHeight())) {//Can it move up?
				pos.y = newY;
			}
		}
	}
	
	//Moves Enemy2
	protected void moveEnemy2(float amount) {
		if(!direction) {//Is it going right?
			float newX = pos.x+amount;
			float newY = pos.y+5;
			
			if(pos.x > 2115) {//Is it out of its section of the map?
				direction = true;//Go the other direction
			}else if(!map.collideMap(newX, pos.y, getWidth(), getHeight())) {//Can it move forward?
				pos.x = newX;
			}else if(!map.collideMap(pos.x, newY, getWidth(), getHeight())) {//Can it move up?
				pos.y = newY;
			}
		}else if(direction) {//Is it going left?
			float newX = pos.x-amount;
			float newY = pos.y+5;
			
			if(pos.x < 1557) {//Is it out of its section of the map?
				direction = false;
			}else if(!map.collideMap(newX, pos.y, getWidth(), getHeight())) {//Can it move forward?
				pos.x = newX;
			}else if(!map.collideMap(pos.x, newY, getWidth(), getHeight())) {//Can it move up?
				pos.y = newY;
			}
		}
	}
	
	//Moves Enemy3
	protected void moveEnemy3(float amount) {
		if(!direction) {//Is it going right?
			float newX = pos.x+amount;
			float newY = pos.y+5;
			
			if(pos.x > 2306) {//Is it out of its section of the map?
				direction = true;//Go the other direction
			}else if(!map.collideMap(newX, pos.y, getWidth(), getHeight())) {//Can it move forward?
				pos.x = newX;
			}else if(!map.collideMap(pos.x, newY, getWidth(), getHeight())) {//Can it move up?
				pos.y = newY;
			}
		}else if(direction) {//Is it going left?
			float newX = pos.x-amount;
			float newY = pos.y+5;
			
			if(pos.x < 1140) {//Is it out of its section of the map?
				direction = false;//Go the other direction
			}else if(!map.collideMap(newX, pos.y, getWidth(), getHeight())) {//Can it move forward?
				pos.x = newX;
			}else if(!map.collideMap(pos.x, newY, getWidth(), getHeight())) {//Can it move up?
				pos.y = newY;
			}
		}
	}
	
	//Moves Enemy4
	protected void moveEnemy4(float amount) {
		pos.y -= amount;//Decreases its Y coordinate
		if(pos.y < 100) {//Is it almost off the bottom of the map?
			pos.x += 50;//Reset coordinates
			pos.y = 3950;
		}else if(pos.x > 2365) {//Is it off the right side of the map?
			pos.x = 800;//Reset coordinates
		}
	}
	
	//Moves Enemy4
	protected void moveEnemy5(float amount) {
		pos.y += amount;//Increases its X coordinate
		if(pos.y > 3900) {//Is it off the top of the map?
			pos.x -= 50;//Reset coordinates
			pos.y = 0;
		}else if(pos.x < 800) {//Is it off the left side of the map?
			pos.x = 2369;//Reset coordinates
		}
	}
	
	//Controls the direction of the player's attack
	protected void moveAttack(float amount) {
		//Dictates the direction the object moves in
		if(attackDirection) {//Left
			moveAttackLeft(amount);
		}else if(!attackDirection) {//Right
			moveAttackRight(amount);
		}
		
		if (Gdx.input.isKeyPressed(Keys.S)) {//Right
			attackDirection = false;
			//Sets the object to the players coordinates 
			this.pos.y = map.getPlayerY();
			this.pos.x = map.getPlayerX()+7;
		}else if(Gdx.input.isKeyPressed(Keys.A)){//Left
			attackDirection = true;
			//Sets the object to the players coordinates 
			this.pos.y = map.getPlayerY();
			this.pos.x = map.getPlayerX()-17;
		}
	}
	
	//Moves the player's attack right
	private void moveAttackRight(float amount) {
		pos.x += amount;//New X coordinate
		if(map.collideMap(pos.x-7, pos.y, getWidth(), getHeight())) {//Has it hit a wall
			//Make it disappear
			this.pos.x = 20;
			this.pos.y = 20;
		}
	}
	
	//Moves the player's attack left
	private void moveAttackLeft(float amount) {
		pos.x -= amount;//New X coordinate
		if(map.collideMap(pos.x+7, pos.y, getWidth(), getHeight())) {//Has it hit a wall
			//Make it disappear
			this.pos.x = 20;
			this.pos.y = 20;
		}
	}
	
	//Getters and Setters
	public Vector2 getPos() {
		return pos;
	}

	public EntityType getType() {
		return type;
	}

	public float getX() {
		return pos.x;
	}
	
	public float getY() {
		return pos.y;
	}
	
	public boolean isGrounded() {
		return grounded;
	}
	
	public int getWidth() {
		return type.getWidth();
	}
	
	public int getHeight() {
		return type.getHeight();
	}
	
	public float getWeight() {
		return type.getWeight();
	}
	
}
