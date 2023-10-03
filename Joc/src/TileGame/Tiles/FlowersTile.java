package TileGame.Tiles;

import TileGame.gfx.Assets;

import java.awt.image.BufferedImage;

public class FlowersTile extends Tile{
    public FlowersTile(int id) {
        super(Assets.flowers, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
