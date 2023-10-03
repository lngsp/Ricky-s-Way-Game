package TileGame.gfx;

import TileGame.Entities.Entity;
import TileGame.Game;
import TileGame.Handler;
import TileGame.Tiles.Tile;


//Current view of our map
public class GameCamera {

    private Handler handler;
    private float xOffset, yOffset; //how much do you add/substract to the original positions

    public GameCamera(Handler handler, float xOffset, float yOffset){
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void checkBlanckSpace(){
        // daca, Camera ne afiseaza spatii albe
        if(xOffset < 0){    // se afiseaza spatii albe
            xOffset = 0;
        }else if(xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()){
            xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
        }

        if(yOffset < 0){    // se afiseaza spatii albe
            yOffset = 0;
        }else if(yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight()){
            yOffset = handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight();
        }
    }

    public void centerOnEntity(Entity e){
        // centreaza camera pe entitate (ex player) si o urmareste
        xOffset = e.getX() - handler.getWidth()/2 + e.getWidth() /2;
        yOffset = e.getY() - handler.getHeight()/2 + e.getHeight()/2;

        // Impartit la 2 pentru ca eroul sa fie in centrul ecranului
        checkBlanckSpace();
    }


    public void move(float xAmt, float yAmt){       // Move the camera
        xOffset += xAmt;            //xAmount
        yOffset += yAmt;
        checkBlanckSpace();
    }

    public float getxOffset() {
        return xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
}
