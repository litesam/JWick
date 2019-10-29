package com.light.jwick.entity.projectile;

import com.light.jwick.entity.spawner.ParticleSpawner;
import com.light.jwick.entity.spawner.Spawner;
import com.light.jwick.graphics.Screen;
import com.light.jwick.graphics.Sprite;

public class WizardProjectile extends Projectile {

	public static final int FIRE_RATE = 8;

	public WizardProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = 200;
		speed = 4;
		damage = 20;
//		rateOfFire = 15;
		sprite = Sprite.projectileWizard;
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}

	public void update() {
		if (level.tileCollision(x, y, nx, ny, 7)) {
			level.add(new ParticleSpawner((int) x, (int) y, 44, 50, level));
			remove();
		}
		move();
	}

	protected void move() {
		x += nx;
		y += ny;
		if (distance() > range) remove();
	}

	private double distance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin - x) * (xOrigin - x)) + Math.abs((yOrigin - y) * (yOrigin - y)));
		return dist;
	}

	public void render(Screen screen) {
		screen.renderProjectile((int) x, (int) y, this);
	}

}
