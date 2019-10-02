package com.light.jwick.level.tile.spawn_level;

import com.light.jwick.graphics.Screen;
import com.light.jwick.graphics.Sprite;
import com.light.jwick.level.tile.Tile;

public class SpawnWaterTile extends Tile {

	public SpawnWaterTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}

}
