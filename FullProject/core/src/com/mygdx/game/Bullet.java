package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Bullet {

    private Vector2 position;
    private float speed;
    private boolean isActive;



    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Bullet() {
        position = new Vector2(0, 0);
        speed = 14.0f;
        isActive = false;
    }

    public void disable(){
        isActive = false;
    }

    public void enable(float x, float y){
        position.x = x;
        position.y = y;
        isActive = true;
    }
    public void update() {
        position.x += speed;
        if (position.x >1280) {
            disable();
        }
    }
}
