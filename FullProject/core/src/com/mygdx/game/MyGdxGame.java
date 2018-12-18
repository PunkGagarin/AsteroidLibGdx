package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
    //создаём ресурсы
    //область отрисовки
    private SpriteBatch batch;
    //Texture img;

    private Background background;
    private Hero hero;
    //массив астероидов
    private Asteroid[] asteroids;
    private Texture textureBullet;
    static Bullet[] bullets;

    @Override
    public void create() {
        batch = new SpriteBatch();
        //img = new Texture("asteroid64.png");
        background = new Background();
        hero = new Hero();
        asteroids = new Asteroid[25];
        for (int i = 0; i < asteroids.length; i++) {
            asteroids[i] = new Asteroid();
        }
        textureBullet = new Texture("bullet64x32.png");
        bullets = new Bullet[100];
        for (int i = 0; i < bullets.length; i++) {
            bullets[i] = new Bullet();

        }
    }

    @Override
    public void render() {
        update();
        Gdx.gl.glClearColor(0.4f, 0, 1, 0.5f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.render(batch);
        hero.render(batch);
        for (int i = 0; i < asteroids.length; i++) {
            asteroids[i].render(batch);
        }
        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i].isActive()) {
                batch.draw(textureBullet, bullets[i].getPosition().x-32, bullets[i].getPosition().y-16);
            }
        }
        batch.end();
    }

    public void update() {
        background.update();
        hero.update();
        for (int i = 0; i < asteroids.length; i++) {
            asteroids[i].update();
        }
        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i].isActive()) {
                bullets[i].update();
                for (int j = 0; j < asteroids.length; j++) {
                    if(asteroids[j].getHitArea().contains(bullets[i].getPosition())){
                        asteroids[j].recreate();
                        bullets[i].disable();
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        //img.dispose();
    }
}
