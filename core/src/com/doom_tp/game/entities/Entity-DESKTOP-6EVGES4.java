package com.doom_tp.game.entities;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.IntIntMap;
import com.doom_tp.game.world.GameMap;


public abstract class Entity {
	protected Vector2 pos;
	protected EntityType type;
	protected float velocityY = 0;
	protected GameMap map;
	protected boolean grounded = false;
	private boolean direction = false;
	private boolean attackDirection = false;
	private boolean initialAttack = false;
	
	public Entity(float x,float y,EntityType type, GameMap map) {
		this.pos = new Vector2(x,y);
		this.type = type;
		this.map = map;
	}
	
	public void update (float deltaTime, float gravity) {
		float newY = pos.y;
		this.velocityY += gravity * deltaTime * getWeight();
		newY += this.velocityY * deltaTime;
		if (map.collideMap(pos.x, newY, getWidth(), getHeight())) {
			if (velocityY < 0) {
				this.pos.y = (float) Math.floor(pos.y);
				grounded = true;
			}
			this.velocityY = 0;
		}
		else {
			this.pos.y = newY;
			grounded = false;
		}
	}
	
	public abstract void render (SpriteBatch batch);

	protected void moveX(float amount) {
		float newX = pos.x + amount;
		if (!map.collideMap(newX, pos.y, getWidth(), getHeight())) {
			this.pos.x = newX;
		}
	}

	protected void moveEnemy1(float amount) {
		if(!direction) {
			float newX = pos.x+amount;
			float newY = pos.y+8;
			
			if(pos.x > 2335) {
				direction = true;
			}else if(!map.collideMap(newX, pos.y, getWidth(), getHeight())) {//Can it move forward?
				pos.x = newX;
			}else if(!map.collideMap(pos.x, newY, getWidth(), getHeight())) {//Can it move up;
				pos.y = newY;
			}
		}else if(direction) {
			float newX = pos.x-amount;
			float newY = pos.y+8;
			
			if(pos.x < 1930) {
				direction = false;
			}else if(!map.collideMap(newX, pos.y, getWidth(), getHeight())) {//Can it move forward?
				pos.x = newX;
			}else if(!map.collideMap(pos.x, newY, getWidth(), getHeight())) {//Can it move up;
				pos.y = newY;
			}
		}
	}
	protected void moveEnemy2(float amount) {
		if(!direction) {
			float newX = pos.x+amount;
			float newY = pos.y+8;
			
			if(pos.x > 2115) {
				direction = true;
			}else if(!map.collideMap(newX, pos.y, getWidth(), getHeight())) {//Can it move forward?
				pos.x = newX;
			}else if(!map.collideMap(pos.x, newY, getWidth(), getHeight())) {//Can it move up;
				pos.y = newY;
			}
		}else if(direction) {
			float newX = pos.x-amount;
			float newY = pos.y+8;
			
			if(pos.x < 1557) {
				direction = false;
			}else if(!map.collideMap(newX, pos.y, getWidth(), getHeight())) {//Can it move forward?
				pos.x = newX;
			}else if(!map.collideMap(pos.x, newY, getWidth(), getHeight())) {//Can it move up;
				pos.y = newY;
			}
		}
		
		/*if(!direction) {
			float newX = pos.x + amount;
			float newY = pos.y + 16;
			float oldY = pos.y;
			if(!map.collideMap(newX, pos.y, getWidth(), getHeight())) {//Can it go forward?
				pos.x = newX;
				return;
			}else if(!map.collideMap(pos.x, newY, getWidth(), getHeight())) {//Can it go up?
				pos.y = newY;
				if(!map.collideMap(newX, pos.y, getWidth(), getHeight())) {
					pos.x = newX;
					return;
				}else{
					pos.y = oldY;
					direction = true;
				}
			}else{
				direction = true;
			}
		}else if(direction) {
			float newX = pos.x - amount;
			float newY = pos.y + 16;
			float oldY = pos.y;
			if(!map.collideMap(newX, pos.y, getWidth(), getHeight())) {//Can it go forward?
				pos.x = newX;
				return;
			}else if(!map.collideMap(pos.x, newY, getWidth(), getHeight())) {//Can it go up?
				pos.y = newY;
				if(!map.collideMap(newX, pos.y, getWidth(), getHeight())) {
					pos.x = newX;
					return;
				}else{
					pos.y = oldY;
					direction = false;
				}
			}else{
				direction = false;
			}
		}*/
	}
	protected void moveEnemy3(float amount) {
		if(!direction) {
			float newX = pos.x+amount;
			float newY = pos.y+8;
			
			if(pos.x > 2306) {
				direction = true;
			}else if(!map.collideMap(newX, pos.y, getWidth(), getHeight())) {//Can it move forward?
				pos.x = newX;
			}else if(!map.collideMap(pos.x, newY, getWidth(), getHeight())) {//Can it move up;
				pos.y = newY;
			}
		}else if(direction) {
			float newX = pos.x-amount;
			float newY = pos.y+8;
			
			if(pos.x < 1140) {
				direction = false;
			}else if(!map.collideMap(newX, pos.y, getWidth(), getHeight())) {//Can it move forward?
				pos.x = newX;
			}else if(!map.collideMap(pos.x, newY, getWidth(), getHeight())) {//Can it move up;
				pos.y = newY;
			}
		}
	}
	protected void moveEnemy4(float amount) {
		pos.y -= amount;
		if(pos.y < 100) {
			pos.x += 50;
			pos.y = 3950;
		}else if(pos.x > 2365) {
			pos.x = 800;
		}
	}
	protected void moveEnemy5(float amount) {
		pos.y += amount;
		if(pos.y > 3900) {
			pos.x -= 50;
			pos.y = 0;
		}else if(pos.x < 800) {
			pos.x = 2369;
		}
	}
	
	protected void moveAttack(float amount) {
		if(attackDirection) {
			moveAttackLeft(amount);
		}else if(!attackDirection) {
			moveAttackRight(amount);
		}
		
		if (Gdx.input.isKeyPressed(Keys.S)) {
			attackDirection = false;//Right
			this.pos.y = map.getPlayerY();
			this.pos.x = map.getPlayerX()+7;
		}else if(Gdx.input.isKeyPressed(Keys.A)){
			attackDirection = true;//Left
			this.pos.y = map.getPlayerY();
			this.pos.x = map.getPlayerX()-16.1f;
		}
	}
	
	private void moveAttackRight(float amount) {
		pos.x += amount;
		if(map.collideMap(this.pos.x-7, this.pos.y, getWidth(), getHeight())) {
			this.pos.y = 20;
			this.pos.x = 20;
		}
	}
	private void moveAttackLeft(float amount) {
		pos.x -= amount;
		if(map.collideMap(this.pos.x+6.8f, this.pos.y, getWidth(), getHeight())) {
			this.pos.y = 20;
			this.pos.x = 20;
		}
	}
	
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
