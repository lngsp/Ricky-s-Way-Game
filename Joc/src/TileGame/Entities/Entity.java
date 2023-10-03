package TileGame.Entities;

import TileGame.Game;
import TileGame.Handler;

import java.awt.*;

/*

Player ----> Creature ---> Entity
Slim ------> Creature
Arrow -----> Item  ----> Entity

 */

public abstract class Entity {
    protected float x, y;   // pozitia pe ecran
    protected int width, height;
    protected int health;   // retine viata caracterului
    public static final int DEFAULT_HEALT = 1;      // valoarea implicită a vieții unui caracter
    protected Handler handler;
    protected Rectangle bounds;
    protected boolean active = true;

    public Entity(Handler handler, float x, float y, int width, int height){
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        bounds = new Rectangle(0, 0, width, height);
        health = DEFAULT_HEALT;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public boolean checkEntityCollisions(float xOffset, float yOffset){
        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this)){
                continue;
            }
            if(e.getCollisionBounds(0f,0f).intersects(getCollisionBounds(xOffset, yOffset)))
                return true;
        }
        return false;
    }

    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return new Rectangle((int)(x+bounds.x + xOffset),(int)(y + bounds.y + yOffset), bounds.width, bounds.height);
    }

    public abstract void die();

    public void hurt(int amt){
        health-=amt;
        if(health <= 0)
            active = false;
        die();
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }
}


