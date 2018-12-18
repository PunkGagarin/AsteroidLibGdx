package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Background {
    private Texture texture;
    private Texture textureStar;
    private Star[] stars;

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Texture getTextureStar() {
        return textureStar;
    }

    public void setTextureStar(Texture textureStar) {
        this.textureStar = textureStar;
    }

    public Star[] getStars() {
        return stars;
    }

    public void setStars(Star[] stars) {
        this.stars = stars;
    }

    public Background() {
        texture = new Texture("bg.png");
        textureStar = new Texture("star12.tga");
        stars = new Star[240];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star();
        }
    }

    public void render(SpriteBatch batch){
        batch.draw(texture, 0, 0);
        for (int i = 0; i < stars.length; i++) {
            batch.draw(textureStar, stars[i].position.x, stars[i].position.y);
        }
    }

    class Star{
        Vector2 position;
        float speed;
        float scale;

        public Star(){
            position = new Vector2(1280 * (float)Math.random(), 720 * (float)Math.random());
            speed = 1.0f + (float)Math.random()*4.0f;
            scale = 0.8f + 1.2f*speed/5;
        }

        public void update(){
            position.x -= speed;
            if(position.x <-20){
                position.x = 1280;
                position.y = 720 * (float)Math.random();
                speed = 1.0f + (float)Math.random()*4.0f;
            }
        }
    }

    public void update(){
        for (int i = 0; i < stars.length; i++) {
            stars[i].update();
        }
    }

}
