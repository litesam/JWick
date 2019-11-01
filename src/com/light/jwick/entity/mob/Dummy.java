package com.light.jwick.entity.mob;

import com.light.jwick.graphics.AnimatedSprite;
import com.light.jwick.graphics.Screen;
import com.light.jwick.graphics.Sprite;
import com.light.jwick.graphics.SpriteSheet;

public class Dummy extends Mob {
	
	private AnimatedSprite down = new AnimatedSprite(SpriteSheet.dummyDown, 32, 32, 3);
	private AnimatedSprite up = new AnimatedSprite(SpriteSheet.dummyUp, 32, 32, 3);
	private AnimatedSprite left = new AnimatedSprite(SpriteSheet.dummyLeft, 32, 32, 3);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.dummyRight, 32, 32, 3);
	
	public Dummy(int x, int y) {
		this.x = x << 4;
		this.y = y << 4;
		sprite = down;
	}

	public void update() {
		
	}

	public void render(Screen screen) {
//		screen.renderMob(x, y, 0, sprite);
	}

}
