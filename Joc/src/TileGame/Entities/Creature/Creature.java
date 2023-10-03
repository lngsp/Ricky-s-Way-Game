package TileGame.Entities.Creature;

import TileGame.Entities.Entity;
import TileGame.Game;
import TileGame.Handler;
import TileGame.Tiles.Tile;

public abstract class Creature extends Entity {

   public static final float DEFAULT_SPEED = 3.0f;     // valoarea implicită a vitezei unui caracter
    public static final int DEFAULT_CREATURE_WIDTH = 80,    // Latimea implicita a imaginii caracterului
                DEFAULT_CREATURE_HEIGHT = 80;               // Inaltimea implicita a imaginii caracterului

    protected float speed;  // reține viteză caracterului
    protected float xMove, yMove;   // Retine noua pozitie a caracterului pe axa X, pe axa Y

    public Creature(Handler handler, float x, float y, int width, int height) {
        ///Apel constructor la clasei de baza
        super(handler, x, y,width, height);
        //Seteaza pe valorile implicite pentru viata, viteza si distantele de deplasare
        speed = DEFAULT_SPEED;
        xMove=0;
        yMove=0;
    }

    public void move(){   //  Modifica pozitia caracterului
       if(!checkEntityCollisions(xMove, 0f)) {
           moveX();
       }
        if(!checkEntityCollisions(0f, yMove)) {
            moveY();
        }
    }


    public void moveX(){
        // ///Aduna la pozitia curenta numarul de pixeli cu care trebuie sa se deplaseze pe axa X.

        if(xMove > 0){//Moving right
            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
            // positia x-ul dalei in care incercam sa ne mutam
            // fara Tile.TILEWIDT este dimensiunea in pixeli

            if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
                    !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT))
                // daca nu este nici o coleziune vom muta player-ul
            {
                x += xMove;
            }else{  // este o coleziune cu player-ul cand se muta la dreapta
                x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
            }

        }else if(xMove < 0){//Moving left
            int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;

            if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
                    !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
                x += xMove;
            }else{
                x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
            }

        }
    }

    public void moveY(){
        // ///Aduna la pozitia curenta numarul de pixeli cu care trebuie sa se deplaseze pe axa Y.

        if(yMove < 0){//Up
            int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;

            if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
                    !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
                y += yMove;
            }else{
                y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
            }

        }else if(yMove > 0){//Down
            int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;

            if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
                    !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
                y += yMove;
            }else{
                y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
            }

        }
    }



    // Coliziune!!
    protected boolean collisionWithTile(int x, int y){
        // Daca este solid returneaza true, altfel false
        return handler.getWorld().getTile(x,y).isSolid();
    }

    //GETTERS & SETTERS
    public float getSpeed() {
        return speed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
}
