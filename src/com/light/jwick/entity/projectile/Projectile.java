package com.light.jwick.entity.projectile;

import java.util.Random;

import com.light.jwick.entity.Entity;
import com.light.jwick.graphics.Sprite;

public class Projectile extends Entity {
	
	protected final int xOrigin, yOrigin;
	protected double angle;
	public Sprite sprite;
	protected double x, y;
	protected double nx, ny;
	protected double distance;
	protected double speed, rateOfFire, range, damage;
	
	protected final Random random = new Random();
	
	public Projectile(int x, int y, double dir) {
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.x = x;
		this.y = y;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public int getSpriteSize() {
		return sprite.SIZE;
	}

	protected void move() {
	}
}
