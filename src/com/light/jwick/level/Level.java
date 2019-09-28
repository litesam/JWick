package com.light.jwick.level;

import com.light.jwick.graphics.Screen;

public class Level {

	protected int width, height;
	protected int[] tiles;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[this.width * this.height];
		generateLevel();
	}
	
	public Level(String path) {
		loadLevel(path);
	}
	
	protected void generateLevel() {
	}
	
	private void loadLevel(String path) {
	}
	
	public void update() {
	}
	
	private void time() {
	}
	
	public void render(int xScroll, int yScroll, Screen screen) {
	}
	
}
