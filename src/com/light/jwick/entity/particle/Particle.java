package com.light.jwick.entity.particle;

import com.light.jwick.entity.Entity;
import com.light.jwick.graphics.Screen;
import com.light.jwick.graphics.Sprite;

public class Particle extends Entity {

	private Sprite sprite;

	private int life;
	private int time = 0;

	protected double xx, yy, zz;
	protected double xa, ya, za;

	public Particle(int x, int y, int life) {
		this.x = x;
		this.y = y;
		this.xx = x;
		this.yy = y;
		this.life = life + (random.nextInt(20) - 10);
		sprite = Sprite.particleNormal;

		this.xa = random.nextGaussian() + 1.8;
		if (this.xa < 0) xa = 0.1;
		this.ya = random.nextGaussian();
		this.zz = random.nextFloat() + 2.0;
	}

	public void update() { // TODO: E80 physics
		time++;
		if (time > 7400) time = 0;
		if (time > life) remove();
		za -= 0.1;
		if (zz < 0) {
			zz = 0;
			za *= -0.5;
			xa *= 0.8;
			ya *= 0.5;
		}

		this.xx += xa;
		this.yy += ya;
		this.zz += za;
	}

	public void render(Screen screen) {
		screen.renderSprite((int) xx - 12, (int) (yy - zz), sprite, true);
	}

}
