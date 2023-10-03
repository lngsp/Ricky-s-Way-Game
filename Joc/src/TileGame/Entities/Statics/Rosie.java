package TileGame.Entities.Statics;

import TileGame.Handler;
import TileGame.Items.Item;
import TileGame.Tiles.Tile;
import TileGame.gfx.Assets;

import java.awt.*;

public class Rosie extends StaticEntity {
    public Rosie(Handler handler, float x, float y){
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);

        bounds.x = 10;
        bounds.y = (int)(height/1.5f);
        bounds.width = width - 20;
        bounds.height = (int)(height - height/1.5f);
    }

    @Override
    public void tick() {

    }

    public void die(){
        handler.getWorld().getItemManager().addItem(Item.rosieItem.createNew((int) x, (int) y));

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.rosie,(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }
}
