package com.light.jwick.entity.projectile;

import com.light.jwick.entity.Entity;
import com.light.jwick.graphics.Sprite;

public class Projectile extends Entity {
	
	protected final int xOrigin, yOrigin;
	protected double angle;
	protected Sprite sprite;
	protected double nx, ny;
	protected double speed, rateOfFire, range, damage;
	
	public Projectile(int x, int y, int dir) {
		xOrigin = x;
		yOrigin = y;
		angle = dir;
	}

	protected void move() {
	}
}
