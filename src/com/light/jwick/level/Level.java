package com.light.jwick.level;

import java.util.ArrayList;
import java.util.List;

import com.light.jwick.entity.Entity;
import com.light.jwick.entity.particle.Particle;
import com.light.jwick.entity.projectile.Projectile;
import com.light.jwick.graphics.Screen;
import com.light.jwick.level.tile.Tile;

public class Level {

//	protected Tile[] tiles;
	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;

	private List<Entity> entities = new ArrayList<Entity>(); // TODO: Major code change going on!!!!! (About List here and Mob)
	public List<Projectile> projectiles = new ArrayList<Projectile>();
	public List<Particle> particles = new ArrayList<Particle>();

	public static Level spawn = new SpawnLevel("/levels/spawn.png");

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[this.width * this.height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}

	protected void generateLevel() {
	}

	protected void loadLevel(String path) {
	}

	public void update() {
		for (Entity e : entities)
			e.update();
		for (Projectile p : projectiles)
			p.update();
		for (Particle p : particles)
			p.update();
		remove();
	}

	private void remove() {
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i).isRemoved()) entities.remove(i);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).isRemoved()) projectiles.remove(i);
		}
		for (int i = 0; i < particles.size(); i++) {
			if (particles.get(i).isRemoved()) particles.remove(i);
		}
	}

	private void time() {
	}

	public boolean tileCollision(double x, double y, double xa, double ya, int size) { // TODO: understand the function based that relies upon collision
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = (((int) x + (int) xa) + c % 2 * size / 2 - 5) / 16;
			int yt = (((int) y + (int) ya) + c / 2 * size / 2 + 5) / 16;
			if (getTile(xt, yt).solid()) solid = true;
		}
//		if (level.getTile((x + xa) / 16, (y + ya) / 16).solid()) solid = true; this is easy method for collision detection, but who cares!
		return solid;
	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}

		for (Entity e : entities)
			e.render(screen);
		for (Projectile p : projectiles)
			p.render(screen);
		for (Particle p : particles)
			p.render(screen);
	}

	public void add(Entity e) {
		e.init(this);
		if (e instanceof Particle) {
			particles.add((Particle) e);
		} else if (e instanceof Projectile) {
			projectiles.add((Projectile) e);
		} else {
			entities.add(e);
		}
	}

	// Grass = 0x00ff00
	// Flower = 0xffff00
	// Rock = 0x7f7f00
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if (tiles[x + y * width] == Tile.COL_SPAWN_FLOOR) return Tile.spawnFloor;
		if (tiles[x + y * width] == Tile.COL_SPAWN_GRASS) return Tile.spawnGrass;
		if (tiles[x + y * width] == Tile.COL_SPAWN_HEDGE) return Tile.spawnHedge;
		if (tiles[x + y * width] == Tile.COL_SPAWN_WALL1) return Tile.spawnWall1;
		if (tiles[x + y * width] == Tile.COL_SPAWN_WALL2) return Tile.spawnWall2;
		if (tiles[x + y * width] == Tile.COL_SPAWN_WATER) return Tile.spawnWater;
		return Tile.voidTile;
	}

}
