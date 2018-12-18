package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Hero {
    private Texture texture;
    private float speed;
    private Vector2 position;
    private int fireRate;
    private int fireCounter;

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public int getFireRate() {
        return fireRate;
    }

    public void setFireRate(int fireRate) {
        this.fireRate = fireRate;
    }

    public int getFireCounter() {
        return fireCounter;
    }

    public void setFireCounter(int fireCounter) {
        this.fireCounter = fireCounter;
    }

    public Hero() {
        texture = new Texture("ship64.png");
        speed = 9.0f;
        position = new Vector2(100.0f, 328.0f);
        fireRate = 12;
        fireCounter = 10;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.W))
            position.y += speed;
        if (Gdx.input.isKeyPressed(Input.Keys.S))
            position.y -= speed;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            position.x -= speed / 1.5f;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D))
            position.x += speed;

        if (Gdx.input.isTouched()) {
            if (Gdx.input.getX() < position.x + 32) {
                position.x -= speed;
            }
            if (Gdx.input.getX() > position.x + 32) {
                position.x += speed;
            }
            if (720 - Gdx.input.getY() < position.y + 32) {
                position.y -= speed;
            }
            if (720 - Gdx.input.getY() > position.y + 32) {
                position.y += speed;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.L)) {
            fireCounter++;
            if (fireCounter >= fireRate) {
                fireCounter = 0;
                fire();
            }
        }



        if (position.x < 0)
            position.x = 0;
        if (position.x > 1216)
            position.x = 1216;
        if (position.y > 720)
            position.y = -64;
        if (position.y < -64)
            position.y = 720;
    }

    public void fire() {
        for (int i = 0; i < MyGdxGame.bullets.length; i++) {
            if (!MyGdxGame.bullets[i].isActive()) {
                MyGdxGame.bullets[i].enable(position.x + 48, position.y + 32);
                break;
            }
        }
    }
}
