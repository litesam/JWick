package com.light.jwick.entity.spawner;

import com.light.jwick.entity.Entity;
import com.light.jwick.entity.particle.Particle;
import com.light.jwick.level.Level;

public class Spawner extends Entity {

	public enum Type {
		MOB, PARTICLE
	}
	
	private Type type;

	public Spawner(int x, int y, Type type, int amount, Level level) {
		init(level);
		this.x = x;
		this.y = y;
		this.type = type;
	}

}
