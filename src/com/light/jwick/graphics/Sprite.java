package com.light.jwick.graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;

	public static Sprite grass = new Sprite(16, 0, 5, SpriteSheet.tiles);
	public static Sprite flower = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0x1b87e0);

	// Spawn Level Sprites:
	public static Sprite spawnGrass = new Sprite(16, 0, 0, SpriteSheet.spawnLevel);
	public static Sprite spawnHedge = new Sprite(16, 1, 0, SpriteSheet.spawnLevel);
	public static Sprite spawnWater = new Sprite(16, 2, 0, SpriteSheet.spawnLevel);
	public static Sprite spawnWall1 = new Sprite(16, 0, 1, SpriteSheet.spawnLevel);
	public static Sprite spawnWall2 = new Sprite(16, 0, 2, SpriteSheet.spawnLevel);
	public static Sprite spawnFloor = new Sprite(16, 1, 1, SpriteSheet.spawnLevel);

	// Sprites loader for player
//	public static Sprite player0 = new Sprite(16, 0, 10, SpriteSheet.tiles);
//	public static Sprite player1 = new Sprite(16, 1, 10, SpriteSheet.tiles);
//	public static Sprite player2 = new Sprite(16, 0, 11, SpriteSheet.tiles);
//	public static Sprite player3 = new Sprite(16, 1, 11, SpriteSheet.tiles);
	// Sprites in single load
	public static Sprite playerForward = new Sprite(32, 0, 5, SpriteSheet.tiles);
	public static Sprite playerBack = new Sprite(32, 2, 5, SpriteSheet.tiles);
	public static Sprite playerRight = new Sprite(32, 1, 5, SpriteSheet.tiles);

	public static Sprite playerForward1 = new Sprite(32, 0, 6, SpriteSheet.tiles);
	public static Sprite playerForward2 = new Sprite(32, 0, 7, SpriteSheet.tiles);
	
	public static Sprite playerRight1 = new Sprite(32, 1, 6, SpriteSheet.tiles);
	public static Sprite playerRight2 = new Sprite(32, 1, 7, SpriteSheet.tiles);
	
	public static Sprite playerBack1 = new Sprite(32, 2, 6, SpriteSheet.tiles);
	public static Sprite playerBack2 = new Sprite(32, 2, 7, SpriteSheet.tiles);

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;
		load();
	}

	public Sprite(int size, int colour) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColour(colour);
	}

	private void setColour(int colour) {
		for (int i = 0; i < SIZE * SIZE; i++) {
			pixels[i] = colour;
		}
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}

}
