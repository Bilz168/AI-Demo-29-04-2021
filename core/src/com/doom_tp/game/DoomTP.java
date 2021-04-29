package com.doom_tp.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.doom_tp.game.world.CustomGameMap;
import com.doom_tp.game.world.GameMap;
import com.doom_tp.game.world.TiledGameMap;

public class DoomTP extends ApplicationAdapter {
	
	SpriteBatch batch;
	OrthographicCamera camera;
	
	GameMap gameMap;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.update();
		gameMap = new TiledGameMap();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
//		if(Gdx.input.isTouched()) {
//			camera.translate(-Gdx.input.getDeltaX(), Gdx.input.getDeltaY());		
//			camera.update();
//		}
//		
//		if (Gdx.input.justTouched() ) {
//			Vector3 pos = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
//			TileType type = gameMap.getTileTypeByLocation(1, pos.x, pos.y);
//			
//			if (type != null) {
//				System.out.println("You clicked on tile with id: " + type.getId() + " " + type.getName() + " " + type.isCollidable() + " " + type.getDamage());
//			}
//		}
		camera.update();
		gameMap.update(Gdx.graphics.getDeltaTime());
		gameMap.render(camera, batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		gameMap.dispose();
	}
}
