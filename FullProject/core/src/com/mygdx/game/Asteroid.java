package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {
    private Vector2 position;
    private float speed;
    private static Texture texture;
    private float angle;
    private float scale;
    private Circle hitArea;

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

    public static Texture getTexture() {
        return texture;
    }

    public static void setTexture(Texture texture) {
        Asteroid.texture = texture;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public Circle getHitArea() {
        return hitArea;
    }

    public void setHitArea(Circle hitArea) {
        this.hitArea = hitArea;
    }

    public Asteroid() {
        position = new Vector2(1280 * (float) Math.random()+1280, 720 * (float) Math.random());
        speed = 4.0f + (float) Math.random() * 4.0f;
        angle = (float)Math.random()*360;
        scale = 0.8f + (float)Math.random()*1.2f;
        if (texture == null) {
            texture = new Texture("asteroid64.png");
        }
        hitArea = new Circle(position.x, position.y, 32*scale);
    }

    public void recreate() {
        position.x = 1280 * (float) Math.random()+1280;
        position.y = 720 * (float) Math.random();
        speed = 4.0f + (float) Math.random() * 4.0f;
        scale = 0.8f + (float)Math.random()*1.2f;
        hitArea.radius = 32*scale;
    }

    public void render(SpriteBatch batch){
        batch.draw(texture, position.x-32, position.y-32,32,32,64,64,scale,scale,angle,0,0,64,64,false,false);
    }
    public void update() {
        position.x -= speed;
        angle += speed/2;
        if (position.x < -100) {
            recreate();
        }
        hitArea.x = position.x;
        hitArea.y = position.y;
    }
}
