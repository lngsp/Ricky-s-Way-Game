package TileGame.Tiles;

import TileGame.gfx.Assets;

public class Fantana2Tile extends Tile
{
    public Fantana2Tile(int id)
    {
        super(Assets.fantana2, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}