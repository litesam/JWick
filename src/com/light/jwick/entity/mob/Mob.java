package com.light.jwick.entity.mob;

import com.light.jwick.entity.Entity;
import com.light.jwick.entity.projectile.Projectile;
import com.light.jwick.entity.projectile.WizardProjectile;
import com.light.jwick.graphics.Screen;
import com.light.jwick.graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = -1;
	protected boolean moving = false;
	protected boolean walking = false;
	
//	protected List<Projectile> projectiles = new ArrayList<Projectile>();

	protected void move(int xa, int ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}

		if (xa > 0) dir = 1; // east
		if (xa < 0) dir = 3; // west
		if (ya > 0) dir = 2; // south
		if (ya < 0) dir = 0; // north

		if (!collision(xa, ya)) {
			x += xa;
			y += ya;
		}
//		System.out.println(projectiles.size());
	}

	public abstract void update();
		
	public abstract void render(Screen screen);

	protected void shoot(int x, int y, double dir) {
//		dir *= 180 / Math.PI;
		Projectile p = new WizardProjectile(x, y, dir);
//		projectiles.add(p);
		level.add(p);
	}
	
	private boolean collision(int xa, int ya) {	// TODO: understand the function based that relies upon collision
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = ((x + xa) + c % 2 * 14 - 8) / 16;
			int yt = ((y + ya) + c / 2 * 12 + 3) / 16;
			if (level.getTile(xt, yt).solid()) solid = true;
		}
//		if (level.getTile((x + xa) / 16, (y + ya) / 16).solid()) solid = true; this is easy method for collision detection, but who cares!
		return solid;
	}


}
