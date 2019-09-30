package com.light.jwick.entity.mob;

import com.light.jwick.graphics.Screen;
import com.light.jwick.graphics.Sprite;
import com.light.jwick.input.Keyboard;

public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;
	private short anim = 0;
	private boolean walking = false;

	public Player(Keyboard input) {
		this.input = input;
		sprite = Sprite.playerBack;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.playerBack;
	}

	public void update() {
		int xa = 0, ya = 0;
		if (anim < 7500) anim++;
		else anim = 0;
		// Updates the player straightly
//		if (input.up) y--;
//		if (input.down) y++;
//		if (input.left) x--;
//		if (input.right) x++;

		// Creates a local variable to support updation which is then updated by the mob
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}

	}

	public void render(Screen screen) {
		if (dir == 0) { 
			sprite = Sprite.playerForward;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.playerForward1;
				} else {
					sprite = Sprite.playerForward2;
				}
			}
		}
		if (dir == 1) sprite = Sprite.playerRight;
		if (dir == 2) sprite = Sprite.playerBack;
		if (dir == 3) sprite = Sprite.playerLeft;
		screen.renderPlayer(x - 16, y - 16, sprite);
//		screen.renderPlayer(xx + 16, yy, Sprite.player1);
//		screen.renderPlayer(xx, yy + 16, Sprite.player2);
//		screen.renderPlayer(xx + 16, yy + 16, Sprite.player3);
	}

}
