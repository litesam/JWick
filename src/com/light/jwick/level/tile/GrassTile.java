package com.light.jwick.level.tile;

import com.light.jwick.graphics.Screen;
import com.light.jwick.graphics.Sprite;

public class GrassTile extends Tile {
	
	public GrassTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x, y, this);
	}

}
