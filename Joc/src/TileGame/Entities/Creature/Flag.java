package TileGame.Entities.Creature;

import TileGame.Handler;
import TileGame.gfx.Assets;

import java.awt.*;

public class Flag extends Creature{

    public Flag(Handler handler, float x, float y){
        super(handler, x, y, 100, 100);
    }


    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.flag, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        /*
        g.setColor(Color.blue);
        g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
                (int)(y + bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width, bounds.height);*/

    }

    @Override
    public void die() {

    }
    public Rectangle getBounds(){
        return new Rectangle((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
                (int)(y + bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width, bounds.height);
    }

}
