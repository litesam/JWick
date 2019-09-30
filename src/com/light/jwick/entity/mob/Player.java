package com.light.jwick.entity.mob;

import com.light.jwick.input.Keyboard;

public class Player extends Mob {

	private Keyboard input;

	public Player(Keyboard input) {
		this.input = input;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
	}

	public void update() {
		int xa = 0, ya = 0;

		// Updates the player straightly
		if (input.up) y--;
		if (input.down) y++;
		if (input.left) x--;
		if (input.right) x++;

		// Creates a local variable to support updation which is then updated by the mob
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;
		move(xa, ya);

	}

	public void render() {
	}

}
