package com.light.jwick.entity.projectile;

public class WizardProjectile extends Projectile {

	public WizardProjectile(int x, int y, int dir) {
		super(x, y, dir);
		range = 200;
		speed = 4;
		damage = 20;
		rateOfFire = 15;

		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}
	
	public void update() {
		move();
	}

}
