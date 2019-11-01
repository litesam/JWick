package com.light.jwick.entity.mob;

import com.light.jwick.Game;
import com.light.jwick.entity.projectile.Projectile;
import com.light.jwick.entity.projectile.WizardProjectile;
import com.light.jwick.graphics.AnimatedSprite;
import com.light.jwick.graphics.Screen;
import com.light.jwick.graphics.Sprite;
import com.light.jwick.graphics.SpriteSheet;
import com.light.jwick.input.Keyboard;
import com.light.jwick.input.Mouse;

public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;
	private short anim = 0;
	private boolean walking = false;
	private int flippy = 0;
	private boolean lastLeftClick = false;
	private AnimatedSprite down = new AnimatedSprite(SpriteSheet.playerDown, 32, 32, 3);
	private AnimatedSprite up = new AnimatedSprite(SpriteSheet.playerUp, 32, 32, 3);
	private AnimatedSprite left = new AnimatedSprite(SpriteSheet.playerLeft, 32, 32, 3);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.playerRight, 32, 32, 3);
	
	private AnimatedSprite animSprite = null;

	private int fireRate = 0;

	public Player(Keyboard input) {
		this.input = input;
		sprite = Sprite.playerBack;
		animSprite = down;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.playerBack;
		animSprite = down;
		fireRate = WizardProjectile.FIRE_RATE;
	}

	public void update() {
		if (walking) animSprite.update();
		else animSprite.setFrame(0);
		if (fireRate > 0) fireRate--;
		int xa = 0, ya = 0;
		if (anim < 9500) anim++;
		else anim = 0;
		// Updates the player straightly
//		if (input.up) y--;
//		if (input.down) y++;
//		if (input.left) x--;
//		if (input.right) x++;

		// Creates a local variable to support updation which is then updated by the mob
		if (input.up) {
			ya--;
			animSprite = up;
		}
		if (input.down) {
			ya++;
			animSprite = down;
		}
		if (input.left) {
			xa--;
			animSprite = left;
		}
		if (input.right) {
			xa++;
			animSprite = right;
		}
//		if (input.left || lastLeftClick) { // Making the sprite flip based on X-axis
//			flippy = 1;
//			lastLeftClick = true;
//		}
//		if (input.up || input.down || input.right) {
//			flippy = 0;
//			lastLeftClick = false;
//		}
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
		clear();
		updateShooting();
	}

	private void clear() {
		for (int i = 0; i < level.projectiles.size(); i++) {
			Projectile p = level.projectiles.get(i);
			if (p.isRemoved()) level.projectiles.remove(i);
		}
	}

	private void updateShooting() {
		if (Mouse.getButton() == 1 && fireRate <= 0) {
			double dx = Mouse.getX() - Game.getWindowWidth() / 2;
			double dy = Mouse.getY() - Game.getWindowHeight() / 2;
			double dir = Math.atan2(dy, dx); // TODO: Why the tan(inverse) and not tan!@@!@
			shoot(x, y, dir);
			fireRate = WizardProjectile.FIRE_RATE;
		}
	}

	public void render(Screen screen) {
		if (dir == 0) {
			sprite = Sprite.playerForward;
			if (walking) {
				if (anim % 20 > 10) sprite = Sprite.playerForward1;
				else sprite = Sprite.playerForward2;
			}
		}
		if (dir == 1 || dir == 3) {
			sprite = Sprite.playerRight;
			if (walking) {
				if (anim % 20 > 10) sprite = Sprite.playerRight1;
				else sprite = Sprite.playerRight2;
			}
		}
		if (dir == 2) {
			sprite = Sprite.playerBack;
			if (walking) {
				if (anim % 20 > 10) sprite = Sprite.playerBack1;
				else sprite = Sprite.playerBack2;
			}
		}
		sprite = animSprite.getSprite();
		screen.renderMob(x - 16, y - 16, flippy, sprite);
//		screen.renderPlayer(xx + 16, yy, Sprite.player1);
//		screen.renderPlayer(xx, yy + 16, Sprite.player2);
//		screen.renderPlayer(xx + 16, yy + 16, Sprite.player3);
	}

}
