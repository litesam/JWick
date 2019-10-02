package com.light.jwick.level.tile;

import com.light.jwick.graphics.Screen;
import com.light.jwick.graphics.Sprite;
import com.light.jwick.level.tile.spawn_level.SpawnFloorTile;
import com.light.jwick.level.tile.spawn_level.SpawnGrassTile;
import com.light.jwick.level.tile.spawn_level.SpawnHedgeTile;
import com.light.jwick.level.tile.spawn_level.SpawnWallTile;
import com.light.jwick.level.tile.spawn_level.SpawnWaterTile;

public class Tile {

	public int x, y;
	public Sprite sprite;

	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile voidTile = new FlowerTile(Sprite.voidSprite);
	public static Tile flower = new RockTile(Sprite.flower);
	public static Tile rock = new GrassTile(Sprite.rock);

	public static Tile spawnGrass = new SpawnGrassTile(Sprite.spawnGrass);
	public static Tile spawnHedge = new SpawnHedgeTile(Sprite.spawnHedge);
	public static Tile spawnWater = new SpawnWaterTile(Sprite.spawnWater);
	public static Tile spawnWall1 = new SpawnWallTile(Sprite.spawnWall1);
	public static Tile spawnWall2 = new SpawnWallTile(Sprite.spawnWall2);
	public static Tile spawnFloor = new SpawnFloorTile(Sprite.spawnFloor);

	public static final int COL_SPAWN_GRASS = 0xff00ff00;
	public static final int COL_SPAWN_HEDGE = 0;
	public static final int COL_SPAWN_WATER = 0;
	public static final int COL_SPAWN_WALL1 = 0xff808080;
	public static final int COL_SPAWN_WALL2 = 0xff303030;
	public static final int COL_SPAWN_FLOOR = 0xff724715;
	

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {
	}

	public boolean solid() {
		return false;
	}

}
