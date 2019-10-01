package com.light.jwick.level.tile;

import com.light.jwick.graphics.Screen;
import com.light.jwick.graphics.Sprite;

public class Tile {
	
	public int x, y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile voidTile = new FlowerTile(Sprite.voidSprite);
	public static Tile flower = new RockTile(Sprite.flower);
	public static Tile rock = new GrassTile(Sprite.rock);
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
	}
	
	public boolean solid() {
		return false;
	}

}
